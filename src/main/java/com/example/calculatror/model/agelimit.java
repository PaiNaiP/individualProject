package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class agelimit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String agelimitrus;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 10000)
    String agelimitusa;

    @OneToMany(mappedBy = "agelimity", fetch = FetchType.EAGER)
    private Collection<films> tenats;

    public agelimit(String agelimitrus, String agelimitusa, Collection<films> tenats) {
        this.agelimitrus = agelimitrus;
        this.agelimitusa = agelimitusa;
    }

    public agelimit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgelimitrus() {
        return agelimitrus;
    }

    public void setAgelimitrus(String agelimitrus) {
        this.agelimitrus = agelimitrus;
    }

    public String getAgelimitusa() {
        return agelimitusa;
    }

    public void setAgelimitusa(String agelimitusa) {
        this.agelimitusa = agelimitusa;
    }

    public Collection<films> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<films> tenats) {
        this.tenats = tenats;
    }
}
