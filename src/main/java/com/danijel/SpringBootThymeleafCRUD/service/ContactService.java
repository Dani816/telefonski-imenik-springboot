package com.danijel.SpringBootThymeleafCRUD.service;

import com.danijel.SpringBootThymeleafCRUD.model.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    void saveContact(Contact contact);
    Contact getContactById(long id);
    void deleteContactById(long id);

    Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
