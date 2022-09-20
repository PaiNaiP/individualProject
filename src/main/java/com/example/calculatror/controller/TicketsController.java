package com.example.calculatror.controller;

import com.example.calculatror.model.*;
import com.example.calculatror.repo.FilmsRepository;
import com.example.calculatror.repo.PlacesRepository;
import com.example.calculatror.repo.TicketsRepository;
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
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    FilmsRepository filmsRepository;
    @Autowired
    PlacesRepository placesRepository;
    @Autowired
    TicketsRepository ticketsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<tickets> ageLimits = ticketsRepository.findAll();
        model.addAttribute("tickets", ageLimits);
        return "tickets/index";
    }

    @GetMapping("/add")
    public String add_vies(Model model) {
        Iterable<places> plac = placesRepository.findAll();
        Iterable<films> fil = filmsRepository.findAll();

        model.addAttribute("places", plac);
        model.addAttribute("films", fil);
        return "tickets/add-tickets";
    }

    @PostMapping("/add")
    public String post(@Valid tickets newAgelimit,
                       BindingResult bindingResult,
                       @RequestParam String time,
                       @RequestParam String date,
                       @RequestParam Integer place,
                       @RequestParam String title,
                       Model model
    )
    {
        if (bindingResult.hasErrors())
            return "tickets/add-tickets";
        films flm = filmsRepository.findBytitle(title);
        places plc = placesRepository.findByplace(place);
        tickets prsn = new tickets(time, date, plc, flm);
        ticketsRepository.save(prsn);
        return "redirect:/tickets/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("date") String date,
            Model model)
    {
        List<tickets> newsList = ticketsRepository.findBydateContains(date);
        model.addAttribute("tickets", newsList);
        return "tickets/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<tickets> newsList = ticketsRepository.findById(id);
        ArrayList<tickets> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("tickets", filmsArrayList);
        return "tickets/info-tickets";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       Model model) {
        if(!filmsRepository.existsById(id))
        {
            return "redirect:/tickets/";
        }
        Optional<tickets> tct = ticketsRepository.findById(id);
        ArrayList<tickets> filmsArrayList = new ArrayList<>();
        tct.ifPresent(filmsArrayList::add);
        Iterable<films> flm = filmsRepository.findAll();
        Iterable<places> plc = placesRepository.findAll();
        model.addAttribute("tickets", filmsArrayList.get(0));
        model.addAttribute("films", flm);
        model.addAttribute("places", plc);
        return "tickets/edit-tickets";
    }
    @PostMapping("/edit/{id}")
    public String ediFilms(@PathVariable("id") int id,
                           @Valid tickets newAgelimit,
                           BindingResult bindingResult,
                           @RequestParam String date,
                           @RequestParam String time,
                           @RequestParam Integer place,
                           @RequestParam String title,
                           Model model
    )
    {
        if(!ticketsRepository.existsById(id))
        {
            return "redirect:/tickets/";
        }
        if (bindingResult.hasErrors())
            return "tickets/edit-tickets";
        tickets tcs = ticketsRepository.findById(id).orElseThrow();
        films flm = filmsRepository.findBytitle(title);
        places plc = placesRepository.findByplace(place);
        tcs.setDate(date);
        tcs.setTime(time);
        tcs.setPlacess(plc);
        tcs.setFilmss(flm);
        tcs.setId(id);
        //films prsn = new films(title, year, film, studiay, tgs, gnr, aglmt, actr, drct);
        ticketsRepository.save(tcs);
        return "redirect:/tickets/";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        ticketsRepository.deleteById(id);
        return "redirect:/tickets/";
    }
}
