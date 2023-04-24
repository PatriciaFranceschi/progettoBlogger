package com.example.progettoBlogger.controller;

import com.example.progettoBlogger.model.Autore;
import com.example.progettoBlogger.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UtenteController {

    @Autowired
    private AutoreRepository autoreRepository;

    @GetMapping("/register")
    public String showForm(Model model) {
        Autore user = new Autore();
        model.addAttribute("user", user);

       List<String> listProfession = Arrays.asList(
               "Decoratore", "Designer", "Dentista", "Dirigente", "Edicolante", "Elettricista","Erborista", "Enologo", "Farmacista", "Fisioterapista",
               "Geologo", "Idraulico", "Altri");

        model.addAttribute("listProfession", listProfession);



        return "register_form";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") Autore user) {
        System.out.println(user);
        autoreRepository.save(user);
        return "register_success";
    }
}