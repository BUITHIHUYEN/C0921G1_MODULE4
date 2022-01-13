package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.ICaculator;
import vn.codegym.service.imp.CaculatorImpl;

@Controller
public class CaculatorController {
    @Autowired
    CaculatorImpl caculatorImpl;

    @RequestMapping("/caculator")
    public String caculator() {
        return "index";
    }

    @PostMapping("/caculator")
    public String caculator(@RequestParam String caculator, @RequestParam double number1, @RequestParam double number2, Model model) {
        double ketQua = caculatorImpl.caculation(caculator, number1, number2);
        model.addAttribute("result", ketQua);
        return "index";
    }

}
