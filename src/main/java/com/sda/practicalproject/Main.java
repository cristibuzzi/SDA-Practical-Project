package com.sda.practicalproject;

import com.sda.practicalproject.utils.SessionManager;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();

        SessionManager.shutdown();
    }
}