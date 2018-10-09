package com.hk.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器
 * @author administrator
 *
 */
public interface ValidateCodeGenerator {
	
	/**
	 * 生成验证码
	 * @return
	 */
	ValidateCode generate(ServletWebRequest request);
}
