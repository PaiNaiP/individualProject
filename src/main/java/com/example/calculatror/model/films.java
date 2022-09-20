package com.example.calculatror.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "`films`")
public class films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String title;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String year;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String film;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String studiay;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private tags tagsy;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private genres genresy;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private agelimit agelimity;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private actors actorsy;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private direct directy;

    @OneToMany(mappedBy = "filmss")
    private Collection<tickets> tenats;
//    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "filmss")
    private Collection<reviews> tkt;

    public films(String title, String year, String film, String studiay, tags tagsy, genres genresy, agelimit agelimity, actors actorsy, direct directy) {
        this.title = title;
        this.year = year;
        this.film = film;
        this.studiay = studiay;
        this.tagsy = tagsy;
        this.genresy = genresy;
        this.agelimity = agelimity;
        this.actorsy = actorsy;
        this.directy = directy;
    }

    public films() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getStudiay() {
        return studiay;
    }

    public void setStudiay(String studiay) {
        this.studiay = studiay;
    }

    public tags getTagsy() {
        return tagsy;
    }

    public void setTagsy(tags tagsy) {
        this.tagsy = tagsy;
    }

    public genres getGenresy() {
        return genresy;
    }

    public void setGenresy(genres genresy) {
        this.genresy = genresy;
    }

    public agelimit getAgelimity() {
        return agelimity;
    }

    public void setAgelimity(agelimit agelimity) {
        this.agelimity = agelimity;
    }

    public actors getActorsy() {
        return actorsy;
    }

    public void setActorsy(actors actorsy) {
        this.actorsy = actorsy;
    }

    public direct getDirecty() {
        return directy;
    }

    public void setDirecty(direct directy) {
        this.directy = directy;
    }

    public Collection<tickets> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<tickets> tenats) {
        this.tenats = tenats;
    }

    public Collection<reviews> getTkt() {
        return tkt;
    }

    public void setTkt(Collection<reviews> tkt) {
        this.tkt = tkt;
    }
}
