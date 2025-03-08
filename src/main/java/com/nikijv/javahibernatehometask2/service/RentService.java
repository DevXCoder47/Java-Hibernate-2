package com.nikijv.javahibernatehometask2.service;

import com.nikijv.javahibernatehometask2.model.Apartment;
import com.nikijv.javahibernatehometask2.model.Client;
import com.nikijv.javahibernatehometask2.model.Landlord;
import com.nikijv.javahibernatehometask2.model.Rent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    @PersistenceContext
    private EntityManager entityManager;

    public RentService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Client> getAllClients() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Client", Client.class).getResultList();
    }

    @Transactional
    public List<Rent> getAllRents() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Rent", Rent.class).getResultList();
    }

    @Transactional
    public List<Apartment> getAllApartments() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Apartment", Apartment.class).getResultList();
    }

    @Transactional
    public List<Landlord> getAllLandlords() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Landlord", Landlord.class).getResultList();
    }

    @Transactional
    public void save(Client client) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.remove(client);
        }
    }
}
