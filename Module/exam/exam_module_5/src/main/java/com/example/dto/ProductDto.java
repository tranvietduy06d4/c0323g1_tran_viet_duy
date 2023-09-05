package com.example.dto;

import com.example.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class BlogDto implements Validator {
    private String title;
    private String content;
    private Date postingDate;
    private String author;
    private boolean genderAuthor;

    private Category category;

    public BlogDto() {
    }

    public BlogDto(String title, String content, Date postingDate, String author, boolean genderAuthor, Category category) {
        this.title = title;
        this.content = content;
        this.postingDate = postingDate;
        this.author = author;
        this.genderAuthor = genderAuthor;
        this.category = category;
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

    public boolean isGenderAuthor() {
        return genderAuthor;
    }

    public void setGenderAuthor(boolean genderAuthor) {
        this.genderAuthor = genderAuthor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;

        if (blogDto.getTitle().equals("")) {
            errors.rejectValue("title",null,"Vui lòng điền tên blog");
        } else if(blogDto.getTitle().length()>255) {
            errors.rejectValue("title",null,"Tên blog không được vượt quá 255 kí tự");
        }
        
        if (blogDto.getContent().equals("")){
            errors.rejectValue("content",null,"Vui lòng điền nội dung blog");
        } else if (blogDto.getContent().length() >255) {
            errors.rejectValue("content",null,"Nội dung Blog không vượt quá 255 kí tự");
        }
        if (blogDto.getAuthor().equals("")) {
            errors.rejectValue("author",null,"Vui lòng điền tên tác giả");
        } else if (blogDto.getAuthor().matches("^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$")) {
            errors.rejectValue("author",null,"Tên sai định dạng. Định dạng tên đúng: Trần Văn Nhân");
        }

        if (blogDto.getPostingDate().equals("")) {
            errors.rejectValue("postingDate",null,"Vui lòng điền ngày đăng bài");
        } else {
            LocalDate presentDate = LocalDate.now();
            LocalDate datePosting = blogDto.getPostingDate().toLocalDate();
            Period distancePeriod = Period.between(presentDate,datePosting);
            int timeDistance = distancePeriod.getYears();
            if (timeDistance< 15| timeDistance>50) {
                errors.rejectValue("postingDate",null,"Năm phải lớn hơn 15 và nhỏ hơn 50");
            }
        }



    }
}
