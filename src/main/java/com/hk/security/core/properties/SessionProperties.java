package com.hk.security.core.properties;

public class SessionProperties {
	
	/**
	 * 同一个用户在系统中的最大session数,默认1
	 */
	private int maximumSessions = 1;
	
	/**
	 * 达到最大session时是否阻止新的登录请求,默认为fasle,不阻止,新的登录请求会将老的登录失效掉
	 */
	private boolean maxSessionsPreventsLogin;
	
	private String sessionInvalidUrl = "/hk-session-invalid.html";

	public int getMaximumSessions() {
		return maximumSessions;
	}

	public void setMaximumSessions(int maximumSessions) {
		this.maximumSessions = maximumSessions;
	}

	public boolean isMaxSessionsPreventsLogin() {
		return maxSessionsPreventsLogin;
	}

	public void setMaxSessionsPreventsLogin(boolean maxSessionsPreventsLogin) {
		this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
	}

	public String getSessionInvalidUrl() {
		return sessionInvalidUrl;
	}

	public void setSessionInvalidUrl(String sessionInvalidUrl) {
		this.sessionInvalidUrl = sessionInvalidUrl;
	}
	
	
}
