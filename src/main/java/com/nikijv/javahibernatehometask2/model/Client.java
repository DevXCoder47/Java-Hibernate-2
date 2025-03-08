package com.nikijv.javahibernatehometask2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_id", referencedColumnName = "id")
    private Rent rent;

    public Client(String firstName, String lastName, Rent rent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rent = rent;
    }
}
