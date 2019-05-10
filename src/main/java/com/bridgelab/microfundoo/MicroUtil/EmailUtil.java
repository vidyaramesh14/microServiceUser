package com.bridgelab.microfundoo.MicroUtil;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtil {
	private  JavaMailSender javaMailSender = new JavaMailSenderImpl();
	
	public void send(String to,String subject,String body) throws Exception
	{ 
		MimeMessage msg=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper=new MimeMessageHelper(msg,true);

			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);

			javaMailSender.send(msg);
		}
		catch(MessagingException|MailException e) {
			throw new IllegalArgumentException(e.getMessage());
		}		
	}
}

