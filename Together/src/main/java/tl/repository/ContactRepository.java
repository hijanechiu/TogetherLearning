package tl.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {



}
