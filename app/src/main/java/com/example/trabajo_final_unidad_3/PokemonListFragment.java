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
import java.util.Arrays;

public class PokemonListFragment extends Fragment {
    private ArrayList<Pokemon> arrayPkm;
    private PkmAdaptador pkmadaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        // Inicializar lista de Pokémon
        arrayPkm = new ArrayList<>(Arrays.asList(new Pokemon[]{
                new Pokemon("Bulbasaur", "Planta", R.drawable.bulbasaur),
                new Pokemon("Charmander", "Fuego", R.drawable.charmander),
                new Pokemon("Squirtle", "Agua", R.drawable.squirtle),
                new Pokemon("Pidgey", "Normal", R.drawable.pidgey),
                new Pokemon("Zubat", "Veneno", R.drawable.zubat),
                new Pokemon("Geodude", "Roca", R.drawable.geodude),
                new Pokemon("Pikachu", "Electrico", R.drawable.pikachu),
                new Pokemon("Jigglypuff", "Hada", R.drawable.jigglipuf),
                new Pokemon("Machop", "Lucha", R.drawable.machop),
                new Pokemon("Abra", "Psiquico", R.drawable.abra),
        }));

        // Configurar adaptador y RecyclerView
        pkmadaptador = new PkmAdaptador(arrayPkm);
        RecyclerView rv_pkm = view.findViewById(R.id.rv_pkm);
        rv_pkm.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_pkm.setAdapter(pkmadaptador);

        return view;
    }

    public void activarColores(boolean activar) {
        pkmadaptador.activarColores(activar);
    }

    public void mostrarTipo(boolean mostrar) {
        pkmadaptador.mostrarTipo(mostrar);
    }
}
