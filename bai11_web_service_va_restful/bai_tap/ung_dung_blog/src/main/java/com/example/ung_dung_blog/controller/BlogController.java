package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;
//Xem danh sách các category
@GetMapping("/category")
public ResponseEntity<List<Category>> findAllCategory() {
    List<Category> categoryList = iCategoryService.findAll();
    if (categoryList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(categoryList, HttpStatus.OK);
}
//Xem danh sách các bài viết
@GetMapping("/blog")
public ResponseEntity<List<Blog>> findAllBlog() {
    List<Blog> blogList = iBlogService.findAll();
    if (blogList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(blogList, HttpStatus.OK);
}
//Xem danh sách các bài viết của một category
@GetMapping("/{id}")
public ResponseEntity<Blog> findById(@PathVariable Integer id) {
    Optional<Blog> blog = iBlogService.findById(id);
    if (blog == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(blog.get(), HttpStatus.OK);
}
//Xem chi tiết một bài viết
@GetMapping("/categoryId")
public ResponseEntity<List<Blog>> findByCategory(@RequestParam("categoryId") Integer categoryId) {
    List<Blog> blogList = iBlogService.findByCategory(categoryId);
    if (blogList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(blogList, HttpStatus.OK);
}

}
