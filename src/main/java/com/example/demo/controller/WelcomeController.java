package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIName.WELCOME)
public class WelcomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

}
