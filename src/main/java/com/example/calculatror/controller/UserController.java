package com.example.calculatror.controller;

import com.example.calculatror.model.Role;
import com.example.calculatror.model.User;
import com.example.calculatror.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String all_users(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "info-users";
    }
    @GetMapping("/edit/{id}")
    public String user_role(@PathVariable("id") int id,
                            Model model){
        Optional<User> user_raw = userRepository.findById(id);
        ArrayList<User> userArrayList = new ArrayList<>();
        user_raw.ifPresent(userArrayList::add);
        model.addAttribute("one_user", userArrayList);
        model.addAttribute("roles", Role.values());
        return "edit-users";
    }
}
