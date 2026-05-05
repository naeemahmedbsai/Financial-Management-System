package dao;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Transaction;

public class TransactionDAO {

    // ✅ Add Transaction
    public void addTransaction(Transaction t) {

        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO transactions (account_id, category_id, amount, TYPE, date) VALUES (?, ?, ?, ?, NOW())";

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, t.getAccountId());
            pst.setInt(2, t.getCategoryId());
            pst.setDouble(3, t.getAmount());
            pst.setString(4, t.getType());

            pst.executeUpdate();

            System.out.println("Transaction added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Get All Transactions
    public List<Transaction> getAllTransactions() {

        List<Transaction> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM transactions";

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Transaction t = new Transaction();

                t.setId(rs.getInt("transaction_id"));
                t.setAccountId(rs.getInt("account_id"));
                t.setCategoryId(rs.getInt("category_id"));
                t.setAmount(rs.getDouble("amount"));
                t.setType(rs.getString("TYPE")); // keep your format

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}