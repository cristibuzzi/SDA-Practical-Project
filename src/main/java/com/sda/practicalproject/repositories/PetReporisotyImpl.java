package com.sda.practicalproject.repositories;


import com.sda.practicalproject.model.Pet;
import com.sda.practicalproject.repositories.base.RepositoryImpl;

public class PetReporisotyImpl extends RepositoryImpl<Pet> implements PetRepository {
    public PetReporisotyImpl() {
        super(Pet.class);
    }
}
