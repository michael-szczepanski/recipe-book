package com.betterashthandust.foodwars.models;

import java.util.ArrayList;

public class CategoryDataFactory {
    private static CategoryDataFactory INSTANCE = null;
    private CategoryDataFactory() {

    }

    public static CategoryDataFactory getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new CategoryDataFactory();
        }
        return INSTANCE;
    }

    private ArrayList<CategoryModel> getCategories(ArrayList<FoodModel> breakfast, ArrayList<FoodModel> lunches, ArrayList<FoodModel> snacks, ArrayList<FoodModel> dinners) {
        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("Breakfast", breakfast));
        categories.add(new CategoryModel("Lunch", lunches));
        categories.add(new CategoryModel("Snack", snacks));
        categories.add(new CategoryModel("Dinner", dinners));
        return categories;
    }
}
