package com.example.ejercicio6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.MyCelda>{
    ArrayList<Pelicula> peliculas;
    int pos = RecyclerView.NO_POSITION;

    public int getPos() {
        return pos;
    }

    public void setPos(int newpos){
        if (this.pos == newpos){
            this.pos = RecyclerView.NO_POSITION;
            notifyItemChanged(newpos);
        } else{
            int aux = this.pos;
            this.pos = newpos;
            if (aux >= 0){
                notifyItemChanged(aux);
            }
            notifyItemChanged(newpos);
        }
    }

    public adaptador(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public MyCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View vitaCelda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,parent,false);
       MyCelda celda = new MyCelda(vitaCelda);
        return celda;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCelda holder, int position) {
        holder.poster.setImageResource(peliculas.get(position).getPortada());
        holder.titulo.setText(peliculas.get(position).getTitulo());
        holder.director.setText(peliculas.get(position).getDirector());
        holder.clasificacion.setImageResource(peliculas.get(position).getClasi());
        if (position == this.pos){
            holder.itemView.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    public class MyCelda extends RecyclerView.ViewHolder{
        ImageView poster;
        ImageView clasificacion;
        TextView titulo;
        TextView director;
        public MyCelda(@NonNull View itemView) {
            super(itemView);
            this.poster = itemView.findViewById(R.id.imageView);
            this.clasificacion = itemView.findViewById(R.id.imageView2);
            this.titulo = itemView.findViewById(R.id.Nombre);
            this.director = itemView.findViewById(R.id.textView2);

        }
    }
}
