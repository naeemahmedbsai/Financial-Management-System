package dao;

import util.DBConnection;
import java.sql.*;
import models.Transaction;
import dao.TransactionDAO;

public class AccountDAO implements AccountOperations {

    public int createAccount(int userId, String accountName, double balance) {

        int accountId = 0;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO accounts (user_id, account_name, balance) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, userId);
            pst.setString(2, accountName);
            pst.setDouble(3, balance);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
                accountId = rs.getInt(1);
            }

            System.out.println("Account created with ID: " + accountId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accountId;
    }

    public double getBalance(int accountId) {

        double balance = 0;

        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT balance FROM accounts WHERE account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("balance");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

 public void deposit(int accountId, double amount) {

    if (amount <= 0) {
        System.out.println("Invalid deposit amount!");
        return;
    }

    try {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        PreparedStatement pst = conn.prepareStatement(query);

        pst.setDouble(1, amount);
        pst.setInt(2, accountId);

        pst.executeUpdate();

        System.out.println("Deposit successful!");

     
        Transaction t = new Transaction();
        t.setAccountId(accountId);
        t.setCategoryId(1);   // Salary → Income
        t.setAmount(amount);
        t.setType("Income");

        TransactionDAO tdao = new TransactionDAO();
        tdao.addTransaction(t);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void withdraw(int accountId, double amount) {

    if (amount <= 0) {
        System.out.println("Invalid amount!");
        return;
    }

    double currentBalance = getBalance(accountId);

    if (amount > currentBalance) {
        System.out.println("Insufficient balance!");
        return;
    }

    try {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

        PreparedStatement pst = conn.prepareStatement(query);

        pst.setDouble(1, amount);
        pst.setInt(2, accountId);

        pst.executeUpdate();

        System.out.println("Withdrawal successful!");

       
        Transaction t = new Transaction();
        t.setAccountId(accountId);
        t.setCategoryId(2);   // Expense category
        t.setAmount(amount);
        t.setType("Expense");

        TransactionDAO tdao = new TransactionDAO();
        tdao.addTransaction(t);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void getAccountDetails(int accountId) {

        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM accounts WHERE account_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, accountId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("account_id"));
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Name: " + rs.getString("account_name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}