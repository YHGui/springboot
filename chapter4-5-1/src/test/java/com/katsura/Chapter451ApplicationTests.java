package com.katsura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter451ApplicationTests {

	@Autowired
	private JavaMailSender mailSender;


	@Test
	public void sendSimpleMail() throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("1540257290@qq.com");
		message.setTo("1540257290@qq.com");
		message.setSubject("Theme: simple email");
		message.setText("email context");

		mailSender.send(message);

	}

}
