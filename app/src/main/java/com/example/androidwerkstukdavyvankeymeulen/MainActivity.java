package com.example.androidwerkstukdavyvankeymeulen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidwerkstukdavyvankeymeulen.Database.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //stappen die moeten gebeuren na klikken van login
    public void login(View view)
    {
        //If statement checken of login klopt!!

        //functie aanroepen voor terug naar andere activity te gaan
        openListActivity();
    }

    //functie voor terug naar andere activity te gaan met intent
    public void openListActivity() {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
    }
}
