package com.expensetracker.model;

public enum IncomeCategory {
    SALARY, BUSINESS;

    public static boolean contains(String category) {
        for (IncomeCategory c : values()) {
            if (c.name().equalsIgnoreCase(category)) return true;
        }
        return false;
    }

    public static String showCategories() {
    	String categories = "";
        for (IncomeCategory c : values()) {
        	categories +=  c.name() + ", ";
        }
        return categories.substring(0,categories.length()-2);
    }
    
}
