package com.example.quan_ly_bai_hat.service.impl;

import com.example.quan_ly_bai_hat.model.Music;
import com.example.quan_ly_bai_hat.repository.IMusicRepository;
import com.example.quan_ly_bai_hat.service.IMusicService;
import net.bytebuddy.dynamic.DynamicType;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(int id) {
        return iMusicRepository.findById(id);
    }


    @Override
        public void save(Music music) {
        iMusicRepository.save(music);

    }

    @Override
    public void update(Music music) {
        iMusicRepository.save(music);

    }
}
