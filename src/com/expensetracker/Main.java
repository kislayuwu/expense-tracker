package com.expensetracker;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.expensetracker.model.Transaction;
import com.expensetracker.service.SummaryService;
import com.expensetracker.service.TransactionService;
import com.expensetracker.strategy.ExpenseStrategy;
import com.expensetracker.strategy.IncomeStrategy;
import com.expensetracker.strategy.TransactionStrategy;
import com.expensetracker.utils.FileUtil;

public class Main {
	public static void main(String[] args) {
		TransactionService transactionService = new TransactionService();
		SummaryService summaryService = new SummaryService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("\n=== Expense Tracker Menu ===");
				System.out.println("1. Add Income");
				System.out.println("2. Add Expense");
				System.out.println("3. Load from file");
				System.out.println("4. Save to file");
				System.out.println("5. Show Summary");
				System.out.println("6. Exit");

				System.out.print("Enter your choice: ");
				int choice = Integer.parseInt(scanner.nextLine().trim());

				TransactionStrategy strategy;

				switch (choice) {
				case 1 -> {
					strategy = new IncomeStrategy();
					transactionService.addTransaction(strategy.createTransaction(scanner));
				}
				case 2 -> {
					strategy = new ExpenseStrategy();
					transactionService.addTransaction(strategy.createTransaction(scanner));
				}
				case 3 -> {
					System.out.print("Enter filename: ");
					String file = scanner.nextLine().trim();
					List<Transaction> transactions = FileUtil.loadFromFile(file);
					transactions.forEach(transactionService::addTransaction);
					System.out.println("Loaded " + transactions.size() + " transactions.");
				}
				case 4 -> {
					System.out.print("Enter filename to save: ");
					String file = scanner.nextLine().trim();
					FileUtil.saveToFile(file, transactionService.getTransactions());
					System.out.println("Data saved successfully.");
				}
				case 5 -> {
				    System.out.print("Enter month (1-12): ");
				    int month = Integer.parseInt(scanner.nextLine());
				    System.out.print("Enter year (e.g., 2025): ");
				    int year = Integer.parseInt(scanner.nextLine());
				    summaryService.generateMonthlySummary(transactionService.getTransactions(), month, year);
				    break;
				}
				case 6 -> {
					System.out.println("Goodbye!");
					return;
				}
				default -> System.out.println("Invalid choice. Please choose from 1 to 6.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			} catch (IOException e) {
				System.out.println("File error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}
		}
	}
}
