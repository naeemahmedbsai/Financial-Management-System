package service;

import dao.AccountDAO;

public class AccountService {

    private AccountDAO dao = new AccountDAO();

    public void deposit(int id, double amount) {
        dao.deposit(id, amount);
    }

    public void withdraw(int id, double amount) {
        dao.withdraw(id, amount);
    }

    public double getBalance(int id) {
        return dao.getBalance(id);
    }
}