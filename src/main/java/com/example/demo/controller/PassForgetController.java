package com.example.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.config.EmailConfig;
import com.example.demo.model.PassForgetModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.PassForgetService;

import jakarta.annotation.Resource;

@RestController

public class PassForgetController {
	@Resource 
	PassForgetService service;
	
	@PostMapping("/passforget")
	public ResponseEntity<?> passForget(PassForgetModel passForgetModel,ResponseModel responseModel){
		
		try 
		  {
			service.selectEmail(passForgetModel);
			String otp = generateRandomOTP(); 
	        passForgetModel.setToken(otp); 
			
			sendMail(passForgetModel);
		         responseModel.setCode(200);
		         responseModel.setStatus("OK");
		         responseModel.setInformation("メール転送できました");
		         return ResponseEntity.status(HttpStatus.OK).body(responseModel);
		  } catch (DuplicateFormatFlagsException ex) {
		   // メールアドレスが重複している場合の処理
		   
		   responseModel.setCode(400);
		   responseModel.setStatus("ERROR");
		   responseModel.setInformation("ERROR");
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		  } catch (Exception ex) {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
	}
	

	
	//Random number
	 private String generateRandomOTP() {
	        int otpLength = 6; 

	        StringBuilder otp = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < otpLength; i++) {
	            otp.append(random.nextInt(10)); 
	        }

	        return otp.toString();
	    }
	
	 //send email
	 private final EmailConfig emailConfig;
	 private final TemplateEngine templateEngine;
	 

	 @Autowired//inject 
	 public PassForgetController(EmailConfig emailConfig,TemplateEngine templateEngine) {
	        this.emailConfig = emailConfig;
	        this.templateEngine = templateEngine;
	    }
	 public  void sendMail(PassForgetModel passForgetModel) throws MessagingException, UnsupportedEncodingException {
	        final String fromEmail = emailConfig.getUsername();
	        // Mat khai email cua ban
	        final String password = emailConfig.getPassword();
	        // dia chi email nguoi nhan
	        final String toEmail = passForgetModel.getEmail();
	        final String subject = "One Time Password";
	        String templateName = "OTP";
	        try {
//	        	 String htmlContent = readFile(htmlFilePath);
	        	Context context = new Context();
	        	context.setLocale(Locale.getDefault());
	        	context.setVariable("token", passForgetModel.getToken());
	        	 String htmlContent = templateEngine.process(templateName, context);

	             Properties props = new Properties();
	             props.put("mail.smtp.host", "smtp.gmail.com");
	             props.put("mail.smtp.port", "587");
	             props.put("mail.smtp.auth", "true");
	             props.put("mail.smtp.starttls.enable", "true");

	             Session session = Session.getInstance(props, new Authenticator() {
	                 protected PasswordAuthentication getPasswordAuthentication() {
	                     return new PasswordAuthentication(fromEmail, password);
	                 }
	             });

	             MimeMessage msg = new MimeMessage(session);
	             msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	             msg.addHeader("format", "flowed");
	             msg.addHeader("Content-Transfer-Encoding", "8bit");
	             msg.setFrom(new InternetAddress(fromEmail, "KKSOFT株式会社"));
	             msg.setReplyTo(InternetAddress.parse(fromEmail, false));
	             msg.setSubject(subject, "UTF-8");

	             //メールの内容作成
	             MimeBodyPart messageBodyPart = new MimeBodyPart();
	             
	             messageBodyPart.setContent(htmlContent, "text/html; charset=utf-8");

	             Multipart multipart = new MimeMultipart();
	             multipart.addBodyPart(messageBodyPart);

	             // Thiết lập nội dung email
	             msg.setContent(multipart);
	             msg.setSentDate(new Date());
	             msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

	             Transport.send(msg);

	             System.out.println("Email sent successfully");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	   }
		 
}
