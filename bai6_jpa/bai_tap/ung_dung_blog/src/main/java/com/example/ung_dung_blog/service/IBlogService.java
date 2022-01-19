package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void delete(Integer id);

    Optional<Blog>findById(Integer id);
}
