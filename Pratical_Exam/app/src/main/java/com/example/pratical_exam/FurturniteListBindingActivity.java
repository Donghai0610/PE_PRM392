package com.example.pratical_exam;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pratical_exam.adapter.FurnitureBindingAdapter;
import com.example.pratical_exam.databinding.ActivityFurturniteListBindingBinding;
import com.example.pratical_exam.repos.FurnitureRepository;

public class FurturniteListBindingActivity extends AppCompatActivity {

private FurnitureBindingAdapter adapter;
private FurnitureRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_furturnite_list_binding);
        ActivityFurturniteListBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_furturnite_list_binding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        repository = new FurnitureRepository(this);
        adapter = new FurnitureBindingAdapter(repository.getAllBinding());
        binding.recycleViewFurnitureBinding.setAdapter(adapter);
        binding.recycleViewFurnitureBinding.setLayoutManager(new LinearLayoutManager(this));
        binding.btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, AddFurnitureActivity.class));
        });


    }
}