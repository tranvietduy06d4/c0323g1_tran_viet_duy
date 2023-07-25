package com.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date postingDate;
    private String author;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private BlogType blogType;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date postingDate, String author, BlogType blogType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postingDate = postingDate;
        this.author = author;
        this.blogType = blogType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }
}
