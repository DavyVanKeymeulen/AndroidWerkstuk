package com.example.androidwerkstukdavyvankeymeulen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class addDatumActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    Calendar calendar;
    DatePickerDialog datePickerDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_datum);
        textView=(TextView)findViewById(R.id.txtDatum);
        button=(Button)findViewById(R.id.btn_geboortedatum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar= Calendar.getInstance();
                int dag = calendar.get(Calendar.DAY_OF_MONTH);
                int maand = calendar.get(Calendar.MONTH);
                int jaar = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(addDatumActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },dag,maand,jaar);
                datePickerDialog.updateDate(jaar,maand,dag);

                datePickerDialog.show();
            }
        });
    }

    public void addDatum(View view)
    {
        //datum toevoegen
        openListActivity();
    }

    public void openListActivity() {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.backmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_back:
                Intent intent = new Intent(this, PetListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
