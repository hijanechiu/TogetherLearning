package tl.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tl.entity.Subscription;
import tl.repository.SubcriptionRepository;

@Service
public class SubScriptionService {

	@Autowired
	private SubcriptionRepository subRep;
	
	
	@Autowired
	private EmailSenderService emailService;
	
	public void SendSubcriptionMail(String toEmail) {
		Subscription result = subRep.findByEmail(toEmail);
		if(result==null) {
			Subscription subscriptor=new Subscription();
			subscriptor.setEmail(toEmail);
			subscriptor.setSubscribeTime(new Date());
			emailService.sendEmail(toEmail);
			subscriptor.setSendTime(new Date());
			subRep.save(subscriptor);
		}else {
			emailService.sendEmail(toEmail);
		}
	}
}
