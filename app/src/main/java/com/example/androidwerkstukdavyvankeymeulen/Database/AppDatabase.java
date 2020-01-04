package com.example.androidwerkstukdavyvankeymeulen.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidwerkstukdavyvankeymeulen.DAO.AgendaPuntDao;
import com.example.androidwerkstukdavyvankeymeulen.DAO.AnimalDao;
import com.example.androidwerkstukdavyvankeymeulen.DAO.UserDao;
import com.example.androidwerkstukdavyvankeymeulen.Entity.AgendaPunt;
import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;
import com.example.androidwerkstukdavyvankeymeulen.Entity.User;

@Database(entities={User.class, Animal.class, AgendaPunt.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract AnimalDao animalDao();
    public abstract AgendaPuntDao agendaPuntDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"app_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return  instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance).execute();
        }
    };
    private static class PopulateAsyncTask extends AsyncTask<Void, Void, Void>{
        private AnimalDao animalDao;

        private  PopulateAsyncTask(AppDatabase appDatabase){
            animalDao = appDatabase.animalDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            animalDao.insertAnimal(new Animal(1,"Suske","kat","straatkat","female","strepen","07/08/2019"));
            animalDao.insertAnimal(new Animal(1,"Wiske","kat","straatkat","female","strepen","07/08/2019"));
            animalDao.insertAnimal(new Animal(1,"Djanko","Hond","chiuauaua","male","wit","07/08/2017"));
            return null;
        }
    }
}
