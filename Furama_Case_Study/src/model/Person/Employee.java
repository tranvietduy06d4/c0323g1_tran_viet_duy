package model.Person;

public class Employee extends Person{
    private int salary;
    public Employee() {
    }

    public Employee(String codePerson, String namePerson, int age, int idPerson, int phoneNumber, int salary) {
        super(codePerson, namePerson, age, idPerson, phoneNumber);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "codePerson='" + this.getPersonCode() + '\'' +
                ", namePerson='" + this.getPersonName() + '\'' +
                ", age=" + this.getAge() +
                ", idPerson=" + this.getPersonId() +
                ", phoneNumber=" + this.getPhoneNumber() +
                ", salary=" + this.getSalary() +
                '}';
    }
}
