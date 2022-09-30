package com.danijel.SpringBootThymeleafCRUD.service;

import com.danijel.SpringBootThymeleafCRUD.model.Contact;
import com.danijel.SpringBootThymeleafCRUD.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(long id) {
        Optional <Contact> optional = contactRepository.findById(id);
        Contact contact = null;
        if (optional.isPresent()) {
            contact = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return contact;
    }

    @Override
    public void deleteContactById(long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.contactRepository.findAll(pageable);
    }

}
