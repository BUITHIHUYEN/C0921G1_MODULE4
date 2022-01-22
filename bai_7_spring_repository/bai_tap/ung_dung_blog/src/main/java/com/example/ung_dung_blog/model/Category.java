package com.example.ung_dung_blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;
//    bên này 1 để one,bên nhiều để many

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category() {
    }

    public Category( String name, List<Blog> blogs) {
        this.name = name;
        this.blogs = blogs;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
