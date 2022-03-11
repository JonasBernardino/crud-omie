package com.jonas.crudomie.email.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    @GetMapping
    public String ok(){
        return "Deu certo!! Email";
    }
}
