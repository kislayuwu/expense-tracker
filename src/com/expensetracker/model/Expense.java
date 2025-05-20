package com.expensetracker.model;

import java.time.LocalDate;

public class Expense implements Transaction {
    private double amount;
    private LocalDate date;
    private ExpenseCategory category;

    public Expense(double amount, LocalDate date, ExpenseCategory category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category.name(); }
    public TransactionType  getType() { return TransactionType.EXPENSE; }
}
