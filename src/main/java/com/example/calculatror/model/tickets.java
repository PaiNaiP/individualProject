package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "`tickets`")
public class tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String time;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String date;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private places placess;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private films filmss;

    @OneToMany(mappedBy = "ticketss", fetch = FetchType.EAGER)
    private Collection<checks> tenats;

    public Collection<checks> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<checks> tenats) {
        this.tenats = tenats;
    }

    public tickets(String time, String date, places placess, films filmss) {
        this.time = time;
        this.date = date;
        this.placess = placess;
        this.filmss = filmss;
    }

    public tickets() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public places getPlacess() {
        return placess;
    }

    public void setPlacess(places placess) {
        this.placess = placess;
    }

    public films getFilmss() {
        return filmss;
    }

    public void setFilmss(films filmss) {
        this.filmss = filmss;
    }
}
