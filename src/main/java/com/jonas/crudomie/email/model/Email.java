package com.jonas.crudomie.email.model;

import com.jonas.crudomie.category.model.Category;
import com.jonas.crudomie.client.model.Client;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Category getCategory() {
        return category;
    }
}
