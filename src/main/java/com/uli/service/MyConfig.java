package com.uli.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
/**
 * Configuration class for setting up Spring application context.
 * Scans the specified package and its sub-packages for Spring components.
 */

@Configuration
@ComponentScan(basePackages = "com.uli") // Scans the "com.ui" package for Spring components
public class MyConfig {

    /**
     * Bean for creating an EntityManagerFactory.
     * This is used to manage database connections and persistence contexts.
     *
     * @return EntityManagerFactory instance
     */
    @Bean
    public EntityManagerFactory getEMF() {
        return Persistence.createEntityManagerFactory("vikas"); // Replace "vikas" with your persistence unit name
    }

    /**
     * Bean for creating an EntityManager.
     * The EntityManager is used to interact with the persistence context.
     *
     * @return EntityManager instance
     */
    @Bean
    public EntityManager getEM() {
        return getEMF().createEntityManager();
    }

    /**
     * Bean for creating an EntityTransaction.
     * This is used to manage transactions in the persistence context.
     *
     * @return EntityTransaction instance
     */
    @Bean
    public EntityTransaction getET() {
        return getEM().getTransaction();
    }
    @Bean(value ="scan")
    public Scanner getScanner() {
        return new Scanner(System.in); // Create a Scanner object for user input
    }
}

