package com.example.androidwerkstukdavyvankeymeulen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;
import com.example.androidwerkstukdavyvankeymeulen.Recycler.lijstAdapter;
import com.example.androidwerkstukdavyvankeymeulen.Views.AnimalViewModel;

import java.util.List;

public class PetListActivity extends AppCompatActivity {
    public static final int EDIT_ANIMAL_REQUEST =2;
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

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                animalViewModel.delete(lijstAdapter.getAnimalAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

        lijstAdapter.setOnItemClickListener(new lijstAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Animal animal) {
                Intent intent = new Intent(PetListActivity.this, addEditPetActivity.class);
                intent.putExtra(addEditPetActivity.Extra_ID, animal.getId());
                intent.putExtra(addEditPetActivity.Extra_NAAM, animal.getNaam());
                intent.putExtra(addEditPetActivity.Extra_Datum, animal.getGeboortedatum());
                intent.putExtra(addEditPetActivity.Extra_Soort, animal.getSoort());
                intent.putExtra(addEditPetActivity.Extra_Ras, animal.getRas());
                intent.putExtra(addEditPetActivity.Extra_Kleur, animal.getKleur());
                intent.putExtra(addEditPetActivity.Extra_Sex, animal.getGeslacht());
                startActivityForResult(intent,EDIT_ANIMAL_REQUEST);
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
                Intent intent2 = new Intent(this, addEditPetActivity.class);
                startActivityForResult(intent2,ADD_ANIMAL_REQUEST);
                return true;
            case R.id.nav_delete:
                animalViewModel.deleteAll();
                Toast.makeText(this,getResources().getString(R.string.alldelete),Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ADD_ANIMAL_REQUEST && resultCode == RESULT_OK){
            String naam =data.getStringExtra(addEditPetActivity.Extra_NAAM);
            String soort =data.getStringExtra(addEditPetActivity.Extra_Soort);
            String ras =data.getStringExtra(addEditPetActivity.Extra_Ras);
            String sex =data.getStringExtra(addEditPetActivity.Extra_Sex);
            String kleur =data.getStringExtra(addEditPetActivity.Extra_Kleur);
            String datum =data.getStringExtra(addEditPetActivity.Extra_Datum);

            Animal animal = new Animal(naam,soort,ras,sex,kleur,datum);
            animalViewModel.insert(animal);

            Toast.makeText(this,getResources().getString(R.string.opgeslaan),Toast.LENGTH_SHORT).show();

        } else if(requestCode == EDIT_ANIMAL_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(addEditPetActivity.Extra_ID,-1);

            if(id == -1){
                Toast.makeText(this,getResources().getString(R.string.kan_niet),Toast.LENGTH_SHORT).show();
                return;
            }
            String naam =data.getStringExtra(addEditPetActivity.Extra_NAAM);
            String soort =data.getStringExtra(addEditPetActivity.Extra_Soort);
            String ras =data.getStringExtra(addEditPetActivity.Extra_Ras);
            String sex =data.getStringExtra(addEditPetActivity.Extra_Sex);
            String kleur =data.getStringExtra(addEditPetActivity.Extra_Kleur);
            String datum =data.getStringExtra(addEditPetActivity.Extra_Datum);

            Animal animal = new Animal(naam,soort,ras,sex,kleur,datum);
            animal.setId(id);
            animalViewModel.update(animal);
            Toast.makeText(this,getResources().getString(R.string.gewijziged),Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,getResources().getString(R.string.niet_opgeslaan),Toast.LENGTH_SHORT).show();

        }
    }
}
