package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class favoritos extends AppCompatActivity {
ListView lv;
ArrayList<Pelicula> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        lv = findViewById(R.id.listView);
        peliculas = (ArrayList<Pelicula>) getIntent().getSerializableExtra("size");
        ArrayAdapter<Pelicula> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked,peliculas);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(adapter);

        for (int i = 0; i < peliculas.size(); i++){
            lv.setItemChecked(i,peliculas.get(i).getFavorita());
        }

    }
    @Override
    public void onBackPressed() {
        ArrayList<Boolean> fav = new ArrayList<>();

        for (int i =0; i < peliculas.size(); i++){
            fav.add(lv.isItemChecked(i));
        }

        Intent it = new Intent();
        it.putExtra("fav",fav);
        setResult(RESULT_OK,it);
        finish();
    }

}