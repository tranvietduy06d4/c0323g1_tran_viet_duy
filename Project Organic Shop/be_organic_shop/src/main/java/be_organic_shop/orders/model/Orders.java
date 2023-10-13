package be_organic_shop.orders.model;

import be_organic_shop.user.model.Users;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "flag_deleted")
    private Boolean flagDeleted;

    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users users;

    public Orders() {
    }

    public Orders(Long id, String code, LocalDateTime dateTime, Boolean flagDeleted, String note, Users users) {
        this.id = id;
        this.code = code;
        this.dateTime = dateTime;
        this.flagDeleted = flagDeleted;
        this.note = note;
        this.users = users;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Users getAppUser() {
        return users;
    }

    public void setAppUser(Users users) {
        this.users = users;
    }
}
