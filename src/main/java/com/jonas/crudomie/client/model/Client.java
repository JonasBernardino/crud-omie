package com.jonas.crudomie.client.model;

import com.jonas.crudomie.client.enumClient.Status;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    private Long id;
    private String subscription;
    private String name;
    private String nickname;
    private Status status;
    private double idade;
}
