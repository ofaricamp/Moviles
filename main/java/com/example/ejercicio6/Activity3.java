package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;
    TextView sinopsis;
    ImageView poster;
    MainActivity datos = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcionpelicula);

        poster = findViewById(R.id.imageView3);
        sinopsis = findViewById(R.id.textView);


        Intent intent = getIntent();
        poster.setImageResource(intent.getIntExtra("poster",R.drawable.sincara));
        sinopsis.setText(intent.getStringExtra("sinopsis"));


    }
}