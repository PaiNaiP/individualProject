package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.model.places;
import com.example.calculatror.model.reviews;
import com.example.calculatror.model.tickets;
import com.example.calculatror.repo.FilmsRepository;
import com.example.calculatror.repo.ReviewsRepository;
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
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    FilmsRepository filmsRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<reviews> ageLimits = reviewsRepository.findAll();
        model.addAttribute("reviews", ageLimits);
        return "reviews/index";
    }
    @GetMapping("/add")
    public String add_vies(reviews ageLimit, Model model){
        Iterable<films> fil = filmsRepository.findAll();
        model.addAttribute("films", fil);
        return "reviews/add-reviews";
    }
    @PostMapping("/add")
    public String post(@Valid tickets newAgelimit,
                       BindingResult bindingResult,
                       @RequestParam String titling,
                       @RequestParam Integer likes,
                       @RequestParam String review,
                       @RequestParam String title,
                       Model model){

        films flm = filmsRepository.findBytitle(title);
        reviews prsn = new reviews(titling, likes, review, flm);
        reviewsRepository.save(prsn);
        return "redirect:/reviews/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("titling") String titling,
            Model model)
    {
        List<reviews> newsList = reviewsRepository.findBytitlingContains(titling);
        model.addAttribute("reviews", newsList);
        return "reviews/index";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<reviews> newsList = reviewsRepository.findById(id);
        ArrayList<reviews> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("reviews", filmsArrayList);
        return "reviews/info-reviews";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        reviewsRepository.deleteById(id);
        return "redirect:/reviews/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!reviewsRepository.existsById(id))
        {
            return "redirect:/reviews/";
        }
        Optional<reviews> newsList = reviewsRepository.findById(id);
        ArrayList<reviews> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        Iterable<films> flm = filmsRepository.findAll();
        model.addAttribute("reviews", filmsArrayList.get(0));
        model.addAttribute("films", flm);
        return "reviews/edit-reviews";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @ModelAttribute("reviews") @Valid reviews newFilm, BindingResult bindingResult,
            @RequestParam String titling,
            @RequestParam Integer likes,
            @RequestParam String review,
            @RequestParam String title,
            Model model
    ){
        if(!reviewsRepository.existsById(Id))
        {
            return "redirect:/reviews/";
        }
        if (bindingResult.hasErrors())
            return "reviews/edit-reviews";

        reviews tcs = reviewsRepository.findById(Id).orElseThrow();
        films flm = filmsRepository.findBytitle(title);
        tcs.setTitling(titling);
        tcs.setLikes(likes);
        tcs.setReview(review);
        tcs.setFilmss(flm);
        tcs.setId(Id);
        //films prsn = new films(title, year, film, studiay, tgs, gnr, aglmt, actr, drct);
        reviewsRepository.save(tcs);
        return  "redirect:/reviews/";
    }
}
