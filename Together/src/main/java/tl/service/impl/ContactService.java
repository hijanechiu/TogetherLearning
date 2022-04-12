package tl.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.entity.Contact;
import tl.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository conRep;
	
	@Autowired
	private EmailSenderService emailService;
	
	public void ContactReply(Contact contact) {
		contact.setSendTime(new Date());
		Contact result = conRep.save(contact);
		String toEmail=result.getEmail();
		Integer contactId=result.getContactId();
		emailService.sendContactReply(toEmail, contactId);
	}
	
	
	
	
}
