package com.example.quan_ly_bai_hat.service.impl;

import com.example.quan_ly_bai_hat.model.Music;
import com.example.quan_ly_bai_hat.repository.IMusicRepository;
import com.example.quan_ly_bai_hat.service.IMusicService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        iMusicRepository.save(user);

    }

    @Override
    public void update(User user) {
        iMusicRepository.save(user);

    }
}
