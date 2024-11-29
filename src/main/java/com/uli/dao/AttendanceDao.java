package com.uli.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.uli.dto.Attendance;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
/**
 * Data Access Object (DAO) class for managing Attendance entities.
 */
/**
 * Data Access Object (DAO) class for managing Attendance entities.
 */
@Repository
public class AttendanceDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityTransaction entityTransaction;

    /**
     * Saves a new Attendance record in the database.
     *
     * @param attendance the Attendance entity to be saved
     */
    public void saveAttendance(Attendance attendance) {
        try {
            entityTransaction.begin();
            entityManager.persist(attendance); // Persist the Attendance entity
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing Attendance record in the database.
     *
     * @param attendance the Attendance entity with updated details
     */
    public void updateAttendance(Attendance attendance) {
        try {
            entityTransaction.begin();
            entityManager.merge(attendance); // Merge changes into the persistence context
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Finds all Attendance records associated with a specific User ID.
     *
     * @param userId the ID of the User
     * @return a list of Attendance entities
     */
    public List<Attendance> findAllAttendanceByUserId(int userId) {
        try {
            return entityManager.createQuery(
                            "SELECT a FROM Attendance a WHERE a.user.uId = :userId", Attendance.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


    /**
     * Placeholder methods for Attendance entity operations:
     * - saveAttendance(Attendance attendance): Save a new attendance record.
     * - updateAttendance(Attendance attendance): Update an existing attendance record.
     * - findAllAttendanceByUserId(int id): Find attendance records by User ID.
     */


