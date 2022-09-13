package com.example.calculatror.controller;

import com.example.calculatror.model.Adress;
import com.example.calculatror.model.Shop;
import com.example.calculatror.repo.AddressRepository;
import com.example.calculatror.repo.ShopRepository;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public ShopRepository shopRepository;

    @GetMapping("/shop")
    public String Main(Model model){
        Iterable<Adress> adress = addressRepository.findAll();
        model.addAttribute("adress",adress);
        return "shop";
    }

    @PostMapping("/shop/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String street, Model model)
    {
        Adress adress = addressRepository.findByStreet(street);
        Shop person = new Shop(title, adress);
        shopRepository.save(person);
        return "shop";
    }
}
