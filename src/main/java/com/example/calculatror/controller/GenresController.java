package com.example.calculatror.controller;


import com.example.calculatror.model.genres;
import com.example.calculatror.repo.GenresRepository;
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
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private GenresRepository genresRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<genres> ageLimits = genresRepository.findAll();
        model.addAttribute("genres", ageLimits);
        return "genres/index";
    }
    @GetMapping("/add")
    public String add_vies(genres ageLimit, Model model){
        return "genres/add-genres";
    }
    @PostMapping("/add")
    public String post(@Valid genres newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "genres/add-genres";
        genresRepository.save(newAgelimit);
        return "redirect:/genres/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("genree") String genree,
            Model model)
    {
        List<genres> newsList = genresRepository.findBygenreeContains(genree);
        model.addAttribute("genres", newsList);
        return "genres/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<genres> newsList = genresRepository.findById(id);
        ArrayList<genres> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("genres", filmsArrayList);
        return "genres/info-genres";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        genresRepository.deleteById(id);
        return "redirect:/genres/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!genresRepository.existsById(id))
        {
            return "redirect:/agelimit/";
        }
        Optional<genres> newsList = genresRepository.findById(id);
        ArrayList<genres> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("genres", filmsArrayList.get(0));
        return "genres/edit-genres";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("genres") @Valid genres newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!genresRepository.existsById(Id))
        {
            return "redirect:/genres/";
        }
        if (bindingResult.hasErrors())
            return "genres/edit-genres";

        newFilm.setId(Id);

        genresRepository.save(newFilm);
        return  "redirect:/genres/";
    }
}
