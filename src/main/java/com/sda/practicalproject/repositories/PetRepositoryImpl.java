package com.sda.practicalproject.repositories;


import com.sda.practicalproject.model.Pet;
import com.sda.practicalproject.repositories.base.RepositoryImpl;

public class PetRepositoryImpl extends RepositoryImpl<Pet> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
