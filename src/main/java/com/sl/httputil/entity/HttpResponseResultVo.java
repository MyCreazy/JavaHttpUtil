package com.sl.httputil.entity;

/**
 * 请求结果
 * 
 * @author Administrator
 *
 */
public class HttpResponseResultVo {
	/**
	 * html字符串结果
	 */
	private String htmlStringResult = "";

	/**
	 * cookie（目前只支持单个cookie）
	 */
	private String cookie = "";

	/**
	 * 比特数组类型的页面结果
	 */
	private byte[] htmlByteResult = null;

	/**
	 * 是否成功
	 */
	private boolean success = false;

	/**
	 * 提示信息
	 */
	private String noticeMessage = "";

	/**
	 * 获取提示信息
	 * 
	 * @return
	 */
	public String getNoticeMessage() {
		return noticeMessage;
	}

	/**
	 * 设置提示信息
	 * 
	 * @param noticeMessage
	 */
	public void setNoticeMessage(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	/**
	 * 获取是否成功
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置是否成功
	 * 
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 获取比特类型的页面结果
	 * 
	 * @return
	 */
	public byte[] getHtmlByteResult() {
		return htmlByteResult;
	}

	/**
	 * 设置比特类型的页面结果
	 * 
	 * @param htmlByteResult
	 */
	public void setHtmlByteResult(byte[] htmlByteResult) {
		this.htmlByteResult = htmlByteResult;
	}

	/**
	 * 获取cookie
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
	 * 获取html字符串
	 * 
	 * @return
	 */
	public String getHtmlStringResult() {
		return htmlStringResult;
	}

	/**
	 * 设置html字符串
	 * 
	 * @param htmlStringResult
	 */
	public void setHtmlStringResult(String htmlStringResult) {
		this.htmlStringResult = htmlStringResult;
	}
}
