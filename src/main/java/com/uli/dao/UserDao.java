package com.uli.dao;


import com.uli.dto.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Data Access Object (DAO) class for managing User entities.
 */

/**
 * Data Access Object (DAO) class for managing User entities.
 */
@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityTransaction entityTransaction;

    /**
     * Saves a new User record in the database.
     *
     * @param user the User entity to be saved
     */
    public void saveUser(User user) {
        try {
            entityTransaction.begin();
            entityManager.persist(user); // Persist the User entity
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing User record in the database.
     *
     * @param user the User entity with updated details
     */
    public void updateUser(User user) {
        try {
            entityTransaction.begin();
            entityManager.merge(user); // Merge changes into the persistence context
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Finds a User by their phone number and password.
     *
     * @param phoneNumber the phone number of the User
     * @param password    the password of the User
     * @return the User entity if found, otherwise null
     */
    public User findUserByPhoneNumberAndPassword(long phoneNumber, String password) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber AND u.password = :password", User.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes a User record from the database.
     *
     * @param user the User entity to be deleted
     */
    public void delete(User user) {
        try {
            entityTransaction.begin();
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }
}


    /**
     * Placeholder methods for CRUD operations:
     * - saveUser(User user): Save a new user in the database.
     * - updateUser(User user): Update an existing user's details.
     * - findUserByPhoneNumberAndPassword(long phoneNumber, String password): Find a user by phone number and password.
     */


