package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

//    Optional<Blog> findById(Integer id);
}
