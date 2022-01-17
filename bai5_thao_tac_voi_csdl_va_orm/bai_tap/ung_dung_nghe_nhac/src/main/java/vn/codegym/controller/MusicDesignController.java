package vn.codegym.controller;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.MusicDesign;
import vn.codegym.service.IMusicDesignService;

import java.util.List;

@Controller
@RequestMapping("/musicDesignList")
public class MusicDesignController {
    IMusicDesignService iMusicDesignService;
    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("musicDesignList/list");
        List<MusicDesign> musicDesignList = iMusicDesignService.findAll();
        modelAndView.addObject("musicDesignList", musicDesignList);
        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("musicDesignList/info");
        MusicDesign musicDesign = iMusicDesignService.findOne(id);
        modelAndView.addObject("musicDesign", musicDesign);
        return modelAndView;
    }

    @PostMapping
    public String updateMusicDesign(MusicDesign musicDesign) {
        iMusicDesignService.save(musicDesign);
        return "redirect:/musicDesignList";
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("musicDesignList/create", "musicDesignList", new MusicDesign());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute("musicDesignList") MusicDesign musicDesignList) {
        iMusicDesignService.save(musicDesignList);
        ModelAndView modelAndView = new ModelAndView("musicDesignList/create");
        modelAndView.addObject("musicDesignList", new MusicDesign());
        modelAndView.addObject("mess", "New song created sucessfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        iMusicDesignService.remove(id);
        return "redirect:/musicDesignList";
    }


}
