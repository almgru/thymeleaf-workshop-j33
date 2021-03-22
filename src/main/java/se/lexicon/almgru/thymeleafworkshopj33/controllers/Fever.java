package se.lexicon.almgru.thymeleafworkshopj33.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {
    private Double temperature;

    @GetMapping("/fever")
    public String fever(Model model) {
        if (temperature != null) {
            String message = "";
            String treatment = "";

            if (temperature <= 35.0) {
                treatment = "Drink something warm and take a hot bath.";
                message = "Your temperature is " + temperature + ", which is classified as hypothermia.";
            } else if (temperature >= 37.5) {
                treatment = "Take some antipyretic medication.";
                message = "Your temperature is " + temperature + ", which is classified as fever.";
            } else {
                message = "Your temperature is " + temperature + ", which is normal.";
            }

            model.addAttribute("message", message);

            if (!treatment.isEmpty()) {
                model.addAttribute("treatment", treatment);
            }
        }

        return "fever";
    }

    @PostMapping("/fever")
    public String fever(@RequestParam("temp") double temperature) {
        this.temperature = temperature;

        return "redirect:/fever";
    }
}
