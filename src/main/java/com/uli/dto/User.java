package com.uli.dto;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.List;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
/**
 * Entity class representing the User.
 * Includes annotations for ORM mapping and dependency injection.
 */
@Entity
@Getter
@Setter
@Component
@Table(name = "user1") // Maps to table 'user1' in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int uId;

    @Column(nullable = false, length = 100) // Name cannot be null, max length of 100
    private String name;

    @Column(unique = true, nullable = false) // Phone number must be unique
    private long phoneNumber;

    @Column(nullable = false, length = 100) // Password cannot be null, max length of 100
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // One user can have many attendances, relationship managed by 'user' field in Attendance
    private List<Attendance> attendances;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String name, long phoneNumber, String password, List<Attendance> attendances) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.attendances = attendances;
    }

    // ToString method for debugging purposes
    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", attendances=" + attendances +
                '}';
    }
}

