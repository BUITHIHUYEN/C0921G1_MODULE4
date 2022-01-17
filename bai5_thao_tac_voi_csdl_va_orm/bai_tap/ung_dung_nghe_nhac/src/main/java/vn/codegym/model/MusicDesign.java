package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class MusicDesign implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTheSong;
    private String singer;

    public MusicDesign() {
    }

    public MusicDesign(Long id, String nameOfTheSong, String singer) {
        this.id = id;
        this.nameOfTheSong = nameOfTheSong;
        this.singer = singer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfTheSong() {
        return nameOfTheSong;
    }

    public void setNameOfTheSong(String nameOfTheSong) {
        this.nameOfTheSong = nameOfTheSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "MusicDesign{" +
                "id=" + id +
                ", nameOfTheSong='" + nameOfTheSong + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
