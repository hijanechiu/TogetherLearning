package tl.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage message;
	
	public void sendEmail(String toEmail) {
		message.setFrom("hellochiu74@gmail.com");
		message.setTo(toEmail);
		message.setSubject("加入齊上，齊心向上");
		message.setText("感謝訂閱齊上電子報，全館買滿萬點送千點");
		mailSender.send(message);
	}
	
	public void sendContactReply(String toEmail,Integer contactId) {
		message.setFrom("hellochiu74@gmail.com");
		message.setTo(toEmail);
		message.setSubject("齊上客服已收到您反應的問題");
		message.setText("案件編號:"+contactId+"請靜待客服回信，謝謝");
		mailSender.send(message);
	}
	
	
	public void sendresetPasswordLink(String toEmail, String link)
	        throws MessagingException, UnsupportedEncodingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("hellochiu74@gmail.com", "TL Support");
	    helper.setTo(toEmail);
	     
	    String subject = "請點選連結重新設置密碼";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>請點選以下連結更改密碼連結</p>"
	            + "<p><a href=\"" + link + "\">修改我的密碼</a></p>"
	            + "<br>"
	            + "<p>若已經想起密碼,或是未發送要求重新設置密碼的請求請忽略此信件 ";
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
}
