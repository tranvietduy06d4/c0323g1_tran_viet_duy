package model.Person;

import java.util.Objects;

public class Person {
    private String personCode;
    private String personName;
    private String birthDay;
    private boolean gender;
    private String personId;
    private String phoneNumber;
    private String email;



    public Person() {
    }

    public Person(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email) {
        this.personCode = personCode;
        this.personName = personName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return personCode.equals(person.personCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personCode);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personCode='" + personCode + '\'' +
                ", personName='" + personName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender=" + gender +
                ", personId=" + personId +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
