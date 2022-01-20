package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void delete(Integer id);

    Optional<Blog>findById(Integer id);

    Page<Blog> findByName(String name, Pageable pageable);

    Page<Blog> findByCategory(int categoryId, Pageable pageable);

    Page<Blog> findByNameAndCategoryId(String name, int categoryId, Pageable pageable);
}
