package com.sda.practicalproject.controler;

import com.sda.practicalproject.model.Consult;
import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;
import com.sda.practicalproject.service.ConsultService;
import com.sda.practicalproject.service.exception.EntityNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class ConsultController {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final ConsultService consultService;
    private final Scanner scanner;

    public ConsultController(ConsultService consultService, Scanner scanner) {
        this.consultService = consultService;
        this.scanner = scanner;
    }

    public void createConsult() {
        try {

            System.out.println("Please insert Vet's id");
            long vetId = Long.parseLong(scanner.nextLine().trim());
            System.out.println("Please insert Pet's id");
            long petId = Long.parseLong(scanner.nextLine().trim());
            System.out.println("Please insert description");
            String description = scanner.nextLine();
            System.out.println("Please insert date of consult (YYYY-MM-DD HH:MM)");
            Date dateOfConsult = Date.from(LocalDateTime.parse(scanner.nextLine(),
                    DATE_TIME_FORMATTER).toInstant(ZoneOffset.of("+2")));
            consultService.createConsult(vetId, petId, dateOfConsult, description);
            System.out.println("Consult was created");
        } catch (NumberFormatException e) {
            System.err.println("Please insert a number");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Please insert a valid date");
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.out.println("Please retry");
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
            e.printStackTrace();
        }
    }

    public void viewAllConsults() {
        consultService.getAllConsults().stream()
                .forEach(consult ->
                        System.out.println(consult.getId() + " " +
                                consult.getVet().getFirstName() + " " +
                                consult.getVet().getLastName() + " " +
                                consult.getPet().getOwnerName() + " " +
                                consult.getAppoimentDate()));
    }

    public void viewConsultById() {
        try {
            System.out.println("Please insert consult id");
            long id = Long.parseLong(scanner.nextLine().trim());
            Optional<Consult> optionalConsult = consultService.getConsultById(id);
            if (optionalConsult.isPresent()) {
                System.out.println(optionalConsult.get() + " " + optionalConsult.get().getPet() + " " + optionalConsult.get().getVet());
            } else {
                System.err.println("Consult id not found");
            }
        } catch (NumberFormatException e) {
            System.err.println("Please insert a number");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
            e.printStackTrace();
        }
    }

    public void updateConsultById() {
        try {

            System.out.println("Please insert consult id");
            long id = Long.parseLong(scanner.nextLine().trim());
            System.out.println("Please insert description");
            String description = scanner.nextLine();
            consultService.updateConsultById(id, description);
            System.out.println("Consult updated");

        } catch (NumberFormatException e) {
            System.err.println("Please insert a number");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.out.println("Please retry");
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
            e.printStackTrace();
        }
    }
}