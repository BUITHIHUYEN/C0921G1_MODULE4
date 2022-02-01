package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    List<Blog> findByCategory(Integer categoryId);
}
