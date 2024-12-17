package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private PokemonListFragment pokemonListFragment;
    private MedallasFragment medallasFragment;
    private RegionesFragment regionesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            pokemonListFragment = new PokemonListFragment();
            medallasFragment = new MedallasFragment();
            regionesFragment = new RegionesFragment();

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

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pokemon_list", pokemonList);
            pokemonListFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, pokemonListFragment)
                    .commit();
        } else {
            // Recupera los fragmentos existentes
            pokemonListFragment = (PokemonListFragment) fragmentManager.findFragmentByTag("PokemonListFragment");
            medallasFragment = (MedallasFragment) fragmentManager.findFragmentByTag("MedallasFragment");
            regionesFragment = (RegionesFragment) fragmentManager.findFragmentByTag("RegionesFragment");
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_pokemon_list) {
                selectedFragment = pokemonListFragment;
            } else if (item.getItemId() == R.id.nav_medallas) {
                if (medallasFragment == null) {
                    medallasFragment = new MedallasFragment();
                }
                selectedFragment = medallasFragment;
            } else if (item.getItemId() == R.id.nav_regiones) {
                if (regionesFragment == null) {
                    regionesFragment = new RegionesFragment();
                }
                selectedFragment = regionesFragment;
            }

            if (selectedFragment != null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
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