package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String genree;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String genre_description;

    @OneToMany(mappedBy = "genresy", fetch = FetchType.EAGER)
    private Collection<films> tenats;

    public genres(String genree, String genre_description, Collection<films> tenats) {
        this.genree = genree;
        this.genre_description = genre_description;
        this.tenats = tenats;
    }

    public genres() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenree() {
        return genree;
    }

    public void setGenree(String genree) {
        this.genree = genree;
    }

    public String getGenre_description() {
        return genre_description;
    }

    public void setGenre_description(String genre_description) {
        this.genre_description = genre_description;
    }

    public Collection<films> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<films> tenats) {
        this.tenats = tenats;
    }
}
