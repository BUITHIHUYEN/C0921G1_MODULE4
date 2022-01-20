package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
   private IBlogService iBlogService;

    @GetMapping("/blog")
    public ModelAndView showList(RedirectAttributes redirectAttributes) {
        List<Blog> blogs = iBlogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs", blogs);
        redirectAttributes.addFlashAttribute("msg", "");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/musicDesign/create");
//        modelAndView.addAllObjects("musicDesignList",new MusicDesign());
//        return modelAndView;
        return new ModelAndView("create", "blogs", new Blog());
    }

    @GetMapping("{id}/read")
    public ModelAndView read(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView = new ModelAndView("read");
        Blog blog = iBlogService.findById(id).get();
        modelAndView.addObject("readBlog", blog);
        return modelAndView;
    }

    @GetMapping("{id}/update")
    public ModelAndView update(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView = new ModelAndView("update");
        Blog blog = iBlogService.findById(id).get();
        modelAndView.addObject("updateBlog", blog);
        return modelAndView;
    }

    @PostMapping("/update")
    public String saveUpdate(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "update success");
        return "redirect:/blog";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "delete success");
        return "redirect:/blog";
    }

    @GetMapping("createnewblog")
    public ModelAndView create (ModelAndView modelAndView){
        modelAndView =new ModelAndView("create");
        modelAndView.addObject("newBlog",new Blog());
        return modelAndView;
    }

    @PostMapping("/savenewblog")
    public String createBlog(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "create blog success");
        return "redirect:/blog";
    }
}
