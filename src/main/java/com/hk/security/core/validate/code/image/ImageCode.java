package com.hk.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.hk.security.core.validate.code.ValidateCode;

/**
 * 图形验证码
 * @author administrator
 *
 */
public class ImageCode extends ValidateCode {
	
	//图片
	private BufferedImage image;
	
	
	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code, expireIn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code, expireTime);
		this.image = image;
	}
	

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	
}
