package com.example.quan_ly_bai_hat.controller;

import com.example.quan_ly_bai_hat.dto.MusicDto;
import com.example.quan_ly_bai_hat.model.Music;
import com.example.quan_ly_bai_hat.service.IMusicService;
import net.bytebuddy.dynamic.DynamicType;
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
public class MusicController {
    @Autowired
    private IMusicService iMusicService;
    @GetMapping("/list")
    public ModelAndView showList() {
        List<Music> music = iMusicService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("music", music);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        return new ModelAndView("create", "music", new MusicDto());
    }

    @PostMapping("/create")
    public String saveMusic(@ModelAttribute("music") @Validated MusicDto musicDto, BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            iMusicService.save(music);
            model.addAttribute("message", "Congritation!!!!!!!!!OK ");
            return "create";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdate(@PathVariable int id) {
        Optional<Music> music = iMusicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music.get(), musicDto);
        return new ModelAndView("update", "musicDto", musicDto);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        model.addAttribute("message", " Congritation!!!!!!!!!OK");
        return "update";
    }
}
