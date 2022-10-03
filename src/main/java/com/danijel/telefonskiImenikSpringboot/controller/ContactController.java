package com.danijel.telefonskiImenikSpringboot.controller;

import com.danijel.telefonskiImenikSpringboot.model.Contact;
import com.danijel.telefonskiImenikSpringboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    // display list of contacts
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewContactForm")
    public String showNewContactForm(Model model) {
        var contact = new Contact();
        model.addAttribute("contact", contact);
        return "new_contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // Get contact from service
        Contact contact = contactService.getContactById(id);

        //set employee as model attribute to pre-populate the form
        model.addAttribute("contact", contact);
        return "update_contact";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable(value = "id") long id) {
        //call delete employee method
        this.contactService.deleteContactById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Contact> page = contactService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Contact> listContacts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listContacts", listContacts);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "index";
    }

    @GetMapping("/search/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                @RequestParam("keyword") String keyword,
                                Model model) {
        int pageSize = 5;

        Page<Contact> page = contactService.findPaginatedSearchResult(pageNo, pageSize, sortField, sortDir, keyword);
        List<Contact> listContacts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listContacts", listContacts);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);

        return "search_result";
    }

    @GetMapping("/search")
    public String getList(@RequestParam(name = "keyword") String keyword, Model model) {
        return findPaginated(1, "firstName", "asc", keyword, model);
    }
}
