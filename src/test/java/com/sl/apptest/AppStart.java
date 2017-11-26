package com.sl.apptest;

import com.sl.httputil.JavaHttpRequest;
import com.sl.httputil.entity.HttpRequestParam;
import com.sl.httputil.entity.HttpResponseResult;
import com.sl.httputil.entity.ProxyIP;

public class AppStart {
	/**
	 * 
	 * @param args
	 * @throws Exception
	 * @throws WriteException
	 */
	public static void main(String[] args) throws Exception {
		HttpRequestParam requestParam = null;
		try {
			requestParam = new HttpRequestParam();
			// requestParam.setUrl("http://www.517na.com/");
			requestParam.setUrl("https://list.jd.com/list.html?cat=9987,653,655");
			requestParam.setMethod("get");
			// requestParam.setUseProxy(true);
			ProxyIP proxyip = new ProxyIP();
			proxyip.setProxyPort(8888);
			proxyip.setProxyServerAddress("127.0.0.1");
			requestParam.setProxyip(proxyip);
			requestParam.setReadTimeout(100);
			requestParam.setConnetcTimeout(100);
			// requestParam.setUseHttps(false);
			requestParam.setUseHttps(true);
			requestParam.setAcceptType(
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			HttpResponseResult temp = JavaHttpRequest.getRequestResult(requestParam);
			if (temp != null) {
				System.out.println(temp.getHtmlStringResult());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
