package com.example.androidwerkstukdavyvankeymeulen.Views;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidwerkstukdavyvankeymeulen.Database.Repo;
import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;

import java.util.List;

public class AnimalViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<Animal>> allAnimals;

    public AnimalViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo(application);
        allAnimals = repo.getAllAnimals();
    }
    public void insert(Animal animal){
        repo.insertAnimal(animal);
    }
    public void update(Animal animal){
        repo.updateAnimal(animal);
    }
    public void delete(Animal animal){
        repo.deleteAnimal(animal);
    }
    public void deleteAll(){
        repo.deleteAllAnimal();
    }

    public LiveData<List<Animal>> getAllAnimals() {
        return allAnimals;
    }
}
