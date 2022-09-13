package com.example.calculatror.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class mpgusk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private int kurs;
    @ManyToMany
    @JoinTable(name="student_mpg",
            joinColumns=@JoinColumn(name="mpg_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<student> students;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }
}
