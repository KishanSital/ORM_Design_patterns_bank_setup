package app;

import config.JPAConfiguration;
import dao.BankDAO;
import entities.bank.Client;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        JPAConfiguration t = new JPAConfiguration("DSB");
        BankDAO bankDAO = new BankDAO(t.getEntityManager());
        List<Client> clientList = bankDAO.retrieveClientList();
        clientList.forEach(System.out::println);
    }

}
