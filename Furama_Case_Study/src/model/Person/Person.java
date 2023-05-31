package model.Person;

public class Person {
    private String personCode;
    private String personName;
    private int age;
    private int personId;
    private int phoneNumber;

    public Person() {
    }

    public Person(String personCode, String personName, int age, int personId, int phoneNumber) {
        this.personCode = personCode;
        this.personName = personName;
        this.age = age;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "codePerson='" + personCode + '\'' +
                ", namePerson='" + personName + '\'' +
                ", age=" + age +
                ", idPerson=" + personId +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
