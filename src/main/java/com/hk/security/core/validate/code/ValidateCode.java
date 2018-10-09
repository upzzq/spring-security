package com.hk.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * 短信验证码
 * @author administrator
 *
 */
public class ValidateCode {
	
	//验证码
	private String code;
	
	//过期时间
	private LocalDateTime expireTime;
	
	public ValidateCode(String code, int expireIn) {
		super();
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn); //设置过期的时间点
	}

	public ValidateCode(String code, LocalDateTime expireTime) {
		super();
		this.code = code;
		this.expireTime = expireTime;
	}
	
	/**
	 * 验证码是否过期
	 * @return
	 */
	public boolean isExpired() {
		return LocalDateTime.now().isAfter(expireTime);
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
	
}
