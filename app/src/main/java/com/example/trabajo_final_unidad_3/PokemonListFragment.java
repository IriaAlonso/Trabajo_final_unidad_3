package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonListFragment extends Fragment {
    private ArrayList<Pokemon> arrayPkm;
    private PkmAdaptador pkmadaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        // Obtener la lista de Pokémon del Bundle
        if (getArguments() != null) {
            arrayPkm = getArguments().getParcelableArrayList("pokemon_list");
        } else {
            arrayPkm = new ArrayList<>();
        }

        // Configurar el RecyclerView
        pkmadaptador = new PkmAdaptador(arrayPkm);
        RecyclerView rv_pkm = view.findViewById(R.id.rv_pkm);
        rv_pkm.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_pkm.setAdapter(pkmadaptador);

        return view;
    }

    public void activarColores(boolean activar) {
        if (pkmadaptador != null) {
            pkmadaptador.activarColores(activar);
        }
    }

    public void mostrarTipo(boolean mostrar) {
        if (pkmadaptador != null) {
            pkmadaptador.mostrarTipo(mostrar);
        }
    }
}