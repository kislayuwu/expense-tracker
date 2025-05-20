package com.expensetracker.model;

import java.time.LocalDate;

public class Income implements Transaction {
    private double amount;
    private LocalDate date;
    private IncomeCategory category;

    public Income(double amount, LocalDate date, IncomeCategory category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category.name(); }
    public TransactionType  getType() { return TransactionType.INCOME; }
}

