package org.ruletka.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    //Roulette roulette = new Roulette();

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        /*try {
            var get = authenticationService.authenticate(new AuthenticationRequest(username, password));
            Cookie cookie = new Cookie("jwtAccessToken", get.getAccessToken());
            cookie.setAttribute("jwtRefreshToken", get.getRefreshToken()); // todo: it probably doesn't work. For now it's enough to get only access token
            cookie.setMaxAge(60 * 60); // 1 hour
            cookie.setSecure(true);
            response.addCookie(cookie);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            System.out.println(e.getMessage());
            return new ModelAndView("/login").addObject("message", "incorrect username or password");
        }
        return new ModelAndView("redirect:/user");

         */
    }



}

