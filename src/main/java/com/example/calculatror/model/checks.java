package com.example.calculatror.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "`checks`")
public class checks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty(message = "Поле не пустое")
    @Size(message = "Строка не может быть такой ", min = 0, max = 100)
    String dating;

    @Min(message = "Количество не отризательное", value = 0)
    @Max(message = "Количество не больше 5", value = 5)
    @NotNull(message = "Не, это обязательно")
    Integer ticketlenght;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private tickets ticketss;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User users;

    public checks(String dating, Integer ticketlenght, tickets ticketss, User users) {
        this.dating = dating;
        this.ticketlenght = ticketlenght;
        this.ticketss = ticketss;
        this.users = users;
    }

    public checks() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDating() {
        return dating;
    }

    public void setDating(String dating) {
        this.dating = dating;
    }

    public Integer getTicketlenght() {
        return ticketlenght;
    }

    public void setTicketlenght(Integer ticketlenght) {
        this.ticketlenght = ticketlenght;
    }

    public tickets getTicketss() {
        return ticketss;
    }

    public void setTicketss(tickets ticketss) {
        this.ticketss = ticketss;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
