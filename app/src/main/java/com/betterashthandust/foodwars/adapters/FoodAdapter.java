package com.betterashthandust.foodwars.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.betterashthandust.foodwars.R;
import com.betterashthandust.foodwars.models.FoodModel;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private ArrayList<FoodModel> foodItems = new ArrayList<>();

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        holder.textView.setText(foodItems.get(position).getName());
        try {
            holder.imageView.setImageResource(R.drawable.class.getField(foodItems.get(position).getImageSrc()).getInt(null));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            holder.imageView.setImageResource(R.drawable.sample_image);
        }
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public void setFoodItems(ArrayList<FoodModel> foodItems) {
        this.foodItems = foodItems;
        notifyDataSetChanged();
    }

    public ArrayList<FoodModel> getFoodItems() {
        return foodItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_food);
            textView = itemView.findViewById(R.id.txt_food);
        }
    }
}
