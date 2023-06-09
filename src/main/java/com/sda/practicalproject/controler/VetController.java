package com.sda.practicalproject.controler;

import com.sda.practicalproject.model.Vet;
import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;
import com.sda.practicalproject.service.VetService;
import com.sda.practicalproject.service.exception.EntityNotFoundException;

import java.security.Provider;
import java.util.Optional;
import java.util.Scanner;

public class VetController {
    private final Scanner scanner;
    private final VetService vetService;

    public VetController(VetService vetService, Scanner scanner) {
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
        for (Vet vet : vetService.getAllVets()) {
            System.out.println(vet.getId() + " " + vet.getFirstName() + " " + vet.getLastName());
        }
    }

    public void updateVet() {
        try {

            System.out.println("Please enter the vet's id");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Please insert the vet last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the vet address: ");
            String address = scanner.nextLine();
            System.out.println("Please insert the vet speciality: ");
            String speciality = scanner.nextLine();

            vetService.updateVet(id, lastName, address, speciality);
            System.out.println("Vet has been updated");
        } catch (NumberFormatException e) {
            System.err.println("Please insert a valid numeric id");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.out.println("Please retry");
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }

    public void findVetById() {
        try {
            System.out.println("Please enter the vet's id");
            long id = Long.parseLong(scanner.nextLine());
            Optional<Vet> optionalVet = vetService.findVetById(id);
            if (optionalVet.isPresent()) {
                System.out.println(optionalVet.get());
            } else {
                System.out.println("Vet was not found by id: " + id);
            }
        } catch (NumberFormatException e) {
            System.err.println("Please insert a valid numeric id");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }

    public void deleteVetById() {
        try {
            System.out.println("Please enter the vet's id");
            long id = Long.parseLong(scanner.nextLine());
            vetService.deleteVetById(id);
            System.out.println("Vet was deleted");
        } catch (NumberFormatException e) {
            System.err.println("Please insert a valid numeric id");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }
}
