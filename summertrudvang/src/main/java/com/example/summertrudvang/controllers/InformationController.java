package com.example.summertrudvang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/test")
public class InformationController {

    @GetMapping
    public ModelAndView getTestData(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.getModel().put("data", "Welcome home man");

        return mv;
    }
    @RequestMapping(value="/rule")
    @PostMapping
    public void postRule(){

    }

    @RequestMapping(value="/postInformation")
    @PostMapping
    public void postInformation(){

    }

}

