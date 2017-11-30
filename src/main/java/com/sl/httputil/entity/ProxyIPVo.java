package com.sl.httputil.entity;

/**
 * 代理IP相关信息
 * 
 * @author Administrator Nov 24, 2017
 */
public class ProxyIPVo {
	/**
	 * 代理服务器地址（默认为本机）
	 */
	private String proxyServerAddress = "127.0.0.1";

	/**
	 * 代理IP端口（默认为8888）
	 */
	private int proxyPort = 8888;

	/**
	 * 代理账号
	 */
	private String proxyipAccount = "";

	/**
	 * 代理IP密码
	 */
	private String proxyipPassword = "";

	/**
	 * 获取代理ip密码
	 * 
	 * @return
	 */
	public String getProxyipPassword() {
		return proxyipPassword;
	}

	/**
	 * 设置代理IP
	 * 
	 * @param proxyipPassword
	 */
	public void setProxyipPassword(String proxyipPassword) {
		this.proxyipPassword = proxyipPassword;
	}

	/**
	 * 获取代理IP账号
	 * 
	 * @return
	 */
	public String getProxyipAccount() {
		return proxyipAccount;
	}

	/**
	 * 设置代理IP账号
	 * 
	 * @param proxyipAccount
	 */
	public void setProxyipAccount(String proxyipAccount) {
		this.proxyipAccount = proxyipAccount;
	}

	/**
	 * 获取代理IP端口
	 * 
	 * @return
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * 设置代理IP端口
	 * 
	 * @param proxyPort
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * 获取代理服务器地址信息
	 * 
	 * @return
	 */
	public String getProxyServerAddress() {
		return proxyServerAddress;
	}

	/**
	 * 设置代理服务器信息
	 * 
	 * @param proxyServerAddress
	 */
	public void setProxyServerAddress(String proxyServerAddress) {
		this.proxyServerAddress = proxyServerAddress;
	}
}
