package com.example.androidwerkstukdavyvankeymeulen.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class AgendaPunt {
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="id")
    public int id;

    @ColumnInfo(name="animalId")
    public int animalId;

    @ColumnInfo(name = "info")
    public String info;

    @ColumnInfo(name = "datum")
    public String datum;

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
