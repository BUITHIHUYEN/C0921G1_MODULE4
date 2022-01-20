package com.example.quan_ly_bai_hat.repository;

import com.example.quan_ly_bai_hat.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {
}
