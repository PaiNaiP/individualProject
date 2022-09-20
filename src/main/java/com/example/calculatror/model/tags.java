package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String titlee;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 10000)
    String tags_description;

    @OneToMany(mappedBy = "tagsy", fetch = FetchType.EAGER)
    private Collection<films> tenats;

    public tags(String titlee, String tags_description, Collection<films> tenats) {
        this.titlee = titlee;
        this.tags_description = tags_description;
        this.tenats = tenats;
    }

    public tags() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlee() {
        return titlee;
    }

    public void setTitlee(String titlee) {
        this.titlee = titlee;
    }

    public String getTags_description() {
        return tags_description;
    }

    public void setTags_description(String tags_description) {
        this.tags_description = tags_description;
    }

    public Collection<films> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<films> tenats) {
        this.tenats = tenats;
    }
}