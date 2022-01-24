package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    @OneToMany(mappedBy = "code")
    private List<BookManager> bookManagers;
    public Code() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BookManager> getBookManagers() {
        return bookManagers;
    }

    public void setBookManagers(List<BookManager> bookManagers) {
        this.bookManagers = bookManagers;
    }
}
