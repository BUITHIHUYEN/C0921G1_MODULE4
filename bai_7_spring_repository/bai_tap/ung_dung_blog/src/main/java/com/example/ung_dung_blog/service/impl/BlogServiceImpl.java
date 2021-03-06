package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.repository.IBlogRepository;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return iBlogRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Page<Blog> findByCategory(int categoryId, Pageable pageable) {
        return iBlogRepository.findByCategory_CategoryId(categoryId,pageable);
    }

    @Override
    public Page<Blog> findByNameAndCategory(String name, int categoryId, Pageable pageable) {
        return iBlogRepository.findByNameContainingAndCategory_CategoryId(name,categoryId,pageable);
    }

}
