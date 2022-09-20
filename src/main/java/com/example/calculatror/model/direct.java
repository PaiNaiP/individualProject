package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class direct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String name;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String surnamey;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String lastname;

    @OneToMany(mappedBy = "directy", fetch = FetchType.EAGER)
    private Collection<films> tenats;

    public direct(String name, String surnamey, String lastname, Collection<films> tenats) {
        this.name = name;
        this.surnamey = surnamey;
        this.lastname = lastname;
        this.tenats = tenats;
    }

    public direct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnamey() {
        return surnamey;
    }

    public void setSurnamey(String surnamey) {
        this.surnamey = surnamey;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<films> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<films> tenats) {
        this.tenats = tenats;
    }
}
