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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class addPetActivity extends AppCompatActivity {
    public static final String Extra_NAAM=
    "com.example.androidwerkstukdavyvankeymeulen.Extra_NAAM";
    public static final String Extra_Soort=
            "com.example.androidwerkstukdavyvankeymeulen.Extra_Soort";
    public static final String Extra_Ras=
            "com.example.androidwerkstukdavyvankeymeulen.Extra_Ras";
    public static final String Extra_Sex=
            "com.example.androidwerkstukdavyvankeymeulen.Extra_Sex";
    public static final String Extra_Kleur=
            "com.example.androidwerkstukdavyvankeymeulen.Extra_Kleur";
    public static final String Extra_Datum=
            "com.example.androidwerkstukdavyvankeymeulen.Extra_Datum";

    private EditText editTextNaam;
    private EditText editTextSoort;
    private EditText editTextRas;
    private EditText editTextSex;
    private EditText editTextKleur;

    private TextView textView;
    private Button button;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    //voor calender
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        editTextNaam = findViewById(R.id.edtNaam);
        editTextSoort = findViewById(R.id.edtSoort);
        editTextRas = findViewById(R.id.edtRas);
        editTextSex = findViewById(R.id.edtSex);
        editTextKleur = findViewById(R.id.edtKleur);

        textView = (TextView) findViewById(R.id.txtDatum);
        button = (Button) findViewById(R.id.btn_geboortedatum);
        //standaardwaarde
        textView.setText(" ");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int dag = calendar.get(Calendar.DAY_OF_MONTH);
                int maand = calendar.get(Calendar.MONTH);
                int jaar = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(addPetActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, dag, maand, jaar);
                datePickerDialog.updateDate(jaar, maand, dag);

                datePickerDialog.show();

            }
        });
    }

    //stappen die moeten gebeuren na klikken van add dier
    public void addDier(View view) {
        String naam= editTextNaam.getText().toString();
        String soort = editTextSoort.getText().toString();
        String ras = editTextRas.getText().toString();
        String sex = editTextRas.getText().toString();
        String kleur = editTextKleur.getText().toString();
        String datum = textView.getText().toString();

        if(naam.trim().isEmpty() || soort.trim().isEmpty() || ras.trim().isEmpty() ||sex.trim().isEmpty() ||kleur.trim().isEmpty() || datum.trim().isEmpty()){
           Toast.makeText(this,"@string/controle",Toast.LENGTH_SHORT).show();
           return;
        }

        Intent data = new Intent();
        data.putExtra(Extra_NAAM,naam);
        data.putExtra(Extra_Soort,soort);
        data.putExtra(Extra_Ras,ras);
        data.putExtra(Extra_Sex,sex);
        data.putExtra(Extra_Kleur,kleur);
        data.putExtra(Extra_Datum,datum);

        setResult(RESULT_OK, data);
        finish();
        //functie aanroepen voor terug naar andere activity te gaan
        openListActivity();
    }

    //functie voor terug naar andere activity te gaan met intent
    public void openListActivity() {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
    }

    //menu creeren en aanroepen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.backmenu, menu);
        return true;
    }

    //listener voor als er op de mennu geduwdt wordt.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_back:
                Intent intent = new Intent(this, PetListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
