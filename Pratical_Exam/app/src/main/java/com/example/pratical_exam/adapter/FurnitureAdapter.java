package com.example.pratical_exam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pratical_exam.R;
import com.example.pratical_exam.entity.Furniture;

import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder> {
    private Context context;
    private List<Furniture>furnitureList;

    public FurnitureAdapter(Context context) {
        this.context = context;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FurnitureAdapter.FurnitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.furniture_items_list, parent, false);

        return new FurnitureViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureAdapter.FurnitureViewHolder holder, int position) {
        Furniture furniture = furnitureList.get(position);
        holder.tvCode.setText(furniture.getCode());
        holder.tvName.setText(furniture.getFurnitureName());
        holder.tvType.setText(furniture.getType());
        holder.tvPrice.setText(String.valueOf(furniture.getPrice()));
        holder.tvQuantity.setText(String.valueOf(furniture.getQuantity()));

    }

    @Override
    public int getItemCount() {
        return (furnitureList != null) ? furnitureList.size() : 0;
    }

    public static class FurnitureViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCode;
        private TextView tvName;
        private TextView tvType;
        private TextView tvPrice;
        private TextView tvQuantity;

        public FurnitureViewHolder(@NonNull View itemView, FurnitureAdapter adapter) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tvFurnitureCode);
            tvName = itemView.findViewById(R.id.tvFurniteName);
            tvType = itemView.findViewById(R.id.tvFurniteType);
            tvPrice = itemView.findViewById(R.id.tvFurnitePrice);
            tvQuantity = itemView.findViewById(R.id.tvFurniteQuantity);
        }
    }
}
