package com.hk.security.core.validate.code.sms;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.hk.security.core.properties.SecurityProperties;
import com.hk.security.core.validate.code.ValidateCode;
import com.hk.security.core.validate.code.ValidateCodeGenerator;

/**
 * 图形验证码生成器
 * @author administrator
 *
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
	
	//使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

    @Autowired
	private SecurityProperties securityProperties;
    
    /**
     * 生成图形验证码
     * @throws IOException 
     */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}
    
    
	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}


	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
    
    

}
