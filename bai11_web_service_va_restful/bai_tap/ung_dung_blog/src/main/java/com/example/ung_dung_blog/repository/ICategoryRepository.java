package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
