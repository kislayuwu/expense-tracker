package com.expensetracker.strategy;

import java.util.Scanner;
import com.expensetracker.model.Transaction;

public interface TransactionStrategy {
    Transaction createTransaction(Scanner scanner);
}