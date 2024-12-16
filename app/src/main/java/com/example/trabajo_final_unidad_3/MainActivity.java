package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private PokemonListFragment pokemonListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Crear la lista de Pokémon
        ArrayList<Pokemon> pokemonList = new ArrayList<>(Arrays.asList(
                new Pokemon("Bulbasaur", "Planta", R.drawable.bulbasaur),
                new Pokemon("Charmander", "Fuego", R.drawable.charmander),
                new Pokemon("Squirtle", "Agua", R.drawable.squirtle),
                new Pokemon("Pidgey", "Normal", R.drawable.pidgey),
                new Pokemon("Zubat", "Veneno", R.drawable.zubat),
                new Pokemon("Geodude", "Roca", R.drawable.geodude),
                new Pokemon("Pikachu", "Electrico", R.drawable.pikachu),
                new Pokemon("Jigglypuff", "Hada", R.drawable.jigglipuf),
                new Pokemon("Machop", "Lucha", R.drawable.machop),
                new Pokemon("Abra", "Psiquico", R.drawable.abra)
        ));

        // Cargar el fragmento con los datos
        if (savedInstanceState == null) {
            pokemonListFragment = new PokemonListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pokemon_list", pokemonList);
            pokemonListFragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, pokemonListFragment)
                    .commit();
        }
    }

    public void onClick(View view) {
        if (pokemonListFragment != null) {
            pokemonListFragment.activarColores(true);
        }
    }

    public void onClick2(View view) {
        if (pokemonListFragment != null) {
            pokemonListFragment.mostrarTipo(true);
        }
    }
}
