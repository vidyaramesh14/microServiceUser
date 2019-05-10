package com.bridgelab.microfundoo.user.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bridgelab.microfundoo.MicroUtil.EmailUtil;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{ 
		return new BCryptPasswordEncoder(); 
	}
	@Bean
	public EmailUtil getEmailUtil()
	{ 
		return new EmailUtil(); 
	}
//	@Bean
//	public JavaMailSender getMailSender() {
//		return new JavaMailSender();
//	}
}
