package com.leeonscoding.thymeleafexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class MvcController {

    @GetMapping("list")
    public ModelAndView customerList() {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer(1, "test1", "test1@mail.com", "m"));
        list.add(new Customer(2, "test2", "test2@mail.com", "m"));
        list.add(new Customer(3, "test3", "test3@mail.com", "f"));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer-list");
        mv.addObject("customers", list);

        return mv;
    }

    @GetMapping("{id}")
    public ModelAndView customerDetails(@PathVariable int id) {
        Customer customer =new Customer(id, "test1", "test1@mail.com", "m");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer-details");
        mv.addObject("customer", customer);

        return mv;
    }

    @GetMapping("createForm")
    public String createCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        List<String> genderList = List.of("m", "f");
        model.addAttribute("genderList", genderList);

        return "create-customer";
    }

    @PostMapping("save")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer-details");
        mv.addObject("customer", customer);

        return mv;
    }

}
