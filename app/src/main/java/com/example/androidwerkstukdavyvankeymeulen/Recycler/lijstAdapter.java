package com.example.androidwerkstukdavyvankeymeulen.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidwerkstukdavyvankeymeulen.Entity.Animal;
import com.example.androidwerkstukdavyvankeymeulen.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class lijstAdapter extends RecyclerView.Adapter <lijstAdapter.lijstHolder> {
    private List<Animal> animals = new ArrayList<>();

    @NonNull
    @Override
    public lijstHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_pet_voor_lijst,parent,false);
        return new lijstHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull lijstHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.textViewNaam.setText(animal.getNaam());
        holder.textViewDatum.setText(animal.getGeboortedatum());
        holder.textViewSoort.setText(animal.getGeslacht());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
    public void setAnimals(List<Animal> animals){
        this.animals=animals;
        notifyDataSetChanged();
    }

    class lijstHolder extends RecyclerView.ViewHolder{
        private TextView textViewNaam;
        private TextView textViewSoort;
        private TextView textViewDatum;

        public lijstHolder(@NonNull View itemView) {
            super(itemView);
            textViewNaam = itemView.findViewById(R.id.text_view_naam);
            textViewSoort = itemView.findViewById(R.id.text_view_soort);
            textViewDatum = itemView.findViewById(R.id.text_view_geboortedatum);
        }
    }

}
