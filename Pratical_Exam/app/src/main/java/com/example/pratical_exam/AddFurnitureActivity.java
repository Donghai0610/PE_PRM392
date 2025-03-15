package com.example.pratical_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pratical_exam.entity.Furniture;
import com.example.pratical_exam.repos.FurnitureRepository;

public class AddFurnitureActivity extends AppCompatActivity {
    private EditText edFurniteCode;
    private EditText edFurniteName;
//    private EditText edType;
    private Spinner edType;
    private EditText edPrice;
    private EditText edQuantity;

    private FurnitureRepository furnitureRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_furniture);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        furnitureRepository = new FurnitureRepository(this);
        edFurniteCode = findViewById(R.id.edFurniteCode);
        edFurniteName = findViewById(R.id.edFurniteName);
//        edType = findViewById(R.id.edType);
        edPrice = findViewById(R.id.edFurnitePrice);
        edQuantity = findViewById(R.id.edFurniteQuantity);
        edType = findViewById(R.id.edType);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edFurniteCode.getText().toString().isEmpty() || edFurniteCode.getText().toString().length() > 20 || !edFurniteCode.getText().toString().startsWith("P") || !edFurniteCode.getText().toString().matches("^[a-zA-Z0-9]+$")) {
                    edFurniteCode.requestFocus();
                    edFurniteCode.setError("Code is required");
                    return;

                }
                if (edFurniteName.getText().toString().isEmpty() || edFurniteName.getText().toString().length() > 50) {
                    edFurniteName.requestFocus();
                    edFurniteName.setError("Name is required");
                    return;
                }
//                if (edType.getText().toString().isEmpty() || edType.getText().toString().length() > 30) {
//                    edType.requestFocus();
//                    edType.setError("Type is required");
//                    return;
//                }
                if (edPrice.getText().toString().isEmpty() || edPrice.getText().toString().length() > 10 || !edPrice.getText().toString().matches("[0-9]+")) {
                    edPrice.requestFocus();
                    edPrice.setError("Price is required");
                    return;
                }
                if (edQuantity.getText().toString().isEmpty() || edQuantity.getText().toString().length() > 10 || !edQuantity.getText().toString().matches("[0-9]+")) {
                    edQuantity.requestFocus();
                    edQuantity.setError("Quantity is required");
                    return;
                }

                String code = edFurniteCode.getText().toString();
                String name = edFurniteName.getText().toString();
                String type = edType.getSelectedItem().toString();
//                String type = edType.getText().toString();
                Float price = Float.parseFloat(edPrice.getText().toString());
                int quantity = Integer.parseInt(edQuantity.getText().toString());
                furnitureRepository.insert(new Furniture(code, name, quantity, price, type));
                    Toast.makeText(AddFurnitureActivity.this, "Insert Successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(AddFurnitureActivity.this, FurturniteListBindingActivity.class);
                startActivity(intent);
                finish();


            }
        });

    }
//    private void saveFurniture() {
//        // Validate input fields before proceeding
//        if (!validateCode() || !validateName() || !validateType() || !validatePrice() || !validateQuantity()) {
//            return;
//        }
//
//        // Retrieve validated data
//        String code = edFurniteCode.getText().toString();
//        String name = edFurniteName.getText().toString();
//        String type = edType.getText().toString();
//        float price = Float.parseFloat(edPrice.getText().toString());
//        int quantity = Integer.parseInt(edQuantity.getText().toString());
//
//        // Insert into database
//        furnitureRepository.insert(new Furniture(code, name, quantity, price, type));
//
//        // Redirect to MainActivity
//        Intent intent = new Intent(AddFurnitureActivity.this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }

//    private boolean validateCode() {
//        String code = edFurniteCode.getText().toString().trim();
//        if (code.isEmpty()) {
//            edFurniteCode.setError("Code is required");
//            return false;
//        }
//        if (code.length() > 20) {
//            edFurniteCode.setError("Code must not exceed 20 characters");
//            return false;
//        }
//        if (!code.startsWith("P")) {
//            edFurniteCode.setError("Code must start with 'P'");
//            return false;
//        }
//        if (!code.matches("^[a-zA-Z0-9]+$")) {
//            edFurniteCode.setError("Code must contain only letters and numbers");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateName() {
//        String name = edFurniteName.getText().toString().trim();
//        if (name.isEmpty()) {
//            edFurniteName.setError("Name is required");
//            return false;
//        }
//        if (name.length() > 50) {
//            edFurniteName.setError("Name must not exceed 50 characters");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateType() {
//        String type = edType.getText().toString().trim();
//        if (type.isEmpty()) {
//            edType.setError("Type is required");
//            return false;
//        }
//        if (type.length() > 30) {
//            edType.setError("Type must not exceed 30 characters");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validatePrice() {
//        String priceStr = edPrice.getText().toString().trim();
//        if (priceStr.isEmpty()) {
//            edPrice.setError("Price is required");
//            return false;
//        }
//        if (priceStr.length() > 10) {
//            edPrice.setError("Price must not exceed 10 digits");
//            return false;
//        }
//        if (!priceStr.matches("[0-9]+")) {
//            edPrice.setError("Price must be a number");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validateQuantity() {
//        String quantityStr = edQuantity.getText().toString().trim();
//        if (quantityStr.isEmpty()) {
//            edQuantity.setError("Quantity is required");
//            return false;
//        }
//        if (quantityStr.length() > 10) {
//            edQuantity.setError("Quantity must not exceed 10 digits");
//            return false;
//        }
//        if (!quantityStr.matches("[0-9]+")) {
//            edQuantity.setError("Quantity must be a number");
//            return false;
//        }
//        return true;
//    }

}