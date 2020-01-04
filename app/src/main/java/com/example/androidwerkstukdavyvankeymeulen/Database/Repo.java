package com.example.androidwerkstukdavyvankeymeulen.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.androidwerkstukdavyvankeymeulen.DAO.AgendaPuntDao;
import com.example.androidwerkstukdavyvankeymeulen.DAO.AnimalDao;
import com.example.androidwerkstukdavyvankeymeulen.DAO.UserDao;
import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;

import java.util.List;

public class Repo {
    private UserDao userDao;
    private AgendaPuntDao agendaPuntDao;
    private AnimalDao animalDao;
    private LiveData<List<Animal>> allAnimals;

    public Repo(Application application){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        animalDao = appDatabase.animalDao();
        allAnimals = animalDao.getAllAnimals();
    }

    public void insertAnimal(Animal animal){
        new InsertAnimalAsyncTask(animalDao).execute(animal);
    }

    public void deleteAnimal(Animal animal){
        new DeleteAnimalAsyncTask(animalDao).execute(animal);
    }

    public void updateAnimal(Animal animal){
        new UpdateAnimalAsyncTask(animalDao).execute(animal);

    }
    public void deleteAllAnimal(){
        new DeleteAllAnimalAsyncTask(animalDao).execute();

    }
    public LiveData<List<Animal>> getAllAnimals(){
        return allAnimals;
    }

    private static class InsertAnimalAsyncTask extends AsyncTask<Animal, Void, Void>{
        private AnimalDao animalDao;

        private InsertAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao=animalDao;
        }
        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.insertAnimal(animals[0]);
            return null;
        }
    }
    private static class UpdateAnimalAsyncTask extends AsyncTask<Animal, Void, Void>{
        private AnimalDao animalDao;

        private UpdateAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao=animalDao;
        }
        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.updateAnimal(animals[0]);
            return null;
        }
    }
    private static class DeleteAnimalAsyncTask extends AsyncTask<Animal, Void, Void>{
        private AnimalDao animalDao;

        private DeleteAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao=animalDao;
        }
        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.deleteAnimal(animals[0]);
            return null;
        }
    }
    private static class DeleteAllAnimalAsyncTask extends AsyncTask<Void, Void, Void>{
        private AnimalDao animalDao;

        private DeleteAllAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao=animalDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            animalDao.deleteAllAnimals();
            return null;
        }
    }

}
