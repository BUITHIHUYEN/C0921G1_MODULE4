package vn.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("save")
    public String save(){
        return "index";
    }

    @PostMapping("save")
    public String save(@RequestParam ("condiment") String[] condiment , Model model ){
        model.addAttribute("result",condiment);
        return "index";


    }
}
