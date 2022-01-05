package com.betterashthandust.foodwars.models;

import java.util.ArrayList;

public class CategoryModel {
    String title = "";
    ArrayList<FoodModel> foodItems = new ArrayList<>();

    public CategoryModel(String title, ArrayList<FoodModel> foodItems) {
        this.title = title;
        this.foodItems = foodItems;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<FoodModel> getFoodItems() {
        return foodItems;
    }
}
