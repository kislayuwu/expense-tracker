package com.expensetracker.service;

import java.util.ArrayList;
import java.util.List;
import com.expensetracker.model.Transaction;

public class TransactionService {
	
	private List<Transaction> transactions = new ArrayList<>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
	
}