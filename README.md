# Expense Tracker (Java Console Application)

A console-based Expense Tracker application built using Java following SOLID principles and Strategy Design Pattern. This project allows users to:

- Add income and expenses  
- Categorize transactions (e.g., Food, Rent, Travel, Salary, Business)  
- View monthly summaries  
- Save/load transactions from a file  
- Handle invalid inputs gracefully

---

## Features

- **Transaction Categories via Enums**  
  Easily categorize incomes and expenses using enums like `IncomeCategory` and `ExpenseCategory`.

- **SOLID Architecture**  
  Designed with modular services, validation, strategy pattern, and custom exception handling.

- **File Support**  
  Save transactions to and load from a `.txt` file for persistence.

---

## Technologies Used

- Java 17+
- Strategy Design Pattern
- Exception Handling
- Enum-based categorization
- File I/O

---

##  How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/kislayuwu/expense-tracker.git
cd expense-tracker

## Screenshots

### Add Income, Expense, Monthly Summary
![Add Icome, Expense, Monthly Summary](transactions.png)

### Save Transactions as File in data folder
![Save as file](Save_as_file.png)

### Load Transactions from File located in data folder
![Load tracker1.txt file](load_tracker1_file.png)
![tracker1.txt file](tracker1_txt_file.png)

