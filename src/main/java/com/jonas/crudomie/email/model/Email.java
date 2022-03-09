package com.jonas.crudomie.email.model;

import com.jonas.crudomie.category.model.Category;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Email {

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String email;

    public Category getCategory() {
        return category;
    }
}
