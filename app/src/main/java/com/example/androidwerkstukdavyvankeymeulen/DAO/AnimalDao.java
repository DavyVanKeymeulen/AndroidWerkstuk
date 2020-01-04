package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;

import java.util.List;

@Dao
public interface AnimalDao {
    @Query("SELECT * from animal_table Order by naam desc")
    LiveData<List<Animal>> getAllAnimals();

    @Insert
    void insertAnimal(Animal animal);

    @Update
    void updateAnimal(Animal animal);

    @Delete
    void deleteAnimal(Animal animal);

    @Query("delete from animal_table")
    void deleteAllAnimals();
}
