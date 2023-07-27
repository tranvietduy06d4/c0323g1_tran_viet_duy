package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class SongDto implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Not Empty")
    private String name;
    @NotBlank(message = "Not Empty")
    private String singer;
    @NotBlank(message = "Not Empty")
    private String category;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().length() >800) {
            errors.rejectValue("name","null","Song name must equal or less than 800 characters");
        } else if (!songDto.getName().matches("^[a-zA-Z0-9\\s]*$")) {
            errors.rejectValue("name","null","Song name does not contain special characters like @ ; , . = - + , ...");
        }

        if (songDto.getSinger().length() >300) {
            errors.rejectValue("singer","null","Singer name must equal or less than 300 characters");
        } else if (!songDto.getSinger().matches("^[a-zA-Z0-9\\s]*$")) {
            errors.rejectValue("singer","null","Singer name does not contain special characters like @ ; , . = - + , ...");
        }
        if (songDto.getCategory().length() >1000) {
            errors.rejectValue("category","null","Category name must equal or less than 1000 characters");
        } else if (!songDto.getCategory().matches("^[a-zA-Z0-9,\\s]*$")) {
            errors.rejectValue("category","null","Category name does not contain special characters like @ ; . = - + , ...");
        }

    }

    public SongDto() {
    }

    public SongDto(String name, String singer, String category) {
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
