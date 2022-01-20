package com.example.quan_ly_bai_hat.controller;

import com.example.quan_ly_bai_hat.model.Music;
import com.example.quan_ly_bai_hat.service.IMusicService;
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

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;
    @GetMapping("music")
    public ModelAndView showList() {
        List<Music> musicList = iMusicService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("musicList", musicList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "music", new Music());
    }

    @PostMapping("/create")
    public String saveMusic(@ModelAttribute("music") @Validated Music music, BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            iMusicService.save(music);
            model.addAttribute("mess", "Thêm mới thành công ");
            return "redirect:/create";
        }
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable int id) {
        Music music = iMusicService.findById(id);
        return new ModelAndView("update", "music", music);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated Music music, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("music", music);
            return "update";
        }
        model.addAttribute("mess", "Chỉnh sửa thành công ");
        return "update";
    }
}
