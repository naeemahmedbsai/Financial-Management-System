package models;

public class Transaction {

    private int id;
    private int accountId;
    private int categoryId;
    protected double amount;
    protected String type;

    // getters and setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDetails() {
    return "Amount: " + amount + ", Type: " + type;
   }
}