package com.danijel.telefonskiImenikSpringboot.repository;

import com.danijel.telefonskiImenikSpringboot.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findAllByFirstNameContainingOrLastNameContainingOrAddressContainingOrCityContainingOrOibContainingOrPhoneContaining(
            String firstName, String lastName, String address, String city, String oib, String phone, Pageable pageable);
}
