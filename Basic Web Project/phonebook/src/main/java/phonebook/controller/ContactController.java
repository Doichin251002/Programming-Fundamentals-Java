package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    private List<Contact> contacts;

    public ContactController() {
        this.contacts = new ArrayList<>();
        this.contacts.add(new Contact("Nick", "000000000000"));
        this.contacts.add(new Contact("John", "111111111111"));
        this.contacts.add(new Contact("Mason", "22222222222"));
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        modelAndView.addObject("contacts", this.contacts);

        return modelAndView;
    }
}
