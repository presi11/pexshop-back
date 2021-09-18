package co.edu.udea.pexshop.domain.user.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("")
    public String authenticate() {
        return "";
    }
}
