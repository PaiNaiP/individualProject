package com.example.calculatror.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class todos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть больше ", min = 3, max = 100)
    String title, todo;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть больше ", min = 3, max = 10000)
    String about;

    @Min(message = "Количество не отризательное", value = 0)
    @Max(message = "Количество не больше 100", value = 10)

    @NotNull(message = "Не, это обязательно")
    Integer min, restart;

    public todos(String title, String about, String todo, Integer min, Integer restart) {
        this.title = title;
        this.about = about;
        this.todo = todo;
        this.min = min;
        this.restart = restart;
    }

    public todos() {
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getRestart() {
        return restart;
    }

    public void setRestart(Integer restart) {
        this.restart = restart;
    }
}
