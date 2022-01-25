package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int theRemainingAmount;

    @OneToMany(mappedBy = "bookManagers")
    private List<Code> codes;

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

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }
}
