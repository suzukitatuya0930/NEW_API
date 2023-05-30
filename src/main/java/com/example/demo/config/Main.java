//package com.example.demo.config;
////package com.example.demo.sendEmail;
////
////import java.io.UnsupportedEncodingException;
////import java.net.Authenticator;
////import java.net.PasswordAuthentication;
////import java.util.Properties;
////
////import javax.mail.Message;
////import javax.mail.MessagingException;
////import javax.mail.Session;
////import javax.mail.Transport;
////import javax.mail.internet.InternetAddress;
////import javax.mail.internet.MimeMessage;
////
////public class main {
////	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
////		//転送メール
////		final String fromEmail= "maiqakai@gmail.com";
////		final String password = "maiqakai123789";
////		
////		//届けるメール
////		final String toEmail = "joinbill123@gmail.com";
////		
////		//内容
////		final String subject = "test send email";
////		final String body = "hello every body";
////		
////		Properties props = new Properties();
////		props.put("mail.smptp.host", "smtp.gmail.com");//SMTP host
////		props.put("mail.smptp.port", "587");//TLS port
////		props.put("mail.smptp.auth", "true");//enable authencation
////		props.put("mail.smptp.starttls.enable", "true");//enable starttls
////		
////		Authenticator auth = new Authenticator() {
////			protected PasswordAuthentication getPasswordAuthentication() {
////				return new PasswordAuthentication(fromEmail, password);
////			}
////		};
////		Session session = Session.getInstance(props);
////        MimeMessage msg = new MimeMessage(session);
////        //set message headers
////        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
////        msg.addHeader("format", "flowed");
////        msg.addHeader("Content-Transfer-Encoding", "8bit");
////        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
////        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
////        msg.setSubject(subject, "UTF-8");
////        msg.setText(body, "UTF-8");
////        
////        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
////        Transport.send(msg);
////        System.out.println("Gui mail thanh cong");
////    }
////	
////}
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import com.example.demo.model.RegisterModel;
//public class Main {
//    public  void sendMail(RegisterModel registerModel) throws MessagingException, UnsupportedEncodingException {
//        final String fromEmail = "maiqakai@gmail.com";
//        // Mat khai email cua ban
//        final String password = "wjsgikjlprwqwayy";
//        // dia chi email nguoi nhan
//        final String toEmail = registerModel.getEmail();
//        final String subject = "Your Password";
//        final String body = "mmm" ;
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//        props.put("mail.smtp.port", "587"); //TLS Port
//        props.put("mail.smtp.auth", "true"); //enable authentication
//        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//        Authenticator auth = new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//        Session session = Session.getInstance(props, auth);
//        MimeMessage msg = new MimeMessage(session);
//        //set message headers
//        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//        msg.addHeader("format", "flowed");
//        msg.addHeader("Content-Transfer-Encoding", "8bit");
//        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
//        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
//        msg.setSubject(subject, "UTF-8");
//        msg.setText(body, "UTF-8");
//        msg.setSentDate(new Date());
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//        Transport.send(msg);
//        System.out.println("Gui mail thanh cong");
//    }
//}
