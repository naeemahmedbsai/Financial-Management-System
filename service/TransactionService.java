package service;

import dao.TransactionDAO;
import java.util.List;
import models.Transaction;

public class TransactionService {

    private TransactionDAO dao = new TransactionDAO();

    public List<Transaction> getAllTransactions() {
        return dao.getAllTransactions();
    }
}