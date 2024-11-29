package com.uli.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
/**
 * Entity class representing Attendance records.
 */

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Entity class representing Attendance records.
 */
@Entity
@Getter
@Setter
@Component
@Table(name = "attendance") // Maps to the "attendance" table in the database
@SequenceGenerator(name = "user_atten_gen", initialValue = 101, allocationSize = 1)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_atten_gen")
    private int aId; // Unique identifier for attendance

    @CreationTimestamp
    @Column(name = "login_time", nullable = false, updatable = false)
    private LocalDateTime loginTime; // Automatically populated login timestamp

    @Column(name = "logout_time")
    private LocalDateTime logoutTime; // Logout timestamp

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column in attendance table
    private User user; // Reference to the associated User entity

    // Default Constructor
    public Attendance() {
    }

    // Parameterized Constructor
    public Attendance(LocalDateTime loginTime, LocalDateTime logoutTime, User user) {
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.user = user;
    }

    // toString Method for Logging and Debugging
    @Override
    public String toString() {
        return "Attendance{" +
                "aId=" + aId +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", user=" + user +
                '}';
    }
}


