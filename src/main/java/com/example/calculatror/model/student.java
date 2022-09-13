package com.example.calculatror.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String zvanie;
    @ManyToMany
    @JoinTable(name="student_mpg",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="mpg_id"))
    private List<mpgusk> mpg;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getZvanie() {
        return zvanie;
    }

    public void setZvanie(String zvanie) {
        this.zvanie = zvanie;
    }

    public List<mpgusk> getMpg() {
        return mpg;
    }

    public void setMpg(List<mpgusk> mpg) {
        this.mpg = mpg;
    }

    public student(String zvanie, List<mpgusk> mpg) {
        this.zvanie = zvanie;
        this.mpg = mpg;
    }

    public student() {
    }
}
