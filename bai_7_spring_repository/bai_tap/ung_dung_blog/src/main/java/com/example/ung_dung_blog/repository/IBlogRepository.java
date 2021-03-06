package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    Blog:tên class ,Integer kiểu dữ liệu của khóa cính
    Page<Blog>findByNameContaining(String name, Pageable pageable);

    Page<Blog> findByCategory_CategoryId(Integer categoryId, Pageable pageable);

    Page<Blog> findByNameContainingAndCategory_CategoryId(String name, int categoryId, Pageable pageable);

}
