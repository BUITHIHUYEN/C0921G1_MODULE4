package com.example.validate_form.controller;

import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/validate")
    public ModelAndView checkValidation(@ModelAttribute @Validated User user, BindingResult bindingResult) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("register");
        }
        return new ModelAndView("success");
    }
}
