package com.example.quan_ly_bai_hat.service;

import com.example.quan_ly_bai_hat.model.Music;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface IMusicService {
    List<Music> findAll();

    Optional<Music> findById(int id);

    void save(Music music);

    void update(Music music);


}
