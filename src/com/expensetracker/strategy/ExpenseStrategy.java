package com.expensetracker.strategy;

import java.time.LocalDate;
import java.util.Scanner;

import com.expensetracker.model.Expense;
import com.expensetracker.model.ExpenseCategory;
import com.expensetracker.model.IncomeCategory;
import com.expensetracker.model.Transaction;

public class ExpenseStrategy implements TransactionStrategy {

    @Override
    public Transaction createTransaction(Scanner scanner) {
        ExpenseCategory category = null;
        double amount = 0;

        while (true) {
            System.out.print("Enter category (" + ExpenseCategory.showCategories() + ")");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                category = ExpenseCategory.valueOf(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. Please enter a valid ExpenseCategory.");
            }
        }

        // Amount input
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

        return new Expense(amount, LocalDate.now(), category);
    }
}

