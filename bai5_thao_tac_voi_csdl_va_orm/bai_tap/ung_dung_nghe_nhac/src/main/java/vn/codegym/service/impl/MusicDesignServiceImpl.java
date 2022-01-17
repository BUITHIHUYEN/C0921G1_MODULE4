package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.MusicDesign;
import vn.codegym.repository.IMusicDesignRepository;
import vn.codegym.repository.impl.MusicDesignRepositoryImpl;
import vn.codegym.service.IMusicDesignService;

import java.util.List;
@Service
public class MusicDesignServiceImpl implements IMusicDesignService {
    @Autowired
    private IMusicDesignRepository iMusicDesignRepository;
    @Override
    public List<MusicDesign> findAll() {
        return iMusicDesignRepository.findAll();
    }

    @Override
    public MusicDesign findById(Long id) {
        return iMusicDesignRepository.findById(id);
    }

    @Override
    public MusicDesign updateNew(MusicDesign musicDesign) {
        return iMusicDesignRepository.updateNew(musicDesign);
    }

    @Override
    public void save(MusicDesign musicDesign) {
        iMusicDesignRepository.save(musicDesign);
    }

    @Override
    public void remove(Long id) {
        iMusicDesignRepository.remove(id);
    }
}
