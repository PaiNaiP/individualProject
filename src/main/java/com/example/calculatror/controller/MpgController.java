package com.example.calculatror.controller;

import com.example.calculatror.model.mpgusk;
import com.example.calculatror.model.student;
import com.example.calculatror.repo.MpgRepository;
import com.example.calculatror.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MpgController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MpgRepository mpgRepository;

    @GetMapping("/student")
    private String stumpg(Model model){
        Iterable<student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        Iterable<mpgusk> universities = mpgRepository.findAll();
        model.addAttribute("mpg", universities);

        return "student";
    }
    @PostMapping("/student/add")
    public String blogPostAdd(@RequestParam String student, @RequestParam int mpg, Model model)

    {
        student student2 = studentRepository.findByZvanie(student);
        mpgusk university2 = mpgRepository.findByKurs(mpg);
        student2.getMpg().add(university2);
        university2.getStudents().add(student2);
        studentRepository.save(student2);
        mpgRepository.save(university2);
        return "student";
    }
}
