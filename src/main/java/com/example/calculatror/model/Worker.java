package com.example.calculatror.model;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String lastname;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "PhoneNumber_id")
    private PhoneNumber phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Worker(String name, String surname, String lastname, PhoneNumber phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public Worker(){

    }
}
