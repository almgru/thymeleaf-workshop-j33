package se.lexicon.almgru.thymeleafworkshopj33.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    private final List<String> contacts = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model) {
        model.addAttribute("contacts", contacts);
        return "contact-list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("name") String name) {
        if (name != null && !name.isEmpty()) {
            contacts.add(name);
        }

        return "redirect:/contact-list";
    }
}
