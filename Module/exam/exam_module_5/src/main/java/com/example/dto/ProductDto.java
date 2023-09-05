package com.example.dto;

import com.example.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;


public class ProductDto implements Validator {
    private String code;
    private String name;
    private Date importDate;
    private Integer quantity;

    private Category category;

    public ProductDto() {
    }

    public ProductDto(String code, String name, Date importDate, Integer quantity, Category category) {
        this.code = code;
        this.name = name;
        this.importDate = importDate;
        this.quantity = quantity;
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

