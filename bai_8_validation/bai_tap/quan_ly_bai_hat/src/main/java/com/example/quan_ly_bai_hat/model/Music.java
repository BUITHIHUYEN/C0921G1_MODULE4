package com.example.quan_ly_bai_hat.model;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không được để trống")
    @Size (max = 800,message = "không được vượt quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "không được chứa kí tự đặc biệt")
    private String nameMusic;
    @NotBlank(message = "Không được để trống")
    @Size (max = 300,message = "không được vượt quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "không được chứa kí tự đặc biệt")
    private String singer;
    @NotBlank(message = "Không được để trống")
    @Size (max = 1000,message = "không được vượt quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9,]*$",message = "không được chứa kí tự đặc biệt ngoại trừ dấu ,")
    private String typeMusic;

    public Music() {
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
