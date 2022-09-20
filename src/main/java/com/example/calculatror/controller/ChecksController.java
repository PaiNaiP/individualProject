package com.example.calculatror.controller;

import com.example.calculatror.model.*;
import com.example.calculatror.repo.ChecksRepository;
import com.example.calculatror.repo.TicketsRepository;
import com.example.calculatror.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/checks")
public class ChecksController {
    @Autowired
    TicketsRepository ticketsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChecksRepository checksRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<checks> ageLimits = checksRepository.findAll();
        model.addAttribute("checks", ageLimits);
        return "checks/index";
    }

    @GetMapping("/add")
    public String add_vies(Model model) {
        Iterable<tickets> tct = ticketsRepository.findAll();
        Iterable<User> us = userRepository.findAll();

        model.addAttribute("tickets", tct);
        model.addAttribute("User", us);
        return "checks/add-checks";
    }
    @PostMapping("/add")
    public String post(@Valid tickets newAgelimit,
                       BindingResult bindingResult,
                       @RequestParam String dating,
                       @RequestParam Integer ticketlenght,
                       @RequestParam String date,
                       @RequestParam String username,
                       Model model
    )
    {

        tickets tct = ticketsRepository.findBydate(date);
        User us = userRepository.findByUsername(username);
        checks chc = new checks(dating, ticketlenght, tct, us);
        checksRepository.save(chc);
        return "redirect:/checks/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("dating") String dating,
            Model model)
    {
        List<checks> newsList = checksRepository.findBydatingContains(dating);
        model.addAttribute("checks", newsList);
        return "checks/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<checks> newsList = checksRepository.findById(id);
        ArrayList<checks> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("checks", filmsArrayList);
        return "checks/info-checks";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       Model model) {
        if(!checksRepository.existsById(id))
        {
            return "redirect:/checks/";
        }
        Optional<checks> chc = checksRepository.findById(id);
        ArrayList<checks> filmsArrayList = new ArrayList<>();
        chc.ifPresent(filmsArrayList::add);
        Iterable<tickets> tct = ticketsRepository.findAll();
        Iterable<User> us = userRepository.findAll();
        model.addAttribute("checks", filmsArrayList.get(0));
        model.addAttribute("tickets", tct);
        model.addAttribute("User", us);
        return "checks/edit-checks";
    }

    @PostMapping("/edit/{id}")
    public String ediFilms(@PathVariable("id") int id,
                           @Valid checks newAgelimit,
                           BindingResult bindingResult,
                           @RequestParam String dating,
                           @RequestParam Integer ticketlenght,
                           @RequestParam String date,
                           @RequestParam String username,
                           Model model
    )
    {
        if(!checksRepository.existsById(id))
        {
            return "redirect:/checks/";
        }
        if (bindingResult.hasErrors())
            return "checks/edit-checks";
        checks chc = checksRepository.findById(id).orElseThrow();
        tickets tct = ticketsRepository.findBydate(date);
        User us = userRepository.findByUsername(username);
        chc.setDating(dating);
        chc.setTicketlenght(ticketlenght);
        chc.setTicketss(tct);
        chc.setUsers(us);
        chc.setId(id);
        //films prsn = new films(title, year, film, studiay, tgs, gnr, aglmt, actr, drct);
        checksRepository.save(chc);
        return "redirect:/checks/";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        checksRepository.deleteById(id);
        return "redirect:/checks/";
    }
}
