package com.betterashthandust.foodwars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.betterashthandust.foodwars.adapters.CategoryAdapter;
import com.betterashthandust.foodwars.models.CategoryModel;
import com.betterashthandust.foodwars.models.FoodModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FoodModel> breakfasts = new ArrayList<>();
        ArrayList<FoodModel> desserts = new ArrayList<>();
        ArrayList<FoodModel> snacks = new ArrayList<>();
        ArrayList<FoodModel> mains = new ArrayList<>();

        // Test Recipe
        // breakfasts.add(new FoodModel(getResources().getString(R.string.test_name), "test_image", getResources().getString(R.string.test_ingredients), getResources().getString(R.string.test_recipe), getResources().getString(R.string.test_macros)));
        // Cheesecake Swirl
        desserts.add(new FoodModel(getResources().getString(R.string.cheesecake_swirl_name), "cheesecake_swirl_image", getResources().getString(R.string.cheesecake_swirl_ingredients), getResources().getString(R.string.cheesecake_swirl_recipe), getResources().getString(R.string.cheesecake_swirl_macros)));
        // Burger Buns
        mains.add(new FoodModel(getResources().getString(R.string.burger_buns_name), "burger_buns_image", getResources().getString(R.string.burger_buns_ingredients), getResources().getString(R.string.burger_buns_recipe), getResources().getString(R.string.burger_buns_macros)));
        // Garlic Bread
        snacks.add(new FoodModel(getResources().getString(R.string.garlic_bread_name), "garlic_bread_image", getResources().getString(R.string.garlic_bread_ingredients), getResources().getString(R.string.garlic_bread_recipe), getResources().getString(R.string.garlic_bread_macros)));
        // Pizza Snails
        snacks.add(new FoodModel(getResources().getString(R.string.pizza_snails_name), "pizza_snails_image", getResources().getString(R.string.pizza_snails_ingredients), getResources().getString(R.string.pizza_snails_recipe), getResources().getString(R.string.pizza_snails_macros)));
        // Pizza
        mains.add(new FoodModel(getResources().getString(R.string.pizza_name), "pizza_image", getResources().getString(R.string.pizza_ingredients), getResources().getString(R.string.pizza_recipe), getResources().getString(R.string.pizza_macros)));
        // Lava Cake
        desserts.add(new FoodModel(getResources().getString(R.string.lava_cake_name), "lava_cake_image", getResources().getString(R.string.lava_cake_ingredients), getResources().getString(R.string.lava_cake_recipe), getResources().getString(R.string.lava_cake_macros)));
        // Babovka
        desserts.add(new FoodModel(getResources().getString(R.string.babovka_name), "babovka_image", getResources().getString(R.string.babovka_ingredients), getResources().getString(R.string.babovka_recipe), getResources().getString(R.string.babovka_macros)));
        // Seeds Bread
        breakfasts.add(new FoodModel(getResources().getString(R.string.seeds_bread_name), "seeds_bread_image", getResources().getString(R.string.seeds_bread_ingredients), getResources().getString(R.string.seeds_bread_recipe), getResources().getString(R.string.seeds_bread_macros)));

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("Breakfast", breakfasts));
        categories.add(new CategoryModel("Desserts", desserts));
        categories.add(new CategoryModel("Snacks", snacks));
        categories.add(new CategoryModel("Main", mains));

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategories(categories);

        rv_category = findViewById(R.id.rv_category);
        rv_category.setAdapter(categoryAdapter);
        rv_category.setLayoutManager(new LinearLayoutManager(this));
    }
}