package com.example.pratical_exam.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.NonNull;

@Entity(tableName = "furniture")
public class Furniture {
    @PrimaryKey
    @androidx.annotation.NonNull
    private String code;
    @NonNull
    @ColumnInfo(name = "furniture_name")
    private String furnitureName;

    @NonNull
    @ColumnInfo(name = "quantity")
    private int quantity;
    @NonNull
    @ColumnInfo(name = "price")
    private float price;

    @NonNull
    @ColumnInfo(name = "type")
    private  String type;

    public Furniture(String code, @NonNull String furnitureName, @NonNull int quantity, @NonNull float price, @NonNull String type) {
        this.code = code;
        this.furnitureName = furnitureName;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public Furniture() {
    }

    public @NonNull String getCode() {
        return code;
    }

    public void setCode( String code) {
        this.code = code;
    }

    public @NonNull String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(@NonNull String furnitureName) {
        this.furnitureName = furnitureName;
    }

    @NonNull
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public float getPrice() {
        return price;
    }

    public void setPrice(@NonNull float price) {
        this.price = price;
    }

    public @NonNull String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }
}
