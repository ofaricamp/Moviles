package com.example.ejercicio6;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class activity2 extends AppCompatActivity {
ArrayList<Pelicula> peliculas;
RecyclerView rv;
MainActivity datos = new MainActivity();
ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        peliculas = datos.rellenaPeliculas();
        rv = findViewById(R.id.recyclerView2);

        adaptadorMain2 adaptadorMain2 = new adaptadorMain2(peliculas);
        GridLayoutManager grid2 = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(grid2);
        rv.setAdapter(adaptadorMain2);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = rv.getChildAdapterPosition(view);
                adaptadorMain2.setPos(pos);

                if (pos >= 0){
                    Intent intent = new Intent(activity2.this,Activity3.class);
                    intent.putExtra("poster",peliculas.get(pos).getPortada());
                    intent.putExtra("sinopsis",peliculas.get(pos).getSinopsis());
                    startActivity(intent);
                }
            }
        };
        adaptadorMain2.setOnClickListener(listener);
    }
}