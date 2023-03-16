package com.sda.practicalproject.repositories;

import com.sda.practicalproject.model.Consult;
import com.sda.practicalproject.repositories.base.RepositoryImpl;

public class ConsultRepositoryImpl extends RepositoryImpl<Consult> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}