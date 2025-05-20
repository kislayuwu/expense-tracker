package com.expensetracker.service;

import java.util.List;

import com.expensetracker.model.Transaction;
import com.expensetracker.model.TransactionType;

public class SummaryService {

    public void generateMonthlySummary(List<Transaction> transactions, int month, int year) {
        System.out.println("Monthly Summary for " + month + "/" + year);
        
        double incomeTotal = 0;
        double expenseTotal = 0;

        for (Transaction t : transactions) {
            if (t.getDate().getMonthValue() == month && t.getDate().getYear() == year) {
                System.out.printf("%s: %s - %.2f\n", t.getType(), t.getCategory(), t.getAmount());

                if (t.getType() == TransactionType.INCOME) {
                    incomeTotal += t.getAmount();
                } else if (t.getType() == TransactionType.EXPENSE) {
                    expenseTotal += t.getAmount();
                }
            }
        }

        System.out.printf("Total Income: %.2f | Total Expenses: %.2f | Balance: %.2f\n",
                incomeTotal, expenseTotal, (incomeTotal - expenseTotal));
    }
}
