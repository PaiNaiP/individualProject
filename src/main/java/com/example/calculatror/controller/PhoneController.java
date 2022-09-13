package com.example.calculatror.controller;


import com.example.calculatror.model.PhoneNumber;
import com.example.calculatror.model.Worker;
import com.example.calculatror.repo.PhoneNumberRepository;
import com.example.calculatror.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhoneController {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/phoneNumber")
    public String Main(Model model){
        Iterable<PhoneNumber> phoneNumber = phoneNumberRepository.findAll();
        model.addAttribute("phoneNumber", phoneNumber);
        return "phoneNumber";
    }

    @PostMapping("/phoneNumber/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String surname, @RequestParam String lastname, @RequestParam String number, Model model)
    {
        System.out.println(name);
        PhoneNumber phone = phoneNumberRepository.findByNumber(number);
        System.out.println(phone.getId());
        Worker worker = new Worker(name,surname, lastname, phone);
        workerRepository.save(worker);
        return "phoneNumber";
    }
}
