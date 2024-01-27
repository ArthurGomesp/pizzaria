package com.Gomes.pizzaria.domain;

import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private StatusAccount status = StatusAccount.ACTIVE;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public User(Long id,String name, String email, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusAccount getActiveAccount() {
        return status;
    }

    public void setActiveAccount(StatusAccount activeAccount) {
        this.status = activeAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StatusAccount getStatus() {
        return status;
    }

    public void setStatus(StatusAccount status) {
        this.status = status;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
