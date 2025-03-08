package com.nikijv.javahibernatehometask2.controller;

import com.nikijv.javahibernatehometask2.model.Apartment;
import com.nikijv.javahibernatehometask2.model.Client;
import com.nikijv.javahibernatehometask2.model.Landlord;
import com.nikijv.javahibernatehometask2.model.Rent;
import com.nikijv.javahibernatehometask2.service.RentService;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/clients")
    public List<Client> getAllBooks() {
        return rentService.getAllClients();
    }

    @GetMapping("/rents")
    public List<Rent> getAllRent() {
        return rentService.getAllRents();
    }

    @GetMapping("/apartments")
    public List<Apartment> getAllApartments() {
        return rentService.getAllApartments();
    }

    @GetMapping("/landlords")
    public List<Landlord> getAllLandlords() {
        return rentService.getAllLandlords();
    }

    @PostMapping("/create/client")
    public String createClient(@RequestBody Client client) {
        rentService.save(client);
        return "Client saved!";
    }

    @DeleteMapping("delete/client/{id}")
    public String deleteClient(@PathVariable Long id) {
        rentService.deleteClient(id);
        return "Client deleted!";
    }
}
//http://localhost:8080/swagger-ui/index.html
