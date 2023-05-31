package model.Person;

public class Customer extends Person{
    public Customer() {
    }

    public Customer(String personCode, String namePerson, int age, int idPerson, int phoneNumber) {
        super(personCode, namePerson, age, idPerson, phoneNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
