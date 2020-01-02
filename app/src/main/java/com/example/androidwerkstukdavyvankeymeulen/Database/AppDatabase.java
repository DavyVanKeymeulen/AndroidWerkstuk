package com.example.androidwerkstukdavyvankeymeulen.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidwerkstukdavyvankeymeulen.DAO.UserDao;
import com.example.androidwerkstukdavyvankeymeulen.Entity.User;

@Database(entities={User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
