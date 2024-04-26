package com.Gomes.pizzaria.domain;

import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    public StatusAccount getActiveAccount() {
        return status;
    }

    public void setActiveAccount(StatusAccount activeAccount) {
        this.status = activeAccount;
    }

}
