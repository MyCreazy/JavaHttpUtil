package com.sl.httputil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.sl.httputil.entity.HtmlContentType;
import com.sl.httputil.entity.HttpRequestParamVo;
import com.sl.httputil.entity.HttpResponseResultVo;

/**
 * HTTP请求
 * 
 * @author Administrator Nov 24, 2017
 */
public class JavaHttpRequest {

	/**
	 * 读取页面流
	 * 
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	private static byte[] readPageStream(InputStream inStream) throws Exception {
		byte[] result = null;
		ByteArrayOutputStream outStream = null;
		try {
			outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			// 每次读取的字符串长度，如果为-1，代表全部读取完毕
			int len = 0;
			// 使用一个输入流从buffer里把数据读取出来
			while ((len = inStream.read(buffer)) != -1) {
				// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
				outStream.write(buffer, 0, len);
			}
			result = outStream.toByteArray();
		} finally {
			if (inStream != null) {
				// 关闭输入流
				inStream.close();
			}

			if (outStream != null) {
				outStream.close();
			}
		}

		return result;
	}

	/**
	 * 获取HTTPS请求的连接
	 * 
	 * @param requestParam
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	private static HttpsURLConnection getHttpsConnect(HttpRequestParamVo requestParam)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		URL url = null;
		HttpsURLConnection conn = null;
		try {
			String requesturl = requestParam.getUrl();
			url = new URL(null, requesturl, new sun.net.www.protocol.https.Handler());
			//// 判断是否使用代理
			if (requestParam.isUseProxy()) {
				//// 如果使用代理
				Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(
						requestParam.getProxyip().getProxyServerAddress(), requestParam.getProxyip().getProxyPort()));
				conn = (HttpsURLConnection) url.openConnection(proxy);
			} else {
				conn = (HttpsURLConnection) url.openConnection();
			}

			conn.setRequestMethod(requestParam.getMethod().toUpperCase());
			//// 使用HTTPS请求，那么则需要证书等相关信息
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = { new HttpX509Manager() };
			// 初始化
			sslContext.init(null, tm, new java.security.SecureRandom());
			;
			// 获取SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			conn.setSSLSocketFactory(sslContext.getSocketFactory());
			conn.setHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});

			conn.setSSLSocketFactory(ssf);
			conn = (HttpsURLConnection) buildRequestParam(conn, requestParam);
			String outputStr = requestParam.getCommitparam();
			// 往服务器端写内容
			if (null != outputStr && !"".equals(outputStr)) {
				OutputStream os = conn.getOutputStream();
				os.write(outputStr.getBytes(requestParam.getEncodeType()));
				os.close();
			}

			conn.connect();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		return conn;
	}

	/**
	 * 构造请求出参数
	 * 
	 * @param conn
	 * @param requestParam
	 * @return
	 */
	private static URLConnection buildRequestParam(URLConnection conn, HttpRequestParamVo requestParam) {
		//// 如果是post请求，这两个参数需要进行设置
		if (requestParam.getMethod().toLowerCase() == "post") {
			conn.setDoOutput(true);
			conn.setDoInput(true);
		}
		conn.setConnectTimeout(requestParam.getConnetcTimeout() * 1000);
		conn.setReadTimeout(requestParam.getReadTimeout() * 1000);
		conn.setUseCaches(requestParam.isUseCache());
		conn.setRequestProperty("Cookie", requestParam.getCookie());
		conn.setRequestProperty("Referer", requestParam.getReferUrl());
		conn.setRequestProperty("Accept", requestParam.getAcceptType());
		conn.setRequestProperty("Content-Type", requestParam.getContentType());
		conn.setRequestProperty("User-Agent", requestParam.getUserAgent());
		return conn;
	}

