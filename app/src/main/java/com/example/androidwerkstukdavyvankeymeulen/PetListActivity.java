package com.example.androidwerkstukdavyvankeymeulen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static final int ADD_ANIMAL_REQUEST =1;

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
                startActivityForResult(intent2,ADD_ANIMAL_REQUEST);
                return true;
            case R.id.nav_delete:
                //verwijderen
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_ANIMAL_REQUEST && resultCode == RESULT_OK){
            String naam =data.getStringExtra(addPetActivity.Extra_NAAM);
            String soort =data.getStringExtra(addPetActivity.Extra_Soort);
            String ras =data.getStringExtra(addPetActivity.Extra_Ras);
            String sex =data.getStringExtra(addPetActivity.Extra_Sex);
            String kleur =data.getStringExtra(addPetActivity.Extra_Kleur);
            String datum =data.getStringExtra(addPetActivity.Extra_Datum);

            Animal animal = new Animal(naam,soort,ras,sex,kleur,datum);
            animalViewModel.insert(animal);

            Toast.makeText(this,"@string/opgeslaan",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"@string/niet_opgeslaan",Toast.LENGTH_SHORT).show();

        }
    }
}
