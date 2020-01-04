package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidwerkstukdavyvankeymeulen.Entity.AgendaPunt;

import java.util.List;

@Dao
public interface AgendaPuntDao {
    @Query("SELECT * from agendapunt_table")
    LiveData<List<AgendaPunt>> getAll();

    @Insert
    void insertAgendaPunt(AgendaPunt agendaPunt);

    @Update
    void updateAgendaPunt(AgendaPunt agendaPunt);

    @Delete
    void deleteAgendaPunt(AgendaPunt agendaPunt);


}
