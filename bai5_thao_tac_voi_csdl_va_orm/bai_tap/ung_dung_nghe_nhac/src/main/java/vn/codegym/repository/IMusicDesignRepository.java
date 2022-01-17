package vn.codegym.repository;

import vn.codegym.model.MusicDesign;

import java.util.List;

public interface IMusicDesignRepository {
    List<MusicDesign> findAll();
    MusicDesign findById(Long id);
    MusicDesign updateNew(MusicDesign musicDesign);
    void save(MusicDesign musicDesign);
    void remove (Long id);

}
