package com.example.androidwerkstukdavyvankeymeulen.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "agendaPunt_table")
public class AgendaPunt {
    @PrimaryKey(autoGenerate=true)
    private int id;

    @ColumnInfo(name="animal_id")
    private int animalId;

    private String info;

    private String datum;

    public AgendaPunt(int animalId, String info, String datum) {
        this.animalId = animalId;
        this.info = info;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
