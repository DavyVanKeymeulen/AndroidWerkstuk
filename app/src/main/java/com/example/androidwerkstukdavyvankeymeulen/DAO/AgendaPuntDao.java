package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidwerkstukdavyvankeymeulen.Entity.AgendaPunt;

import java.util.List;

@Dao
public interface AgendaPuntDao {
    @Query("SELECT * from agendapunt")
    List<AgendaPunt> getAll();

    @Insert
    void insertUser(AgendaPunt... animals);

    @Delete
    void deleteUser(AgendaPunt animal);
}
