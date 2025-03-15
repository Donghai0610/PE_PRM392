package com.example.pratical_exam.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pratical_exam.entity.FurniteBinding;
import com.example.pratical_exam.entity.Furniture;

import java.util.List;

@Dao
public interface FurnitureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Furniture furniture);

    @Query("Select * from furniture")
    LiveData<List<Furniture>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBinding(FurniteBinding furniture);

    @Query("Select * from furniture")
   List<FurniteBinding> getAllBinding();

}
