package com.betterashthandust.foodwars.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.betterashthandust.foodwars.R;
import com.betterashthandust.foodwars.listeners.ClickListener;
import com.betterashthandust.foodwars.listeners.RecyclerTouchListener;
import com.betterashthandust.foodwars.models.CategoryModel;
import com.betterashthandust.foodwars.models.FoodModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryModel> categories = new ArrayList<>();

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        CategoryModel chosenModel = categories.get(position);
        Context context = holder.recyclerView.getContext();

        holder.textView.setText(chosenModel.getTitle());
        FoodAdapter foodAdapter = new FoodAdapter();
        foodAdapter.setFoodItems(chosenModel.getFoodItems());

        holder.recyclerView.setAdapter(foodAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        holder.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, holder.recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                showPopUpWindow(context, view, chosenModel.getFoodItems().get(position));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void showPopUpWindow(Context context, View view, FoodModel foodModel) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.recipe_layout, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        ImageView imageView = popupWindow.getContentView().findViewById(R.id.img_recipe_food);
        try {
            imageView.setImageResource(R.drawable.class.getField(foodModel.getImageSrc()).getInt(null));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            imageView.setImageResource(R.drawable.sample_image);
        }

        TextView txt_title = popupWindow.getContentView().findViewById(R.id.txt_title);
        txt_title.setText(foodModel.getName());

        TextView txt_ingredients = popupWindow.getContentView().findViewById(R.id.txt_ingredients);
        txt_ingredients.setText(foodModel.getIngredients());

        TextView txt_macros = popupWindow.getContentView().findViewById(R.id.txt_macros);
        txt_macros.setText(foodModel.getMacros());

        TextView txt_recipe = popupWindow.getContentView().findViewById(R.id.txt_recipe);
        txt_recipe.setText(foodModel.getRecipe());

        ImageButton imageButton = popupWindow.getContentView().findViewById(R.id.btn_close);
        imageButton.setOnClickListener(v -> popupWindow.dismiss());

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(ArrayList<CategoryModel> categories) {
        this.categories = categories;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_parent);
            recyclerView = itemView.findViewById(R.id.rv_child);
        }
    }
}
