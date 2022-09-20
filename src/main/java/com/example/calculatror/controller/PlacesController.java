package com.example.calculatror.controller;

import com.example.calculatror.model.places;
import com.example.calculatror.repo.PlacesRepository;
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
@RequestMapping("/places")
public class PlacesController {
    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<places> ageLimits = placesRepository.findAll();
        model.addAttribute("places", ageLimits);
        return "places/index";
    }
    @GetMapping("/add")
    public String add_vies(places ageLimit, Model model){
        return "places/add-places";
    }
    @PostMapping("/add")
    public String post(@Valid places newAgelimit,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "places/add-places";
        placesRepository.save(newAgelimit);
        return "redirect:/places/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("place") Integer place,
            Model model)
    {
        List<places> newsList = placesRepository.findByplaceContains(place);
        model.addAttribute("places", newsList);
        return "places/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<places> newsList = placesRepository.findById(id);
        ArrayList<places> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("places", filmsArrayList);
        return "places/info-places";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        placesRepository.deleteById(id);
        return "redirect:/places/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!placesRepository.existsById(id))
        {
            return "redirect:/places/";
        }
        Optional<places> newsList = placesRepository.findById(id);
        ArrayList<places> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("places", filmsArrayList.get(0));
        return "places/edit-places";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("places") @Valid places newFilm, BindingResult bindingResult,
            Model model
    ){
        if(!placesRepository.existsById(Id))
        {
            return "redirect:/places/";
        }
        if (bindingResult.hasErrors())
            return "places/edit-places";

        newFilm.setId(Id);

        placesRepository.save(newFilm);
        return  "redirect:/places/";
    }
}
