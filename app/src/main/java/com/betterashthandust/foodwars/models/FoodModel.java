package com.betterashthandust.foodwars.models;

public class FoodModel {
    String name, imageSrc, ingredients, recipe, macros;

    public FoodModel(String name, String imageSrc, String ingredients, String recipe, String macros) {
        this.name = name;
        this.imageSrc = imageSrc;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.macros = macros;
    }

    public String getName() {
        return name;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getMacros() {
        return macros;
    }
}
