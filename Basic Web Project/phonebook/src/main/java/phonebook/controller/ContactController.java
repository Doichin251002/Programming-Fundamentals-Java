package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.*;

@Controller("/")
public class ContactController {
    private Set<Contact> contacts;

    public ContactController() {
        this.contacts = new TreeSet<>(Comparator.comparing(Contact::getName));
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        modelAndView.addObject("contacts", this.contacts);

        return modelAndView;
    }

    @PostMapping
    public String add(Contact contact) {
        this.contacts.add(contact);

        return "redirect:/";
    }

    @PutMapping
    public String updateByName(Contact changedContact) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(changedContact.getName())) {
                this.contacts.remove(contact);

                this.contacts.add(changedContact);
                break;
            }
        }

        return "redirect:/";
    }
}
