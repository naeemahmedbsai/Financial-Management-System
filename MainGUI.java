import javax.swing.*;
import service.AccountService;
import models.Income;
import models.Expense;
import service.TransactionService;

public class MainGUI {
    
    public static void main(String[] args) {
        final AccountService service = new AccountService();

        JFrame frame = new JFrame("Financial Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.setVisible(true);
        JButton incomeBtn = new JButton("Add Income");
       
       incomeBtn.setBounds(100, 30, 200, 30);

        JButton expenseBtn = new JButton("Add Expense");
        expenseBtn.setBounds(100, 70, 200, 30);

        JButton viewBtn = new JButton("View Transactions");
        viewBtn.setBounds(100, 110, 200, 30);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(100, 150, 200, 30);

        frame.add(incomeBtn);
        frame.add(expenseBtn);
        frame.add(viewBtn);
        frame.add(balanceBtn);
        
          incomeBtn.addActionListener(e -> {
    String input = JOptionPane.showInputDialog("Enter Income Amount:");

    try {
        double amount = Double.parseDouble(input);

        Income income = new Income(amount);
        service.deposit(1, income.getAmount());

        JOptionPane.showMessageDialog(null, income.getDetails());

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Invalid input!");
    } 
    });
  

    expenseBtn.addActionListener(e -> {
    String input = JOptionPane.showInputDialog("Enter Expense Amount:");

    try {
        double amount = Double.parseDouble(input);

        Expense expense = new Expense(amount);
        service.withdraw(1, expense.getAmount());

        JOptionPane.showMessageDialog(null, expense.getDetails());

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Invalid input!");
    }
    });

      balanceBtn.addActionListener(e -> {
   
    double balance = service.getBalance(1);

    JOptionPane.showMessageDialog(null, "Balance: " + balance); 
   });


viewBtn.addActionListener(e -> {
    TransactionService transactionService = new TransactionService();

    StringBuilder data = new StringBuilder();

    for (models.Transaction t : transactionService.getAllTransactions()) {
        data.append(t.getDetails()).append("\n");
    }

    JOptionPane.showMessageDialog(null, data.toString());
});
    }

}