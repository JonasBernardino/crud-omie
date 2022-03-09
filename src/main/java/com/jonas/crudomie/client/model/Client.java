package com.jonas.crudomie.client.model;

import com.jonas.crudomie.client.enumClient.Status;
import com.jonas.crudomie.email.model.Email;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Client {
    @Id
    private Long id;
    private String subscription;
    private String name;
    private String nickname;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "email_id")
    private Email email;

    public Email getEmail() {
        return email;
    }
}
