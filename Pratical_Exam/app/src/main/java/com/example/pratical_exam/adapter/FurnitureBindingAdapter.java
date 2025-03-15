package com.example.pratical_exam.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pratical_exam.databinding.FurnitureItemsListBindingBinding;
import com.example.pratical_exam.entity.FurniteBinding;

import java.util.List;

public class FurnitureBindingAdapter extends RecyclerView.Adapter<FurnitureBindingAdapter.ViewHolder> {
    private List<FurniteBinding> furniteBindingList;

    public FurnitureBindingAdapter(List<FurniteBinding> furniteBindingList) {
        this.furniteBindingList = furniteBindingList;
    }

    @NonNull
    @Override
    public FurnitureBindingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FurnitureItemsListBindingBinding binding = FurnitureItemsListBindingBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureBindingAdapter.ViewHolder holder, int position) {
        FurniteBinding furniteBinding = furniteBindingList.get(position);
        holder.binding.setFurniturebinding(furniteBinding);
    }

    @Override
    public int getItemCount() {
        return  (furniteBindingList != null) ? furniteBindingList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private FurnitureItemsListBindingBinding binding;

        public ViewHolder(@NonNull FurnitureItemsListBindingBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
