package com.example.pratical_exam.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pratical_exam.entity.FurniteBinding;
import com.example.pratical_exam.entity.Furniture;

@Database(entities = {Furniture.class, FurniteBinding.class}, version = 2,exportSchema = false)
public abstract class AppDB  extends RoomDatabase {
    public abstract FurnitureDao furnitureDao();
    private static AppDB INSTANCE = null;
    public  static  AppDB getInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDB.class){
                if (INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDB.class,"furniture_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
            return INSTANCE;
        }
        return INSTANCE;
    }
}
