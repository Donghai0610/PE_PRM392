package com.example.pratical_exam.entity;

import androidx.databinding.ObservableField;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.NonNull;

@Entity(tableName = "furniture_binding")
public class FurniteBinding
{
    @PrimaryKey
    @androidx.annotation.NonNull
    public String code;
    @NonNull
    @ColumnInfo(name = "furniture_name")
    public String  furnitureName;

    @NonNull
    @ColumnInfo(name = "quantity")
    public Integer  quantity;
    @NonNull
    @ColumnInfo(name = "price")
    public Float price;

    @NonNull
    @ColumnInfo(name = "type")
    public   String type;

    public  FurniteBinding(){

    }
    public FurniteBinding(@NonNull String type, @NonNull Float price, @NonNull Integer quantity, @NonNull String furnitureName, @androidx.annotation.NonNull String code) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.furnitureName = furnitureName;
        this.code = code;
    }

    @androidx.annotation.NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@androidx.annotation.NonNull String code) {
        this.code = code;
    }

    public @NonNull String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(@NonNull String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public @NonNull Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    public @NonNull Float getPrice() {
        return price;
    }

    public void setPrice(@NonNull Float price) {
        this.price = price;
    }

    public @NonNull String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }
}
