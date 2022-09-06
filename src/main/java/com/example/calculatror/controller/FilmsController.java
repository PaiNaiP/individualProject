package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.repo.filmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
}
