package com.example.listadeplanetas.activity;
import com.example.listadeplanetas.R;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class TeladePlanetas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telalistadeplanetas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.itemSaved) {
            Toast.makeText(this, "SALVO", Toast.LENGTH_SHORT).show();
            return true;
        }
        // Outros casos de item de menu podem ser tratados aqui
        return super.onOptionsItemSelected(item);
    }

}