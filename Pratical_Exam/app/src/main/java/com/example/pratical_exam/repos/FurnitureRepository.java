package com.example.pratical_exam.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pratical_exam.dao.AppDB;
import com.example.pratical_exam.dao.FurnitureDao;
import com.example.pratical_exam.entity.FurniteBinding;
import com.example.pratical_exam.entity.Furniture;

import java.util.List;

public class FurnitureRepository {
    private final FurnitureDao furnitureDao;
    public FurnitureRepository(Context context){
        AppDB db = AppDB.getInstance(context);
        furnitureDao = db.furnitureDao();
    }
    public LiveData<List<Furniture>> getAll(){
        return furnitureDao.getAll();
    }

    public void insert(Furniture furniture){
        furnitureDao.insert(furniture);
    }

    public List<FurniteBinding> getAllBinding(){
        return furnitureDao.getAllBinding();
    }
    public void insertBinding(FurniteBinding furniture){
        furnitureDao.insertBinding(furniture);
    }

}
