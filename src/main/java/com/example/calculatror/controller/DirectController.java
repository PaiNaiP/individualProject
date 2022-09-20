package com.example.calculatror.controller;

import com.example.calculatror.model.direct;
import com.example.calculatror.repo.DirectRepository;
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
@RequestMapping("/direct")
public class DirectController {
    @Autowired
    private DirectRepository directRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<direct> ageLimits = directRepository.findAll();
        model.addAttribute("direct", ageLimits);
        return "direct/index";
    }
    @GetMapping("/add")
    public String add_vies(direct ageLimit, Model model){
        return "direct/add-direct";
    }
    @PostMapping("/add")
    public String post(@Valid direct newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "direct/add-direct";
        directRepository.save(newAgelimit);
        return "redirect:/direct/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("surnamey") String surnamey,
            Model model)
    {
        List<direct> newsList = directRepository.findBysurnameyContains(surnamey);
        model.addAttribute("direct", newsList);
        return "direct/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<direct> newsList = directRepository.findById(id);
        ArrayList<direct> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("direct", filmsArrayList);
        return "direct/info-direct";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        directRepository.deleteById(id);
        return "redirect:/direct/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!directRepository.existsById(id))
        {
            return "redirect:/direct/";
        }
        Optional<direct> newsList = directRepository.findById(id);
        ArrayList<direct> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("direct", filmsArrayList.get(0));
        return "direct/edit-direct";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("direct") @Valid direct newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!directRepository.existsById(Id))
        {
            return "redirect:/direct/";
        }
        if (bindingResult.hasErrors())
            return "direct/edit-direct";

        newFilm.setId(Id);

        directRepository.save(newFilm);
        return  "redirect:/direct/";
    }
}
