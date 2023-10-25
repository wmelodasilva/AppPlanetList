package com.example.listadeplanetas.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.listadeplanetas.R;
import com.example.listadeplanetas.adapter.PlanetasAdapter;
import com.example.listadeplanetas.helper.Db_helper;
import com.example.listadeplanetas.helper.RecyclerItemClickListener;
import com.example.listadeplanetas.model.Planeta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetasAdapter planetasAdapter;
    private List<Planeta> listaPlanetas = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configurando o RECYCLER
        recyclerView = findViewById(R.id.id_planet_recycler);
        Db_helper db = new Db_helper(getApplicationContext());

        ContentValues cv = new ContentValues();
        cv.put("nome", "Plutonio");

        db.getWritableDatabase().insert("planetas", null, cv);

        //EVENTO DE CLICK
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Log.i("Click", "onItemClick");
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Log.i("Click", "onLongItemClick");
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TeladePlanetas.class);
                startActivity(intent);
            }
        });



    }


    public void  carregarPlanetas() {

        // LISTANDO PLANETAS
        Planeta planeta = new Planeta();
        planeta.setNomePlaneta("CARALUPTER");
        listaPlanetas.add(planeta);

        //EXIBINDO LISTA  DE PLANETAS NO RECYCLERVIEW


        // CONFIGURANDO ADAPTER
        planetasAdapter = new PlanetasAdapter(listaPlanetas);

        //CONFIGURANDO O RECYCLERVIEW
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(planetasAdapter);


    }

    @Override
    protected void onStart() {
        carregarPlanetas();
        super.onStart();
    }
}