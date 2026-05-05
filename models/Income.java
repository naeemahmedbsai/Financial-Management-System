package models;

public class Income extends Transaction {
    public Income(double amount) {
        this.amount = amount;
        this.type = "INCOME";
    }
    @Override
    public String getDetails() {
    return "Income: +" + amount;
   }
}