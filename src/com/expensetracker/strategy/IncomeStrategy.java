package com.expensetracker.strategy;

import java.time.LocalDate;
import java.util.Scanner;

import com.expensetracker.model.Income;
import com.expensetracker.model.IncomeCategory;
import com.expensetracker.model.Transaction;

public class IncomeStrategy implements TransactionStrategy {

    @Override
    public Transaction createTransaction(Scanner scanner) {
        IncomeCategory category = null;
        double amount = 0;

        while (true) {
            System.out.print("Enter category (" + IncomeCategory.showCategories() + ")");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                category = IncomeCategory.valueOf(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. Please enter a valid IncomeCategory.");
            }
        }

        while (true) {
            System.out.print("Enter amount: ");
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
            }
        }

        return new Income(amount, LocalDate.now(), category);
    }
}
