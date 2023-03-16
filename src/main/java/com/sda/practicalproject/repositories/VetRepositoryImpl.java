package com.sda.practicalproject.repositories;

import com.sda.practicalproject.model.Vet;

import com.sda.practicalproject.repositories.base.RepositoryImpl;

public class VetRepositoryImpl extends RepositoryImpl<Vet> implements VetRepository {
    public VetRepositoryImpl() {
        super(Vet.class);
    }
}
