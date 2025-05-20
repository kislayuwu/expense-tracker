package com.expensetracker.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.model.Expense;
import com.expensetracker.model.ExpenseCategory;
import com.expensetracker.model.Income;
import com.expensetracker.model.IncomeCategory;
import com.expensetracker.model.Transaction;
import com.expensetracker.model.TransactionType;
public class FileUtil {

	public static void saveToFile(String filename, List<Transaction> transactions) throws IOException {
		String path = "data/" + filename;
	    File file = new File(path);
	    file.getParentFile().mkdirs(); // create directory if not exists

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	        for (Transaction t : transactions) {
	            writer.write(t.getType() + "," + t.getCategory() + "," + t.getAmount() + "," + t.getDate());
	            writer.newLine();
	        }
	        System.out.println("Saved to: " + file.getAbsolutePath());
	    }
	}

    public static List<Transaction> loadFromFile(String filename) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        String path = "data/" + filename;
        File file = new File(path);

        if (!file.exists()) {
            throw new IOException("File does not exist: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
                    double amount = Double.parseDouble(parts[2]);
                    LocalDate date = LocalDate.parse(parts[3]);

                    Transaction transaction;
                    if (type == TransactionType.INCOME) {
                        IncomeCategory incomeCategory = IncomeCategory.valueOf(parts[1].toUpperCase());
                        transaction = new Income(amount, date, incomeCategory);
                    } else {
                        ExpenseCategory expenseCategory = ExpenseCategory.valueOf(parts[1].toUpperCase());
                        transaction = new Expense(amount, date, expenseCategory);
                    }

                    transactions.add(transaction);
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line + " -> " + e.getMessage());
                }
            }
        }

        return transactions;
    }
}
