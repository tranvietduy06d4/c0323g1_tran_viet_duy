package model;

import java.util.Objects;

public class Person {
    private String id;
    private String name;
    private String birthDay;
    private boolean gender;

    public Person() {
    }

    public Person(String id, String name, String birthDay, boolean gender) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
