package be_organic_shop.customer.model;


import be_organic_shop.user.model.AppUser;

import javax.persistence.*;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20)", unique = true)
    private String code;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(name = "birth_day", columnDefinition = "date")
    private String birthDay;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "phone_number",columnDefinition = "varchar(20)", unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "varchar(100)", unique = true)
    private String email;
    @Column(name = "flag_deleted")
    private Boolean flagDeleted = false;
    @OneToOne
    @JoinColumn(name = "app_user_id",referencedColumnName = "id")
    private AppUser appUser;


    public Customer() {
    }

    public Customer(Long id, String code, String name, String birthDay, String address, String phoneNumber, String email, Boolean flagDeleted, AppUser appUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.flagDeleted = flagDeleted;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
