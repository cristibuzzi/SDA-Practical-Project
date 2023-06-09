package com.sda.practicalproject.service;

import com.sda.practicalproject.model.Pet;
import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;
import com.sda.practicalproject.service.exception.EntityNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PetService {
    void addPet(
            String race,
            Date dateOfBirth,
            boolean isVaccinated,
            String ownerName
    ) throws EntityUpdateFailedException;

    List<Pet> getAllPets();

    Optional<Pet> getPetById(long id);

    void deletePetById(long id) throws EntityUpdateFailedException, EntityNotFoundException;

    void updatePet(long id, boolean isVaccinated, String ownerName) throws EntityUpdateFailedException, EntityNotFoundException;
}
