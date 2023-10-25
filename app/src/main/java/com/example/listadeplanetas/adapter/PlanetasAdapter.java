package com.example.listadeplanetas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadeplanetas.R;
import com.example.listadeplanetas.model.Planeta;

import java.util.List;

public class PlanetasAdapter extends RecyclerView.Adapter<PlanetasAdapter.MtViewHolder> {

    private  List<Planeta> planetaList;
    public PlanetasAdapter(List<Planeta> planetas) {

    }

    @Override
    public MtViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View itemPlaneta = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listaplaneta_adapter, parent, false);

        return new MtViewHolder(itemPlaneta);
    }

    @Override
    public void onBindViewHolder( MtViewHolder holder, int position) {

        Planeta planeta = planetaList.get(position);
        holder.planeta.setText(planeta.getNomePlaneta());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class MtViewHolder extends RecyclerView.ViewHolder{

            TextView planeta;

        public MtViewHolder( View itemView) {

            super(itemView);

            planeta = itemView.findViewById(R.id.textPlaneta);
        }
    }
}
