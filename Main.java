import java.util.Scanner;
import java.util.List;
import service.AccountService;
import service.TransactionService;
import models.Income;
import models.Expense;

import dao.AccountDAO;
import dao.TransactionDAO;
import models.Transaction;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AccountService service = new AccountService();
        TransactionService transactionService = new TransactionService();

       System.out.print("Enter Account ID: ");
       int accountId = sc.nextInt();

        while (true) {

			System.out.println("\n==== Financial Management System ====");
			System.out.println("1. Add Income");
			System.out.println("2. Add Expense");
			System.out.println("3. View Transactions");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice;

                try {
                choice = sc.nextInt();
                } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.next(); // clear buffer
                continue;
                }

            switch (choice) {

                case 1:
                    System.out.print("Enter income amount: ");
                    double amount;
                    try {
                    amount = sc.nextDouble();
                   } catch (Exception e) {
                   System.out.println("Invalid input!");
                   sc.next();
                    continue;
                    }

                    Income income = new Income(amount);
                    service.deposit(accountId, income.getAmount());

                    System.out.println(income.getDetails());
                    break;

                case 2:
                    System.out.print("Enter expense amount: ");
                    try {
                    amount = sc.nextDouble();
                    } catch (Exception e) {
                    System.out.println("Invalid input!");
                    sc.next();
                    continue;
                        }
                    Expense expense = new Expense(amount);
                    service.withdraw(accountId, expense.getAmount());
                    System.out.println(expense.getDetails());
                    break;

                case 3:
                    List<Transaction> list = transactionService.getAllTransactions();

                    System.out.println("\n--- Transactions ---");

                    for (Transaction t : list) {
                        System.out.println(
                            t.getId() + " | " +
                            t.getAccountId() + " | " +
                            t.getDetails()
                        );
                    }
                    break;

                case 4:
    			double balance = service.getBalance(accountId);
    			System.out.println("Current Balance: " + balance);
    			break;

				case 5:
    			System.out.println("Exiting...");
    				System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}