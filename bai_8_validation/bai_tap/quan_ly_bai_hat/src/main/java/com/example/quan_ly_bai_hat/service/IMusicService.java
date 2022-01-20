package com.example.quan_ly_bai_hat.service;

import com.example.quan_ly_bai_hat.model.Music;
import org.apache.catalina.User;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(int id);

    void save(User user);

    void update(User user);


}
