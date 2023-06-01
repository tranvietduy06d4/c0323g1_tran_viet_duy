package model.Person;

public class Customer extends Person {

    private String customerType;
    private String customerAddress;

    public Customer() {
    }

    public Customer(String personCode, String personName, String birthDay, boolean gender, String personId, String phoneNumber, String email, String customerType, String customerAddress) {
        super(personCode, personName, birthDay, gender, personId, phoneNumber, email);
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + this.getPersonCode() + '\'' +
                ", Name='" + this.getPersonName() + '\'' +
                ", birthDay='" + this.getBirthDay() + '\'' +
                ", gender=" + this.isGender() +
                ", customerId=" + this.getPersonId() +
                ", phoneNumber=" + this.getPhoneNumber() +
                ", email='" + this.getEmail() + '\'' +
                ", customerType='" + this.getCustomerType() + '\'' +
                ", customerAddress='" + this.getCustomerAddress() + '\'' +
                '}';
    }
}
