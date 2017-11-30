package com.sl.httputil.entity;

/**
 * HTTP 请求参数
 * 
 * @author Administrator Nov 24, 2017
 */
public class HttpRequestParamVo {
	/**
	 * 请求的URL地址
	 */
	private String url = "";

	/**
	 * cookie
	 */
	private String cookie = "";

	/**
	 * 提交的参数
	 */
	private String commitparam = "";

	/**
	 * 请求类型
	 */
	private String method = "";

	/**
	 * 超时时间，默认为10秒
	 */
	private int connetcTimeout = 10;

	/**
	 * 读取超时时间，默认为10秒
	 */
	private int readTimeout = 10;

	/**
	 * 是否使用代理
	 */
	private boolean useProxy = false;

	/**
	 * 使用HTTPS请求
	 */
	private boolean useHttps = false;

	/**
	 * 使用的代理
	 */
	private String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36";

	/**
	 * 指定请求信息的格式（发送端）
	 */
	private String contentType = "application/x-www-form-urlencoded";

	/**
	 * 客户端希望接收的数据类型
	 */
	private String acceptType = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";

	/**
	 * 编码格式
	 */
	private String encodeType = "utf-8";

	/**
	 * 代理IP
	 */
	private ProxyIPVo proxyip = new ProxyIPVo();

	/**
	 * 页面返回内容（默认为字符串）
	 */
	private HtmlContentType htmlResultType = HtmlContentType.HtmlString;

	/**
	 * 是否使用缓存
	 */
	private boolean useCache = false;

	/**
	 * 上一步引用地址
	 */
	private String referUrl = "";

	/**
	 * 是否传输压缩包
	 */
	private boolean tranGzip = false;

	/**
	 * 获取是否是压缩包
	 * 
	 * @return
	 */
	public boolean isTranGzip() {
		return tranGzip;
	}

	/**
	 * 设置是否是压缩包
	 * 
	 * @param tranGzip
	 */
	public void setTranGzip(boolean tranGzip) {
		this.tranGzip = tranGzip;
	}

	/**
	 * 获取引用地址
	 * 
	 * @return
	 */
	public String getReferUrl() {
		return referUrl;
	}

	/**
	 * 设置引用地址
	 * 
	 * @param referUrl
	 */
	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}

	/**
	 * 获取是否使用缓存
	 * 
	 * @return
	 */
	public boolean isUseCache() {
		return useCache;
	}

	/**
	 * 设置是否使用缓存
	 * 
	 * @param useCache
	 */
	public void setUseCache(boolean useCache) {
		this.useCache = useCache;
	}

	/**
	 * 获取HTML结果类型
	 * 
	 * @return
	 */
	public HtmlContentType getHtmlResultType() {
		return htmlResultType;
	}

	/**
	 * 设置HTML结果类型
	 * 
	 * @param htmlResultType
	 */
	public void setHtmlResultType(HtmlContentType htmlResultType) {
		this.htmlResultType = htmlResultType;
	}

	/**
	 * 获取代理IP
	 * 
	 * @return
	 */
	public ProxyIPVo getProxyip() {
		return proxyip;
	}

	/**
	 * 设置代理IP
	 * 
	 * @param proxyip
	 */
	public void setProxyip(ProxyIPVo proxyip) {
		this.proxyip = proxyip;
	}

	/**
	 * 获取提交的参数
	 * 
	 * @return
	 */
	public String getCommitparam() {
		return commitparam;
	}

	/**
	 * 设置提交的参数
	 * 
	 * @param commitparam
	 */
	public void setCommitparam(String commitparam) {
		this.commitparam = commitparam;
	}

	/**
	 * 获取连接超时时间，默认为10秒
	 * 
	 * @return
	 */
	public int getConnetcTimeout() {
		return connetcTimeout;
	}

	/**
	 * 设置连接超时时间，默认为10秒
	 * 
	 * @param connetcTimeout
	 */
	public void setConnetcTimeout(int connetcTimeout) {
		this.connetcTimeout = connetcTimeout;
	}

	/**
	 * 获取读取超时时间，默认为10秒
	 * 
	 * @return
	 */
	public int getReadTimeout() {
		return readTimeout;
	}

	/**
	 * 设置读取超时时间，默认为10秒
	 * 
	 * @param readTimeout
	 */
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * 获取是否使用代理
	 * 
	 * @return
	 */
	public boolean isUseProxy() {
		return useProxy;
	}

	/**
	 * 设置使用代理
	 * 
	 * @param useProxy
	 */
	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	/**
	 * 获取是否是https请求
	 * 
	 * @return
	 */
	public boolean isUseHttps() {
		return useHttps;
	}

	/**
	 * 设置是否是https请求
	 * 
	 * @param useHttps
	 */
	public void setUseHttps(boolean useHttps) {
		this.useHttps = useHttps;
	}

	/**
	 * 获取代理信息
	 * 
	 * @return
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * 设置代理信息
	 * 
	 * @param userAgent
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * 获取编码类型（客户端请求内容编码）
	 * 
	 * @return
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 设置编码类型（客户端请求内容编码）
	 * 
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 获取客户端支持的编码类型
	 * 
	 * @return
	 */
	public String getAcceptType() {
		return acceptType;
	}

	/**
	 * 设置客户端支持的编码类型
	 * 
	 * @param acceptType
	 */
	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}

	/**
	 * 获取页面内容编码类型
	 * 
	 * @return
	 */
	public String getEncodeType() {
		return encodeType;
	}

	/**
	 * 设置页面内容编码类型
	 * 
	 * @param encodeType
	 */
	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}

	/**
	 * 获取URL
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取COOKIE
	 * 
	 * @return
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * 设置cookie
	 * 
	 * @param cookie
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * 获取请求类型
	 * 
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 设置请求类型
	 * 
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
}
