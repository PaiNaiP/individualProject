package com.example.calculatror.controller;

import com.example.calculatror.model.agelimit;
import com.example.calculatror.repo.AgeLimitRepository;
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
@RequestMapping("/agelimit")
public class AgeLimitController {
    @Autowired
    private AgeLimitRepository ageLimitRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<agelimit> ageLimits = ageLimitRepository.findAll();
        model.addAttribute("agelimit", ageLimits);
        return "agelimit/index";
    }
    @GetMapping("/add")
    public String add_vies(agelimit ageLimit, Model model){
        return "agelimit/add-agelimit";
    }
    @PostMapping("/add")
    public String post(@Valid agelimit newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "agelimit/add-agelimit";
        ageLimitRepository.save(newAgelimit);
        return "redirect:/agelimit/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("agelimitrus") String agelimitrus,
            Model model)
    {
        List<agelimit> newsList = ageLimitRepository.findByagelimitrusContains(agelimitrus);
        model.addAttribute("agelimit", newsList);
        return "agelimit/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<agelimit> newsList = ageLimitRepository.findById(id);
        ArrayList<agelimit> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("agelimit", filmsArrayList);
        return "agelimit/info-agelimit";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        ageLimitRepository.deleteById(id);
        return "redirect:/agelimit/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!ageLimitRepository.existsById(id))
        {
            return "redirect:/agelimit/";
        }
        Optional<agelimit> newsList = ageLimitRepository.findById(id);
        ArrayList<agelimit> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("agelimit", filmsArrayList.get(0));
        return "agelimit/edit-agelimit";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("agelimit") @Valid agelimit newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!ageLimitRepository.existsById(Id))
        {
            return "redirect:/agelimit/";
        }
        if (bindingResult.hasErrors())
            return "agelimit/edit-agelimit";

        newFilm.setId(Id);

        ageLimitRepository.save(newFilm);
        return  "redirect:/agelimit/";
    }
}
