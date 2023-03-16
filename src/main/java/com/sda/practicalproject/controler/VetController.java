package com.sda.practicalproject.controler;

import com.sda.practicalproject.model.Vet;
import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;
import com.sda.practicalproject.service.VetService;

import java.security.Provider;
import java.util.Scanner;

public class VetController {
    private final Scanner scanner;
    private final VetService vetService;

    public VetController(VetService vetService,Scanner scanner) {
        this.scanner = scanner;
        this.vetService = vetService;
    }

    public void createVet() {
        try {

            System.out.println("Please insert the vet first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert the vet last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the vet address: ");
            String address = scanner.nextLine();
            System.out.println("Please insert the vet speciality: ");
            String speciality = scanner.nextLine();

            vetService.addVet(firstName, lastName, address, speciality);
            System.out.println("Vet's details successfully saved");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.out.println("Please retry");
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }

    public void displayAllVets() {
        for(Vet vet : vetService.getAllVets()) {
            System.out.println(vet.getId() + " " + vet.getFirstName() + " " + vet.getLastName());
        }
    }
}