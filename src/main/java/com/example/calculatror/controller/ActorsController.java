package com.example.calculatror.controller;

import com.example.calculatror.model.actors;
import com.example.calculatror.repo.ActorsRepository;
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
@RequestMapping("/actors")
public class ActorsController {
    @Autowired
    private ActorsRepository actorsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<actors> ageLimits = actorsRepository.findAll();
        model.addAttribute("actors", ageLimits);
        return "actors/index";
    }
    @GetMapping("/add")
    public String add_vies(actors ageLimit, Model model){
        return "actors/add-actors";
    }
    @PostMapping("/add")
    public String post(@Valid actors newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "actors/add-actors";
        actorsRepository.save(newAgelimit);
        return "redirect:/actors/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("surname") String surname,
            Model model)
    {
        List<actors> newsList = actorsRepository.findBysurnameContains(surname);
        model.addAttribute("actors", newsList);
        return "actors/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<actors> newsList = actorsRepository.findById(id);
        ArrayList<actors> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("actors", filmsArrayList);
        return "actors/info-actors";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        actorsRepository.deleteById(id);
        return "redirect:/actors/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!actorsRepository.existsById(id))
        {
            return "redirect:/actors/";
        }
        Optional<actors> newsList = actorsRepository.findById(id);
        ArrayList<actors> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("actors", filmsArrayList.get(0));
        return "actors/edit-actors";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("actors") @Valid actors newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!actorsRepository.existsById(Id))
        {
            return "redirect:/actors/";
        }
        if (bindingResult.hasErrors())
            return "actors/edit-actors";

        newFilm.setId(Id);

        actorsRepository.save(newFilm);
        return  "redirect:/actors/";
    }
}
