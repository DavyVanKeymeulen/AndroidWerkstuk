package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidwerkstukdavyvankeymeulen.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT username FROM user")
    List<User> getUsername();

    @Query("SELECT * from user")
    List<User> getAll();

    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User user);

}
