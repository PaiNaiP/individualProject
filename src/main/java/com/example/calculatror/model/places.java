package com.example.calculatror.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class places {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Min(message = "Количество не отризательное", value = 0)
    @Max(message = "Количество не больше 10", value = 20)
    @NotNull(message = "Не, это обязательно")
    Integer place, row, hall;

    @OneToMany(mappedBy = "placess", fetch = FetchType.EAGER)
    private Collection<tickets> tenats;

    public places(Integer place, Integer row, Integer hall, Collection<tickets> tenats) {
        this.place = place;
        this.row = row;
        this.hall = hall;
        this.tenats = tenats;
    }

    public places() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Collection<tickets> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<tickets> tenats) {
        this.tenats = tenats;
    }
}
