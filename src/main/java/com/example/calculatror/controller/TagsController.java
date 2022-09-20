package com.example.calculatror.controller;

import com.example.calculatror.model.tags;
import com.example.calculatror.repo.TagsRepository;
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
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    private TagsRepository tagsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<tags> ageLimits = tagsRepository.findAll();
        model.addAttribute("tags", ageLimits);
        return "tags/index";
    }
    @GetMapping("/add")
    public String add_vies(tags ageLimit, Model model){
        return "tags/add-tags";
    }
    @PostMapping("/add")
    public String post(@Valid tags newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "tags/add-tags";
        tagsRepository.save(newAgelimit);
        return "redirect:/tags/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("titlee") String titlee,
            Model model)
    {
        List<tags> newsList = tagsRepository.findBytitleeContains(titlee);
        model.addAttribute("tags", newsList);
        return "tags/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<tags> newsList = tagsRepository.findById(id);
        ArrayList<tags> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("tags", filmsArrayList);
        return "tags/info-tags";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        tagsRepository.deleteById(id);
        return "redirect:/tags/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!tagsRepository.existsById(id))
        {
            return "redirect:/tags/";
        }
        Optional<tags> newsList = tagsRepository.findById(id);
        ArrayList<tags> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("tags", filmsArrayList.get(0));
        return "tags/edit-tags";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("tags") @Valid tags newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!tagsRepository.existsById(Id))
        {
            return "redirect:/tags/";
        }
        if (bindingResult.hasErrors())
            return "tags/edit-tags";

        newFilm.setId(Id);

        tagsRepository.save(newFilm);
        return  "redirect:/tags/";
    }

}
