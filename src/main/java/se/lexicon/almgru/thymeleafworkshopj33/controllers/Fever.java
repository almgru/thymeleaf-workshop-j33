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
            StringBuilder message = new StringBuilder();
            String treatment = "";

            message.append("Your temperature is ")
                    .append(temperature)
                    .append(", ");

            if (temperature <= 35.0) {
                treatment = "Drink something warm and take a hot bath.";
                message.append("which is classified as hypothermia.");
            } else if (temperature >= 38) {
                treatment = "Take some antipyretic medication.";
                message.append("which is classified as fever.");
            } else {
                message.append("which is normal.");
            }

            model.addAttribute("message", message.toString());

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
