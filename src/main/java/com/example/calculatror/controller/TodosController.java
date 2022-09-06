package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.model.todos;
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
    public String add_vies(Model model){
        return "todos/add-todos";
    }
    @PostMapping("/add")
    public String post(@RequestParam("title") String title,
                       @RequestParam("about") String about,
                       @RequestParam("todo") String todo,
                       @RequestParam("min") Integer min,
                       @RequestParam("restart") Integer restart,
                       Model model){
        todos todosOne = new todos(title, about, todo, min, restart);
        todosRepository.save(todosOne);
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
}
