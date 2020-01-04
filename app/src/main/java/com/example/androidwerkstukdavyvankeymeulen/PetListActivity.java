package com.example.androidwerkstukdavyvankeymeulen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;
import com.example.androidwerkstukdavyvankeymeulen.Recycler.lijstAdapter;
import com.example.androidwerkstukdavyvankeymeulen.Views.AnimalViewModel;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends AppCompatActivity {
    private AnimalViewModel animalViewModel;

    ListView listView;
    //listviex invullen en adapter voor schrijbven
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final lijstAdapter lijstAdapter = new lijstAdapter();
        recyclerView.setAdapter(lijstAdapter);

        animalViewModel = ViewModelProviders.of(this).get(AnimalViewModel.class);
        animalViewModel.getAllAnimals().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                lijstAdapter.setAnimals(animals);
            }
        });


    }

    //menu creeren en aanroepen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lijstmenu,menu);
        return true;
    }
    //listener voor als er op de mennu geduwdt wordt.

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_afmelden:
                //afmelden -> nog echt afmelden
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.nav_add:
                //add -> nieuwe activity
                Intent intent2 = new Intent(this, addPetActivity.class);
                startActivity(intent2);
                return true;
            case R.id.nav_delete:
                //verwijderen
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
