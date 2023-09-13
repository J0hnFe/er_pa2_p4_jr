package com.example.er_pa2_p4_jr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    //http://localhost:8080/universidad/menu/general
    @GetMapping("/general")
    private String menuGeneral(){
        return "vistaGeneral";
    }
    
}
