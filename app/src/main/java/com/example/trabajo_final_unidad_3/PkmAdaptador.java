package com.example.trabajo_final_unidad_3;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PkmAdaptador extends RecyclerView.Adapter<PkmAdaptador.PkmViewHolder> {
    // Variables
    ArrayList<Pokemon> lista;
    private boolean coloresActivados = false;
    private boolean mostrarTipo = false;
    private boolean mostrarImagen = false;

    // Constructor que recibe la lista de Pokémon
    public PkmAdaptador(ArrayList<Pokemon> lista) {
        if (lista == null || lista.isEmpty()) {
            Log.w("Warning", "La lista de Pokémon está vacía o es null.");
        }
        this.lista = lista;
    }

    @NonNull
    @Override
    public PkmAdaptador.PkmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PkmAdaptador.PkmViewHolder pkmViewHolder =
                new PkmViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha,parent,false)
                );
        return pkmViewHolder;
    }

    // Asocia los datos de un Pokémon con las vistas del ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PkmAdaptador.PkmViewHolder holder, int position) {
        // Obtiene el pokemon segun su posicion
        Pokemon pkm = lista.get(position);
        if (pkm == null) {
            Log.w("Warning", "El Pokémon en la posición " + position + " es null.");
            return;
        }
        holder.tv_nombre.setText(pkm.getName());
        holder.tv_type.setText(pkm.getType());
        holder.imagen.setImageResource(pkm.getImage());

        // color del nombre segun su tipo
        if(coloresActivados){
            holder.tv_nombre.setTextColor(getColor(pkm.getType()));
        }else{
            holder.tv_nombre.setTextColor(Color.BLACK);
        }

        // mostrar u ocultar el tipo
        if(mostrarTipo){
            holder.tv_type.setTextColor(Color.BLACK);
        }else{
            holder.tv_type.setTextColor(Color.WHITE);
        }

        // mostrar u ocultar el pokemon segun el switch
        if (pkm.isShowImage()) {
            holder.imagen.setVisibility(View.VISIBLE);
            holder.show_image.setChecked(true);
        } else {
            holder.imagen.setVisibility(View.GONE);
            holder.show_image.setChecked(false);
        }

        // configurar el switch
        holder.show_image.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pkm.setShowImage(isChecked); // Actualizar el estado en el modelo
            holder.imagen.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        // evento al clickar un objeto de la lista
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(
                    v.getContext(),
                    pkm.getName() + " de tipo " + pkm.getType(),
                    Toast.LENGTH_SHORT
            ).show();
        });



    }

    // devuelve un color segun el tipo
    private int getColor(String type){
        switch (type.toLowerCase()){
            case "planta":
                return Color.parseColor("#6da01e");
            case "fuego":
                return Color.RED;
            case "agua":
                return Color.BLUE;
            case "normal":
                return Color.BLACK;
            case "veneno":
                return Color.MAGENTA;
            case "roca":
                return Color.parseColor("#A52A2A");
            case "electrico":
                return Color.parseColor("#eadb24");
            case "hada":
                return Color.parseColor("#FFC0CB");
            case "lucha":
                return Color.parseColor("#FFA500");
            case "psiquico":
                return Color.parseColor("#800080");
            default:
                return Color.WHITE;
        }

    }

    public void activarColores(boolean activar){
        coloresActivados = activar;
        notifyDataSetChanged(); // Notifica cambios
    }
    public void mostrarTipo(boolean mostrar) {
        mostrarTipo = mostrar;
        notifyDataSetChanged();
    }
    public void setMostrarImagen(boolean mostrar) {
        mostrarImagen = mostrar;
        notifyDataSetChanged();
    }


    // Devuelve la cantidad de elementos de la lista
    @Override
    public int getItemCount() {
        return lista.size();
    }

    // Clase interna para definir el ViewHolder de cada elemento
    public class PkmViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nombre;
        TextView tv_type;
        ImageView imagen;
        Switch show_image;

        // Constructor que enlaza las vistas de la ficha
        public PkmViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_type = itemView.findViewById(R.id.tv_type);
            imagen = itemView.findViewById(R.id.imagen);
            show_image = itemView.findViewById(R.id.show_image);
        }

    }



}
