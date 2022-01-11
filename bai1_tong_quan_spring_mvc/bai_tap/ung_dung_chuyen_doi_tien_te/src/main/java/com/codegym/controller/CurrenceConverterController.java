package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrenceConverterController {
    @GetMapping ("/currence")
    public String currence(){
        return "test";
    }
    @PostMapping ("/currence")
    public String converter(@RequestParam int usd,Model model){
        int vnd = usd*24000;
        model.addAttribute("result",vnd);
        return "test";
    }

}
