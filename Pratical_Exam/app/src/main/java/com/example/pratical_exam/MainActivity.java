package com.example.pratical_exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pratical_exam.adapter.FurnitureAdapter;
import com.example.pratical_exam.entity.Furniture;
import com.example.pratical_exam.repos.FurnitureRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FurnitureRepository furnitureRepository;
    private FurnitureAdapter furnitureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        furnitureRepository = new FurnitureRepository(this);
        furnitureAdapter = new FurnitureAdapter(this);


        RecyclerView recyclerView = findViewById(R.id.recycleViewFurniture);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(furnitureAdapter);

        furnitureRepository.getAll().observe(this, new Observer<List<Furniture>>() {
            @Override
            public void onChanged(List<Furniture> furnitureList) {
                // Update the adapter when data changes
                furnitureAdapter.setFurnitureList(furnitureList);
            }
        });
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddFurnitureActivity.class);
            startActivity(intent);
        });

    }
}