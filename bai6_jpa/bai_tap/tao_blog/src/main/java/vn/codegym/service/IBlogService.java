package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Optional<Blog> findById(int id);
    void save(Blog blog);
    void remove (int id);
}
