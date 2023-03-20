package com.sda.practicalproject;

import com.sda.practicalproject.controler.PetController;
import com.sda.practicalproject.controler.VetController;
import com.sda.practicalproject.controler.menu.MenuItem;
import com.sda.practicalproject.repositories.PetRepositoryImpl;
import com.sda.practicalproject.repositories.VetRepositoryImpl;
import com.sda.practicalproject.service.PetServiceImpl;
import com.sda.practicalproject.service.VetServiceImpl;
import com.sda.practicalproject.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SessionManager.getSessionFactory();
        VetController vetController = new VetController(
                new VetServiceImpl(new VetRepositoryImpl()),
                scanner
        );

        PetController petController = new PetController(
                scanner,
                new PetServiceImpl(new PetRepositoryImpl())

        );

        for (int i = 1; i <= 100; i++) {
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        }

        MenuItem selectedOption = MenuItem.UNKNOWN;

        while (selectedOption != MenuItem.EXIT) {
            System.out.println();
            MenuItem.printMenuItems();
            System.out.println("Please select an option:");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                selectedOption = MenuItem.searchByOption(numericOption);
            } catch (NumberFormatException e) {
                System.out.println("Please use numeric value");
                selectedOption = MenuItem.UNKNOWN;
            }

            switch (selectedOption) {
                case ADD_VET:
                    vetController.createVet();
                    break;
                case UPDATE_VET:
                    vetController.updateVet();
                    break;
                case DELETE_VET:
                    vetController.deleteVetById();
                    break;
                case VIEW_VET_LIST:
                    vetController.displayAllVets();
                    break;
                case VIEW_VET_BY_ID:
                    vetController.findVetById();
                    break;
                case ADD_PET:
                    petController.createPet();
                    break;
                case VIEW_PET_LIST:
                    petController.viewAllPets();
                    break;
                case EXIT:
                    System.out.println("Good bye!");
                    break;
                case UNKNOWN:
                    System.out.println("Please insert a valid option");
                    break;
                default:
                    System.out.println("Option not implemented");
                    break;
            }
        }

        System.out.println();
        SessionManager.shutdown();
    }
}