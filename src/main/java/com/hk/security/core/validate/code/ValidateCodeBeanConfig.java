package com.hk.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hk.security.core.properties.SecurityProperties;
import com.hk.security.core.validate.code.image.ImageCodeGenerator;
import com.hk.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.hk.security.core.validate.code.sms.SmsCodeSender;

@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	//该注解作用:在Spring容器中找不到名字叫imageCodeGenerator的bean 就用当前这个bean,如果找到了,这个bean不会被初始化
	@ConditionalOnMissingBean(name = "imageCodeGenerator")
	public ValidateCodeGenerator imageCodeGenerator() {
		ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
		imageCodeGenerator.setSecurityProperties(securityProperties);
		return imageCodeGenerator;
	}
	
	@Bean
	//该注解作用:在Spring容器中找不到名字叫imageCodeGenerator的bean 就用当前这个bean,如果找到了,这个bean不会被初始化
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}
}
