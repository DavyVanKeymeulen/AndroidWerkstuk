package com.example.androidwerkstukdavyvankeymeulen.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.androidwerkstukdavyvankeymeulen.DAO.AgendaPuntDao;
import com.example.androidwerkstukdavyvankeymeulen.DAO.AnimalDao;
import com.example.androidwerkstukdavyvankeymeulen.Entity.AgendaPunt;
import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;

import java.util.List;

public class Repo {
    private AgendaPuntDao agendaPuntDao;
    private LiveData<List<AgendaPunt>> allAgendaPunt;
    private AnimalDao animalDao;
    private LiveData<List<Animal>> allAnimals;

    public Repo(Application application){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        animalDao = appDatabase.animalDao();
        allAnimals = animalDao.getAllAnimals();
        agendaPuntDao = appDatabase.agendaPuntDao();
        allAgendaPunt = agendaPuntDao.getAll();
    }
    //alles voor animals
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

    //alles voor agendapunten
    public void insertAgendaPunt(AgendaPunt agendaPunt){
        new InsertAgendaPuntAsyncTask(agendaPuntDao).execute(agendaPunt);
    }

    public void deleteAgendaPunt(AgendaPunt agendaPunt){
        new DeleteAgendaPuntAsyncTask(agendaPuntDao).execute(agendaPunt);
    }

    public void updateAgendaPunt(AgendaPunt agendaPunt){
        new UpdateAgendaPuntAsyncTask(agendaPuntDao).execute(agendaPunt);

    }
    public void deleteAllAgendaPunt(){
        new DeleteAllAgendaPuntAsyncTask(agendaPuntDao).execute();

    }
    public LiveData<List<AgendaPunt>> getAllAgendaPunt(){
        return allAgendaPunt;
    }

    private static class InsertAgendaPuntAsyncTask extends AsyncTask<AgendaPunt, Void, Void>{
        private AgendaPuntDao agendaPuntDao;

        private InsertAgendaPuntAsyncTask(AgendaPuntDao agendaPuntDao){
            this.agendaPuntDao=agendaPuntDao;
        }
        @Override
        protected Void doInBackground(AgendaPunt... agendaPunts) {
            agendaPuntDao.insertAgendaPunt(agendaPunts[0]);
            return null;
        }
    }
    private static class UpdateAgendaPuntAsyncTask extends AsyncTask<AgendaPunt, Void, Void>{
        private AgendaPuntDao agendaPuntDao;


        private UpdateAgendaPuntAsyncTask(AgendaPuntDao agendaPuntDao){
            this.agendaPuntDao=agendaPuntDao;
        }
        @Override
        protected Void doInBackground(AgendaPunt... agendaPunts) {
            agendaPuntDao.updateAgendaPunt(agendaPunts[0]);
            return null;
        }
    }
    private static class DeleteAgendaPuntAsyncTask extends AsyncTask<AgendaPunt, Void, Void>{
        private AgendaPuntDao agendaPuntDao;

        private DeleteAgendaPuntAsyncTask(AgendaPuntDao agendaPuntDao){
            this.agendaPuntDao=agendaPuntDao;
        }
        @Override
        protected Void doInBackground(AgendaPunt... agendaPunts) {
            agendaPuntDao.deleteAgendaPunt(agendaPunts[0]);
            return null;
        }
    }
    private static class DeleteAllAgendaPuntAsyncTask extends AsyncTask<Void, Void, Void>{
        private AgendaPuntDao agendaPuntDao;

        private DeleteAllAgendaPuntAsyncTask(AgendaPuntDao agendaPuntDao){
            this.agendaPuntDao=agendaPuntDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            agendaPuntDao.deleteAllAgendaPunt();
            return null;
        }
    }

}
