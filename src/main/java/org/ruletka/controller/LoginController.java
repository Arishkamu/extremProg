package org.ruletka.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.ruletka.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.ruletka.entites.Roulette;

@Controller
public class LoginController {

    Roulette roulette = new Roulette();

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        User user = roulette.createUser(username, password);
        int id = user.getId();

        return new ModelAndView("redirect:/user/" + id);
    }

    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable Integer id, Model model) {
        User user = roulette.findByUid(id);
        model.addAttribute("user", user);
        return "bet";
    }
}

