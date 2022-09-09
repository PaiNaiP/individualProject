package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.model.todos;
import com.example.calculatror.repo.filmsRepository;
import com.example.calculatror.repo.todosRepository;
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
@RequestMapping("/todos")
public class TodosController {
    @Autowired
    private com.example.calculatror.repo.todosRepository todosRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<todos> todos = todosRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos/index";
    }
    @GetMapping("/add")
    public String add_vies(todos todos,Model model){
        return "todos/add-todos";
    }
    @PostMapping("/add")
    public String post(@Valid todos newTodo,
                       BindingResult bindingResult,
                       Model model){
        if (bindingResult.hasErrors())
            return "todos/add-todos";
        todosRepository.save(newTodo);
        return "redirect:/todos/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("title") String title,
            Model model)
    {
        List<todos> todosList = todosRepository.findByTitleContains(title);
        model.addAttribute("todos", todosList);
        return "todos/index";
    }
    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") int id,
            Model model)
    {
        Optional<todos> newsList = todosRepository.findById(id);
        ArrayList<todos> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("todos", filmsArrayList);
        return "todos/info-todos";
    }

    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") int id,
            Model model)
    {
        todosRepository.deleteById(id);
        return "redirect:/todos/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") int id,
            Model model)
    {
        if(!todosRepository.existsById(id))
        {
            return "redirect:/todos/";
        }
        Optional<todos> newsList = todosRepository.findById(id);
        ArrayList<todos> todosArrayList = new ArrayList<>();
        newsList.ifPresent(todosArrayList::add);
        model.addAttribute("todos", todosArrayList.get(0));
        return "todos/edit-todos";
    }

    @PostMapping("/edit/{id}")
    public String editTodos(
            @PathVariable("id") int Id,
            @ModelAttribute("todos") @Valid todos newTodo, BindingResult bindingResult,
            Model model
    ){
        if(!todosRepository.existsById(Id))
        {
            return "redirect:/todos/";
        }
        if (bindingResult.hasErrors())
            return "todos/edit-todos";

        newTodo.setId(Id);

        todosRepository.save(newTodo);
        return  "redirect:/todos/";
    }
}
