package com.jonas.crudomie.client.model;

import com.jonas.crudomie.client.enumClient.Status;
import com.jonas.crudomie.email.model.Email;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subscription;
    private String name;
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToMany()
    @JoinColumn(name = "id_client")
    private List<Email> emails;
}
