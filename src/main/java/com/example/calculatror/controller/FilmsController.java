package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.repo.filmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/films")
public class FilmsController {
    @Autowired
    private filmsRepository filmsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<films> films = filmsRepository.findAll();
        model.addAttribute("films", films);
        return "films/index";
    }
    @GetMapping("/add")
    public String add_vies(Model model){
        return "films/add-films";
    }
    @PostMapping("/add")
    public String post(@RequestParam("title") String title,
                       @RequestParam("description") String description,
                       @RequestParam("direct") String direct,
                       @RequestParam("likes") Integer likes,
                       @RequestParam("siries") Integer siries,
                       Model model){
        films filmsOne = new films(title, description, direct, likes, siries);
        filmsRepository.save(filmsOne);
        return "redirect:/films/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("title") String title,
            Model model)
    {
        List<films> newsList = filmsRepository.findByTitleContains(title);
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

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        filmsRepository.deleteById(id);
        return "redirect:/films/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!filmsRepository.existsById(id))
        {
            return "redirect:/films/";
        }
        Optional<films> newsList = filmsRepository.findById(id);
        ArrayList<films> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("films", filmsArrayList);
        return "films/edit-films";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("direct") String direct,
            @RequestParam("likes") Integer likes,
            @RequestParam("siries") Integer siries,
            Model model
    ){
        films films = filmsRepository.findById(Id).orElseThrow();
        films.setTitle(title);
        films.setDescription(description);
        films.setDirect(direct);
        films.setLikes(likes);
        films.setSiries(siries);

        filmsRepository.save(films);
        return  "redirect:/films/";
    }
}
