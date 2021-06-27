package com.example.demo;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class masterServiceImpl {
//	@Autowired
	private static JavaMailSender javaMailSender = new AppConfig().jmsi();
	public static void sendEmail(String path) throws Exception{
			System.out.println("inside mail service");
			MimeMessage message = javaMailSender.createMimeMessage();
//			 MimeMessage message = new MimeMessage();
			 MimeMessageHelper helper = new MimeMessageHelper(message, true);
	         helper.setTo("ritik.garg@mykaarma.com");
	         helper.setText("<html><body><h1>Hello Welcome! Please find attached the report of the testng generated</h1><body></html>", true);
	         FileSystemResource file  = new FileSystemResource(new File(path));
	         helper.addAttachment("testfile", file);
//	         helper.addAttachment("test.png", new ClassPathResource("test.jpeg"));
	         helper.setSubject("Hi");
	         javaMailSender.send(message);
	   }
}
