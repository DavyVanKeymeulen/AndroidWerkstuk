/*package com.example.androidwerkstukdavyvankeymeulen.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidwerkstukdavyvankeymeulen.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * from user_table")
    LiveData<List<User>> getAll();

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

}
*/