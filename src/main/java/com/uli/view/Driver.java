package com.uli.view;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.uli.dto.User;
import com.uli.dto.Attendance;
import com.uli.dao.UserDao;
import com.uli.dao.AttendanceDao;
import com.uli.service.MyConfig;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */


/**
 * Driver class to manage user operations such as Register, Login, Logout, Update, Delete, and Exit.
 * It interacts with the UserDao and AttendanceDao for database operations.
 */
public class Driver {
    public static void main(String[] args) {
        // Initialize Spring ApplicationContext using MyConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        // Retrieve beans from the Spring context
        Scanner scanner = (Scanner) context.getBean("scan");
        UserDao userDao = (UserDao) context.getBean("userDao");
        AttendanceDao attendanceDao = (AttendanceDao) context.getBean("attendanceDao");

        // Main menu loop
        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Register a new user
                    System.out.println("=== Register ===");
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your phone number: ");
                    long phoneNumber = scanner.nextLong();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();

                    // Create and save a new User entity
                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setPhoneNumber(phoneNumber);
                    newUser.setPassword(password);
                    userDao.saveUser(newUser);
                    System.out.println("Registration successful.");
                    break;

                case 2:
                    // Login a user
                    System.out.println("=== Login ===");
                    System.out.print("Enter your phone number: ");
                    phoneNumber = scanner.nextLong();
                    System.out.print("Enter your password: ");
                    password = scanner.next();

                    // Validate the user
                    User user = userDao.findUserByPhoneNumberAndPassword(phoneNumber, password);
                    if (user != null) {
                        System.out.println("Login successful!");

                        // Record login attendance
                        Attendance attendance = new Attendance();
                        attendance.setLoginTime(LocalDateTime.now());
                        attendance.setUser(user);
                        attendanceDao.saveAttendance(attendance);
                        System.out.println("Attendance recorded successfully.");
                    } else {
                        System.out.println("Invalid phone number or password. Please try again.");
                    }
                    break;

                case 3:
                    // Logout a user
                    System.out.println("=== Logout ===");
                    System.out.print("Enter your Attendance ID: ");
                    int attendanceId = scanner.nextInt();

                    // Fetch and update the attendance record
                    Attendance attendance = attendanceDao.findAllAttendanceByUserId(attendanceId).stream().findFirst().orElse(null);
                    if (attendance != null) {
                        attendance.setLogoutTime(LocalDateTime.now());
                        attendanceDao.updateAttendance(attendance);
                        System.out.println("Logout time recorded successfully.");
                    } else {
                        System.out.println("Invalid Attendance ID. Please try again.");
                    }
                    break;

                case 4:
                    // Update user details
                    System.out.println("=== Update ===");
                    System.out.print("Enter your phone number to identify your account: ");
                    phoneNumber = scanner.nextLong();

                    // Fetch the user
                    user = userDao.findUserByPhoneNumberAndPassword(phoneNumber, null);
                    if (user != null) {
                        System.out.println("1. Update Name");
                        System.out.println("2. Update Phone Number");
                        System.out.println("3. Update Password");
                        System.out.print("Enter your choice: ");
                        int updateChoice = scanner.nextInt();

                        switch (updateChoice) {
                            case 1:
                                // Update Name
                                System.out.print("Enter new name: ");
                                String newName = scanner.next();
                                user.setName(newName);
                                userDao.updateUser(user);
                                System.out.println("Name updated successfully.");
                                break;

                            case 2:
                                // Update Phone Number
                                System.out.print("Enter new phone number: ");
                                long newPhoneNumber = scanner.nextLong();
                                user.setPhoneNumber(newPhoneNumber);
                                userDao.updateUser(user);
                                System.out.println("Phone number updated successfully.");
                                break;

                            case 3:
                                // Update Password
                                System.out.print("Enter new password: ");
                                String newPassword = scanner.next();
                                user.setPassword(newPassword);
                                userDao.updateUser(user);
                                System.out.println("Password updated successfully.");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("User not found. Please check the phone number and try again.");
                    }
                    break;

                case 5:
                    // Delete a user
                    System.out.println("=== Delete ===");
                    System.out.print("Enter your phone number to delete your account: ");
                    phoneNumber = scanner.nextLong();

                    // Fetch the user and delete
                    user = userDao.findUserByPhoneNumberAndPassword(phoneNumber, null);
                    if (user != null) {
                        userDao.delete(user);
                        System.out.println("Account deleted successfully.");
                    } else {
                        System.out.println("User not found. Please check the phone number and try again.");
                    }
                    break;

                case 6:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}




