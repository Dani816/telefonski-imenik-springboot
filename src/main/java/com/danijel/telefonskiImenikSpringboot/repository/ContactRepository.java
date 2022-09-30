package com.danijel.telefonskiImenikSpringboot.repository;

import com.danijel.telefonskiImenikSpringboot.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
