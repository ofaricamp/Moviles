package com.example.ejercicio6;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptadorMain2 extends RecyclerView.Adapter<adaptadorMain2.masInfo>{
    ArrayList<Pelicula> peliculas;
    private View.OnClickListener listener;
    int pos = RecyclerView.NO_POSITION;

    public int getPos(){return pos;}

    public void setPos(int newpos){
        if (newpos == this.pos){
            notifyItemChanged(this.pos);
            this.pos=RecyclerView.NO_POSITION;
        } else{
            if (this.pos >= 0){
                notifyItemChanged(this.pos);
            }
            this.pos = newpos;
            notifyItemChanged(this.pos);
        }
    }

    public adaptadorMain2(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public masInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaCelda2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.masinfo,parent,false);
        masInfo celda = new masInfo(vistaCelda2);
        vistaCelda2.setOnClickListener(listener);
        return celda;
    }

    @Override
    public void onBindViewHolder(@NonNull masInfo holder, int position) {
        holder.poster.setImageResource(peliculas.get(position).getPortada());
        holder.titulo.setText(peliculas.get(position).getTitulo());
        holder.director.setText("Director/a: "+peliculas.get(position).getDirector());
        holder.clasificacion.setImageResource(peliculas.get(position).getClasi());
        holder.duracion.setText("Duración: "+peliculas.get(position).getDuracion()+"");
        holder.sala.setText("Sala: "+peliculas.get(position).getSala());
        if (position == this.pos){

        }
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    public void onClick(View view){
        if (listener != null) listener.onClick(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class masInfo extends RecyclerView.ViewHolder{
        ImageView poster;
        ImageView clasificacion;
        TextView titulo;
        TextView director;
        TextView duracion;
        TextView sala;

        public masInfo(@NonNull View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.imageView4);
            this.clasificacion = itemView.findViewById(R.id.imageView5);
            this.titulo = itemView.findViewById(R.id.textView3);
            this.director = itemView.findViewById(R.id.textView4);
            this.duracion = itemView.findViewById(R.id.textView5);
            this.sala= itemView.findViewById(R.id.textView6);

        }
    }
}
