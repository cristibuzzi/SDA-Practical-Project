package com.sda.practicalproject.service;

import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;

import java.util.Date;

public interface PetService {
    void addPet(
            String race,
            Date dateOfBirth,
            boolean isVaccinated,
            String ownerName
    ) throws EntityUpdateFailedException;
}
