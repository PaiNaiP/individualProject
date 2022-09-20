package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String titling;

    @Min(message = "Количество не отризательное", value = 0)
    @Max(message = "Количество не больше 10", value = 10)
    @NotNull(message = "Не, это обязательно")
    Integer likes;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 10000)
    String review;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private films filmss;

    public reviews(String titling, Integer likes, String review, films filmss) {
        this.titling = titling;
        this.likes = likes;
        this.review = review;
        this.filmss = filmss;
    }

    public reviews() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitling() {
        return titling;
    }

    public void setTitling(String titling) {
        this.titling = titling;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public films getFilmss() {
        return filmss;
    }

    public void setFilmss(films filmss) {
        this.filmss = filmss;
    }
}
