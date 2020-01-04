package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;

import java.util.List;

@Dao
public interface AnimalDao {
    @Query("SELECT * from animal")
    List<Animal> getAll();

    @Insert
    void insertUser(Animal... animals);

    @Delete
    void deleteUser(Animal animal);
}
