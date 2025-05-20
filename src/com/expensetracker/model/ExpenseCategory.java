package com.expensetracker.model;

public enum ExpenseCategory {
    FOOD, RENT, TRAVEL;

    public static boolean contains(String category) {
        for (ExpenseCategory c : values()) {
            if (c.name().equalsIgnoreCase(category)) return true;
        }
        return false;
    }

    public static String showCategories() {
    	String categories = "";
        for (ExpenseCategory c : values()) {
        	categories +=  c.name() + ", ";
        }
        return categories.substring(0,categories.length()-2);
    }
    
}
