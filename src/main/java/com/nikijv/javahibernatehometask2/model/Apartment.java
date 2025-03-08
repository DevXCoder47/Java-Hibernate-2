package com.nikijv.javahibernatehometask2.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    public Apartment(String address, Landlord landlord) {
        this.address = address;
        this.landlord = landlord;
    }
}
