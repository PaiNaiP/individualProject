package com.example.calculatror.controller;

import com.example.calculatror.model.films;
import com.example.calculatror.model.todos;
import com.example.calculatror.repo.filmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        ArrayList<todos> filmsArrayList = new ArrayList<>();
        newsList.ifPresent(filmsArrayList::add);
        model.addAttribute("todos", filmsArrayList);
        return "todos/edit-todos";
    }

    @PostMapping("/edit/{id}")
    public String editFilms(
            @PathVariable("id") int Id,
            @RequestParam("title") String title,
            @RequestParam("about") String about,
            @RequestParam("todo") String todo,
            @RequestParam("min") Integer min,
            @RequestParam("restart") Integer restart,
            Model model
    ){
        todos todos = todosRepository.findById(Id).orElseThrow();
        todos.setTitle(title);
        todos.setAbout(about);
        todos.setTodo(todo);
        todos.setMin(min);
        todos.setRestart(restart);

        todosRepository.save(todos);
        return  "redirect:/todos/";
    }
}
