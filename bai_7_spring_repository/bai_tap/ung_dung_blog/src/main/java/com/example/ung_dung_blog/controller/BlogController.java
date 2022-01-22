package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Qualifier("IBlogService")
    @Autowired
   private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String showList(  Optional<String> name,Optional<Integer> categoryId
            , Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("category", iCategoryService.findAll());
        if (!name.isPresent() || name.get().equals("")) {
            if (!categoryId.isPresent()) {
                model.addAttribute("blog", iBlogService.findAll(pageable));
            } else {
                model.addAttribute("categoryId", categoryId.get());
                model.addAttribute("blog", iBlogService.findByCategory(categoryId.get(), pageable));
            }
        } else {
            if (!categoryId.isPresent()) {
                model.addAttribute("name", name.get());
                model.addAttribute("blog", iBlogService.findByName(name.get(), pageable));
            } else {
                model.addAttribute("name", name.get());
                model.addAttribute("categoryId", categoryId.get());
                model.addAttribute("blog", iBlogService.findByNameAndCategoryId(name.get(), categoryId.get(), pageable));
            }
        }
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",iCategoryService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message","OK!!!!!!!");
        return "redirect:/list";
    }

    @GetMapping("{id}/update")
    public String showUpdate(Model model, @PathVariable Integer id){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("category",iCategoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String saveUpdate(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update Ok!!!!!");
        return "redirect:/blog";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete Ok!!!!!!!");
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
        redirectAttributes.addFlashAttribute("message", "create blog Ok!!!!");
        return "redirect:/blog";
    }

}
