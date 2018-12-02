package ru.pgups.ivs.rglv.labs.db.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootWebController {
    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("applicationName", "SpringBoot Web example for DVD Labs");

        return "homepage";
    }
}
