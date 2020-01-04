package com.example.androidwerkstukdavyvankeymeulen.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal_table")
public class Animal {
    @PrimaryKey(autoGenerate=true)
    private int id;

    @ColumnInfo(name="user_id")
    private int userid;

    private String naam;

    private String soort;

    private String ras;

    private String geslacht;

    private String kleur;

    private String geboortedatum;

    public Animal(int userid, String naam, String soort, String ras, String geslacht, String kleur, String geboortedatum) {
        this.userid = userid;
        this.naam = naam;
        this.soort = soort;
        this.ras = ras;
        this.geslacht = geslacht;
        this.kleur = kleur;
        this.geboortedatum = geboortedatum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
}
