package dao;

import entities.bank.BankClient;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class BankDAO {
    private EntityManager entityManager;

    public BankDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<BankClient> retrieveClientList() {
        entityManager.getTransaction().begin();

        String jpql = "select c from BankClient c";
        TypedQuery<BankClient> query = entityManager.createQuery(jpql, BankClient.class);
        List<BankClient> bankClientList = query.getResultList();
        entityManager.getTransaction().commit();
        return bankClientList;
    }
}
