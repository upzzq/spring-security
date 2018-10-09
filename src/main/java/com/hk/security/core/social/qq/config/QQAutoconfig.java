package com.hk.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import com.hk.security.core.properties.QQProperties;
import com.hk.security.core.properties.SocialProperties;
import com.hk.security.core.social.qq.connet.QQConnectionFactory;

@Configuration
@ConditionalOnProperty(prefix = "hk.security.social.qq", name = "app-id") //配置了QQ appid的选项才生效
public class QQAutoconfig extends SocialAutoConfigurerAdapter {
	
	@Autowired
	private SocialProperties socialProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqConfig = socialProperties.getQq();
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}

}
