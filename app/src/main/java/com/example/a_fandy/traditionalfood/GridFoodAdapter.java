package com.example.a_fandy.traditionalfood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridFoodAdapter extends RecyclerView.Adapter<GridFoodAdapter.GridViewHolder> {
    public GridFoodAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    private ArrayList<Food> listFood;

    @NonNull
    @Override
    public GridFoodAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_food, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridFoodAdapter.GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListFood().get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListFood().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
