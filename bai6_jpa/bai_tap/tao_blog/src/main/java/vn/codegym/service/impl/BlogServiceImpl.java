package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog updateNew(Blog blog) {
        return iBlogRepository.updateNew(blog);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);

    }

    @Override
    public void remove(Long id) {
        iBlogRepository.remove(id);

    }
}