	/**
	 * 获取HTTP连接
	 * 
	 * @param requestParam
	 * @return
	 * @throws IOException
	 */
	private static HttpURLConnection getHttpConnect(HttpRequestParamVo requestParam) throws IOException {
		URL url = null;
		HttpURLConnection conn = null;
		try {
			String requesturl = requestParam.getUrl();
			url = new URL(requesturl);
			//// 判断是否使用代理
			if (requestParam.isUseProxy()) {
				//// 如果使用代理
				Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(
						requestParam.getProxyip().getProxyServerAddress(), requestParam.getProxyip().getProxyPort()));
				conn = (HttpURLConnection) url.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) url.openConnection();
			}

			conn.setRequestMethod(requestParam.getMethod().toUpperCase());
			conn = (HttpURLConnection) buildRequestParam(conn, requestParam);
			String outputStr = requestParam.getCommitparam();
			// 往服务器端写内容
			if (null != outputStr && !"".equals(outputStr)) {
				OutputStream os = conn.getOutputStream();
				os.write(outputStr.getBytes(requestParam.getEncodeType()));
				os.close();
			}

			conn.connect();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		return conn;
	}

	/**
	 * 解析结果
	 * 
	 * @param requestParam
	 * @param inputstream
	 * @param responseCookie
	 * @return
	 * @throws Exception
	 */
	private static HttpResponseResultVo analysisResult(HttpRequestParamVo requestParam, InputStream inputstream,
			URLConnection conn) throws Exception {
		HttpResponseResultVo responseResult = new HttpResponseResultVo();
		StringBuffer buffer = null;
		InputStreamReader inputstreamread = null;
		try {
			if (requestParam.getHtmlResultType() == HtmlContentType.HtmlString) {
				//// 这里还要判断一下是否是压缩包
				if (requestParam.isTranGzip()) {
					GZIPInputStream gzin = new GZIPInputStream(inputstream);
					inputstreamread = new InputStreamReader(gzin, requestParam.getEncodeType());
				} else {
					inputstreamread = new InputStreamReader(inputstream, requestParam.getEncodeType());
				}
				BufferedReader br = new BufferedReader(inputstreamread);
				buffer = new StringBuffer();
				String line = null;
				while ((line = br.readLine()) != null) {
					buffer.append(line);
				}

				responseResult.setHtmlStringResult(buffer.toString());
			} else {
				//// byte[]数组
				byte[] data = readPageStream(inputstream);
				responseResult.setHtmlByteResult(data);
			}

			String responseCookie = conn.getHeaderField("Set-Cookie");
			responseResult.setCookie(responseCookie);
		} finally {
			if (inputstreamread != null) {
				inputstreamread.close();
			}
			if (inputstream != null) {
				inputstream.close();
			}
		}

		responseResult.setSuccess(true);

		return responseResult;
	}

	/**
	 * 获取请求结果
	 * 
	 * @param requestParam
	 * @return
	 * @throws Exception
	 */
	public static HttpResponseResultVo getRequestResult(HttpRequestParamVo requestParam) throws Exception {
		HttpResponseResultVo responseResult = new HttpResponseResultVo();
		URLConnection conn = null;
		InputStream inputstream = null;
		try {
			//// 检查是否符合URL规范,简单检查比如是否带上HTTP或者https
			String requesturl = requestParam.getUrl();
			if (!requesturl.toLowerCase().contains("http") && !requesturl.toLowerCase().contains("https")) {
				if (requestParam.isUseHttps()) {
					requesturl = "https://" + requesturl;
					requestParam.setUrl(requesturl);
				} else {
					requesturl = "http://" + requesturl;
					requestParam.setUrl(requesturl);
				}
			}

			if (requestParam.isUseHttps()) {
				conn = getHttpsConnect(requestParam);
			} else {
				conn = getHttpConnect(requestParam);
			}

			inputstream = conn.getInputStream();
			responseResult = analysisResult(requestParam, inputstream, conn);
		} catch (Exception e) {
			throw e;
		}

		return responseResult;
	}
}
