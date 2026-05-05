package models;

public class Expense extends Transaction {
    public Expense(double amount) {
        this.amount = amount;
        this.type = "EXPENSE";
    }

    @Override
    public String getDetails() {
    return "Expense: -" + amount;
   }
}