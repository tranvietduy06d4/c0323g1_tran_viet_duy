package model.Person;

public class Employee extends Person{
    private String level;
    private String position;
    private float salary;
    public Employee() {
    }

    public Employee(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String level, String position, float salary) {
        super(personCode, personName, birthDay, gender, personId, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + this.getPersonCode() + '\'' +
                ", Name='" + this.getPersonName() + '\'' +
                ", birthDay='" + this.getBirthDay() + '\'' +
                ", gender=" + this.isGender() +
                ", employeeId=" + this.getPersonId() +
                ", phoneNumber=" + this.getPhoneNumber() +
                ", email='" + this.getEmail() + '\'' +
                ", level='" + this.getLevel() + '\'' +
                ", position='" + this.getPosition() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                '}';
    }
}
