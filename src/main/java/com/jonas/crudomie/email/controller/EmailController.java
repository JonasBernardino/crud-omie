package com.jonas.crudomie.email.controller;

import com.jonas.crudomie.email.dto.EmailDtoFull;
import com.jonas.crudomie.email.dto.EmailDtoShort;
import com.jonas.crudomie.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/full")
    public Page<EmailDtoFull> findAllEmailFull(Pageable pageable){
        return emailService.findAllEmailFull(pageable);
    }
    @GetMapping("/short")
    public Page<EmailDtoShort> findAllEmailShort(Pageable pageable){
        return emailService.findAllEmailShort(pageable);
    }
}
