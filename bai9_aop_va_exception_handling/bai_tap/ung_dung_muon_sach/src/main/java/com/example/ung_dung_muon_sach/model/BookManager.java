package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
public class BookManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int theRemainingAmount;
    @ManyToOne(targetEntity = Code.class)
    private Code code;
    public BookManager() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTheRemainingAmount() {
        return theRemainingAmount;
    }

    public void setTheRemainingAmount(int theRemainingAmount) {
        this.theRemainingAmount = theRemainingAmount;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
}
