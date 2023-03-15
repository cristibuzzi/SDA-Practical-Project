package com.sda.practicalproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Consult")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "appoiment_date")
    private Date appoimentDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name="vet_id")
    private Vet vet;
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;
    public Consult() {
    }

    public Consult(Date appoimentDate, String description) {
        this.appoimentDate = appoimentDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppoimentDate() {
        return appoimentDate;
    }

    public void setAppoimentDate(Date appoimentDate) {
        this.appoimentDate = appoimentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "id=" + id +
                ", appoimentDate=" + appoimentDate +
                ", description='" + description + '\'' +
                '}';
    }
}
