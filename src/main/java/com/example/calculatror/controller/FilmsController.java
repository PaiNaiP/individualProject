package com.example.calculatror.controller;
import com.example.calculatror.repo.ActorsRepository;
import com.example.calculatror.repo.AgeLimitRepository;
import com.example.calculatror.repo.DirectRepository;
import com.example.calculatror.repo.GenresRepository;
import com.example.calculatror.repo.TagsRepository;
import com.example.calculatror.model.actors;
import com.example.calculatror.model.*;
import com.example.calculatror.repo.*;
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
@RequestMapping("/films")
public class FilmsController {
    @Autowired
    ActorsRepository actorsRepository;
    @Autowired
    AgeLimitRepository ageLimitRepository;
    @Autowired
    DirectRepository directRepository;
    @Autowired
    GenresRepository genresRepository;
    @Autowired
    TagsRepository tagsRepository;
    @Autowired
    private FilmsRepository filmsRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<films> ageLimits = filmsRepository.findAll();
        model.addAttribute("films", ageLimits);
        return "films/index";
    }
    @GetMapping("/add")
    public String add_vies(Model model) {
        Iterable<actors> actor = actorsRepository.findAll();
        Iterable<agelimit> agelimits = ageLimitRepository.findAll();
        Iterable<direct> directs = directRepository.findAll();
        Iterable<genres> genre = genresRepository.findAll();
        Iterable<tags> tag = tagsRepository.findAll();
        model.addAttribute("actors", actor);
        model.addAttribute("agelimit", agelimits);
        model.addAttribute("direct", directs);
        model.addAttribute("genres", genre);
        model.addAttribute("tags", tag);
        return "films/add-films";
    }
    @PostMapping("/add")
 public String post(@Valid films newAgelimit,
                    BindingResult bindingResult,
         @RequestParam String title,
                       @RequestParam String year,
                       @RequestParam String film,
                       @RequestParam String studiay,
                       @RequestParam String surname,
                       @RequestParam String agelimitrus,
                       @RequestParam String surnamey,
                       @RequestParam String genree,
                       @RequestParam String titlee,
                    Model model
                       )
    {
//        Adress adress = addressRepository.findByStreet(street);
//        Shop person = new Shop(title, adress);
//        shopRepository.save(person);
//        return "shop";
        if (bindingResult.hasErrors())
            return "films/add-films";
        actors actr = actorsRepository.findBysurname(surname);
        agelimit aglmt = ageLimitRepository.findByagelimitrus(agelimitrus);
        direct drct = directRepository.findBysurnamey(surnamey);
        genres gnr = genresRepository.findBygenree(genree);
        tags tgs = tagsRepository.findBytitlee(titlee);
        films prsn = new films(title, year, film, studiay, tgs, gnr, aglmt, actr, drct);
        filmsRepository.save(prsn);
        return "redirect:/films/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("title") String title,
            Model model)
    {
        List<films> newsList = filmsRepository.findBytitleContains(title);
        model.addAttribute("films", newsList);
        return "films/index";
    }
    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<films> newsList = filmsRepository.findById(id);
        ArrayList<films> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("films", filmsArrayList);
        return "films/info-films";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       Model model) {
        if(!filmsRepository.existsById(id))
        {
            return "redirect:/films/";
        }
        Optional<films> filmm = filmsRepository.findById(id);
        ArrayList<films> filmsArrayList = new ArrayList<>();
        filmm.ifPresent(filmsArrayList::add);
        Iterable<actors> actor = actorsRepository.findAll();
        Iterable<agelimit> agelimits = ageLimitRepository.findAll();
        Iterable<direct> directs = directRepository.findAll();
        Iterable<genres> genre = genresRepository.findAll();
        Iterable<tags> tag = tagsRepository.findAll();
        model.addAttribute("films", filmsArrayList.get(0));
        model.addAttribute("actors", actor);
        model.addAttribute("agelimit", agelimits);
        model.addAttribute("direct", directs);
        model.addAttribute("genres", genre);
        model.addAttribute("tags", tag);
        return "films/edit-films";
    }
    @PostMapping("/edit/{id}")
    public String ediFilms(@PathVariable("id") int id,
                            @Valid films newAgelimit,
                            BindingResult bindingResult,
                            @RequestParam String title,
                            @RequestParam String year,
                            @RequestParam String film,
                            @RequestParam String studiay,
                            @RequestParam String surname,
                            @RequestParam String agelimitrus,
                            @RequestParam String surnamey,
                            @RequestParam String genree,
                            @RequestParam String titlee,
                            Model model
    )
    {
        if(!filmsRepository.existsById(id))
        {
            return "redirect:/films/";
        }
        if (bindingResult.hasErrors())
            return "films/edit-films";
        films filmss = filmsRepository.findById(id).orElseThrow();
        actors actr = actorsRepository.findBysurname(surname);
        agelimit aglmt = ageLimitRepository.findByagelimitrus(agelimitrus);
        direct drct = directRepository.findBysurnamey(surnamey);
        genres gnr = genresRepository.findBygenree(genree);
        tags tgs = tagsRepository.findBytitlee(titlee);
        filmss.setId(id);
        filmss.setTitle(title);
        filmss.setYear(year);
        filmss.setFilm(film);
        filmss.setStudiay(studiay);
        filmss.setTagsy(tgs);
        filmss.setGenresy(gnr);
        filmss.setAgelimity(aglmt);
        filmss.setActorsy(actr);
        filmss.setDirecty(drct);

        //films prsn = new films(title, year, film, studiay, tgs, gnr, aglmt, actr, drct);
        filmsRepository.save(filmss);
        return "redirect:/films/";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        filmsRepository.deleteById(id);
        return "redirect:/films/";
    }
}
