package com.clinic;

import com.clinic.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Health Clinic Application...");
        new ConsoleMenu().start();
        System.out.println("Application Exited. Goodbye!");
    }
}
