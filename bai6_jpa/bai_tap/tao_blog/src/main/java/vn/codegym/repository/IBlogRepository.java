package vn.codegym.repository;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog updateNew(Blog blog);
    void save(Blog musicDesign);
    void remove (Long id);
}
