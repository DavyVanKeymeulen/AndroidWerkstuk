package com.example.androidwerkstukdavyvankeymeulen.Views;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidwerkstukdavyvankeymeulen.Database.Repo;
import com.example.androidwerkstukdavyvankeymeulen.Entity.AgendaPunt;


import java.util.List;

public class AgendaPuntViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<AgendaPunt>> allagendapunt;
    public AgendaPuntViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo(application);
        allagendapunt = repo.getAllAgendaPunt();
    }
    public void insert(AgendaPunt agendaPunt){
        repo.insertAgendaPunt(agendaPunt);
    }
    public void update(AgendaPunt agendaPunt){
        repo.updateAgendaPunt(agendaPunt);
    }
    public void delete(AgendaPunt agendaPunt){
        repo.deleteAgendaPunt(agendaPunt);
    }
    public void deleteAll(){
        repo.deleteAllAgendaPunt();
    }

    public LiveData<List<AgendaPunt>> getAllagendapunt() {
        return allagendapunt;
    }
}
