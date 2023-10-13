package be_organic_shop.customer.model;


import be_organic_shop.user.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
//    @Value("${demoENV}")
//    private String demoEnv;
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
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private Users users;

}
