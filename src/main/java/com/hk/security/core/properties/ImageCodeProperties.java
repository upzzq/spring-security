package com.hk.security.core.properties;

public class ImageCodeProperties extends SmsCodeProperties {
	
	private int width = 100;
	
	private int hegiht = 30;
	
	public ImageCodeProperties() {
		//图形验证码默认4位
		this.setLength(4);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHegiht() {
		return hegiht;
	}

	public void setHegiht(int hegiht) {
		this.hegiht = hegiht;
	}

}
