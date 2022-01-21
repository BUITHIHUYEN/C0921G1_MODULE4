package com.example.quan_ly_bai_hat.model;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nameMusic;

    private String singer;

    private String typeMusic;

    public Music() {
    }

    public Music(String nameMusic, String singer, String typeMusic) {
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }
}
