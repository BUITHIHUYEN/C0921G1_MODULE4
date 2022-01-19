package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @GetMapping("/blog")
    public ModelAndView showList() {
        List<Blog> blogs = iBlogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/musicDesign/create");
//        modelAndView.addAllObjects("musicDesignList",new MusicDesign());
//        return modelAndView;
        return new ModelAndView("create", "blogs", new Blog());
    }

}
