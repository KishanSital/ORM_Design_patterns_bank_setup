package dao;

import entities.bank.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BankDAO {
    private EntityManager entityManager;

    public BankDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Client> retrieveClientList() {
        entityManager.getTransaction().begin();

        String jpql = "select c from Client c";
        TypedQuery<Client> query = entityManager.createQuery(jpql, Client.class);
        List<Client> clientList = query.getResultList();
        entityManager.getTransaction().commit();
        return clientList;
    }
}
