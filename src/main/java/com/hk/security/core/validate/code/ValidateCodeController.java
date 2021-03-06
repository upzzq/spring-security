package com.hk.security.core.validate.code;

import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.hk.security.core.validate.code.image.ImageCode;
import com.hk.security.core.validate.code.sms.SmsCodeSender;

@RestController
public class ValidateCodeController {
	
	public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
	
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	@Autowired
	private ValidateCodeGenerator imageCodeGenerator;
	
	@Autowired
	private ValidateCodeGenerator smsCodeGenerator;
	
	@Autowired
	private SmsCodeSender smsCodeSender;
	
	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

/*	@GetMapping("/code/image")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//创建验证码
		ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(request);
		
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
		
		ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
	}

	
	@GetMapping("/code/sms")
	public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
		
		//创建验证码
		ValidateCode smsCode = smsCodeGenerator.generate(request);
		
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
		String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
		smsCodeSender.send(mobile, smsCode.getCode());
	}*/
	
	/**
	 * 创建验证码, 根据验证码类型不同,调用不同的 {@link ValidateCodeProcessor} 接口的实现
	 * @param request
	 * @param response
	 * @param type
	 * @throws Exception 
	 */
	@GetMapping("/code/{type}")
	public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
		validateCodeProcessors.get(type + "CodeProcessor").create(new ServletWebRequest(request, response));
		
	}
	
	
}
