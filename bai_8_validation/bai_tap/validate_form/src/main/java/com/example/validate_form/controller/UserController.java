package com.example.validate_form.controller;
import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/list")
    public ModelAndView showList() {
        List<User> user = iUserService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        return new ModelAndView("create", "user", new UserDto());
    }

    @PostMapping("/create")
    public String saveMusic(@ModelAttribute("user") @Validated UserDto userDto, BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            model.addAttribute("message", "Congritation!!!!!!!!!OK ");
            return "create";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdate(@PathVariable int id) {
        Optional<User> user = iUserService.findById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user.get(), userDto);
        return new ModelAndView("update", "userDto", userDto);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("userDto", userDto);
            return "update";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        model.addAttribute("message", " Congritation!!!!!!!!!OK");
        return "update";
    }
}
