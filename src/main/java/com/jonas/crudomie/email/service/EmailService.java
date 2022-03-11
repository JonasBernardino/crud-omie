package com.jonas.crudomie.email.service;

import com.jonas.crudomie.email.dto.EmailDtoFull;
import com.jonas.crudomie.email.dto.EmailDtoShort;
import com.jonas.crudomie.email.model.Email;
import com.jonas.crudomie.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Page<EmailDtoFull> findAllEmailFull(Pageable pageable) {
        Page<Email> result = emailRepository.findAll(pageable);
        Page<EmailDtoFull> page = result.map(x -> new EmailDtoFull(x));
        return page;
    }

    public Page<EmailDtoShort> findAllEmailShort(Pageable pageable) {
        Page<Email> result = emailRepository.findAll(pageable);
        Page<EmailDtoShort> page = result.map(x -> new EmailDtoShort(x));
        return page;
    }
}
