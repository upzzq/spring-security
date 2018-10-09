package com.hk.security.core.properties;

public class BrowserProperties {

	//以html结尾的,没有登录时的默认跳转页面
	private String loginPage = "/hk-signIn.html";

	//登录成功/登录失败时默认返回json
	private LoginType loginType = LoginType.JSON;
	//记住我的时间(单位:秒)
	private int rememberMeSeconds = 3600;
	
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
	
	
}
