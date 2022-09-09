package com.example.calculatror.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть больше ", min = 3, max = 100)
    String title;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть больше ", min = 3, max = 10000)
    String description;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть больше ", min = 3, max = 100)
    String direct;


    @Min(message = "Количество не отризательное", value = 0)
    @Max(message = "Количество не больше 100", value = 10)

    @NotNull(message = "Не, это обязательно")
    Integer siries, likes;

//    @NotBlank
//    @DecimalMax()
//    @DecimalMin()
//    @Digits()
//    @Negative
//    @NegativeOrZero
//    @Positive
//    @PositiveOrZero
//
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
//    @Email
//    @AssertFalse

    public films(String title, String description, String direct, Integer siries, Integer likes) {
        this.title = title;
        this.description = description;
        this.direct = direct;
        this.siries = siries;
        this.likes = likes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public Integer getSiries() {
        return siries;
    }

    public void setSiries(Integer siries) {
        this.siries = siries;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
