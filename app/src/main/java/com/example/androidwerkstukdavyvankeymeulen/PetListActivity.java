package com.example.androidwerkstukdavyvankeymeulen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

    ListView listView;
    //listviex invullen en adapter voor schrijbven
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        listView = (ListView)findViewById(R.id.Petlist);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Suske");
        arrayList.add("Wiske");



        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PetListActivity.this,"clicked "+ arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
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
