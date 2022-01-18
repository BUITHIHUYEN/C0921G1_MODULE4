package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.MusicDesign;
import vn.codegym.service.IMusicDesignService;

import java.util.List;

@Controller
public class MusicDesignController {
    @Autowired
    IMusicDesignService iMusicDesignService;
    @GetMapping("/music")
    public ModelAndView showList() {
        List<MusicDesign> musicDesignList = iMusicDesignService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("musicDesignList", musicDesignList);
        return modelAndView;
    }
    @GetMapping("/create-musicDesign")
    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/musicDesign/create");
//        modelAndView.addAllObjects("musicDesignList",new MusicDesign());
//        return modelAndView;
        return new ModelAndView("create", "musicDesign", new MusicDesign());
    }

    @PostMapping("/create-musicDesign")
    public ModelAndView saveMusicDesign(@ModelAttribute("musicDesignList") MusicDesign musicDesign) {
        iMusicDesignService.save(musicDesign);
//        return "redirect:/a";
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("musicDesignList",musicDesign);
        modelAndView.addObject("mess", "New song created sucessfully");
        return modelAndView;

    }


    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("info");
        MusicDesign musicDesign = iMusicDesignService.findById(id);
        modelAndView.addObject("musicDesignList", musicDesign);
        return modelAndView;
    }



    @PostMapping
    public String updateMusicDesign(MusicDesign musicDesign) {
        iMusicDesignService.save(musicDesign);
        return "redirect:/music";
    }




    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        iMusicDesignService.remove(id);
        return "redirect:/musicDesignList";
    }


}
