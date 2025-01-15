package com.tekarch.UserManagementService.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean twoFactorEnabled = false;

    @Column(length = 20, nullable = false)
    private String kycStatus = "pending";

    private LocalDateTime createdAt = LocalDateTime.now();

}
