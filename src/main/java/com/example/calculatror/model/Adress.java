package com.example.calculatror.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String street;
    private String building;
    @OneToMany(mappedBy = "adress", fetch = FetchType.EAGER)
    private Collection<Shop> tenats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Collection<Shop> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<Shop> tenats) {
        this.tenats = tenats;
    }
}
