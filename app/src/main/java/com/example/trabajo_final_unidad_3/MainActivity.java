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
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new com.example.trabajo_final_unidad_3.PokemonListFragment()) // Colocamos el fragmento inicial (Rojo)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Lógica de navegación entre los fragmentos
            if (item.getItemId() == R.id.nav_pokemon_list) {
                selectedFragment = new com.example.trabajo_final_unidad_3.PokemonListFragment();
            } else if (item.getItemId() == R.id.nav_medallas) {
                selectedFragment = new com.example.trabajo_final_unidad_3.MedallasFragment();
            } else if (item.getItemId() == R.id.nav_regiones) {
                selectedFragment = new com.example.trabajo_final_unidad_3.RegionesFragment();
            }

            // Reemplazar el fragmento
            if (selectedFragment != null) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_container, selectedFragment); // Reemplaza el fragmento actual
                transaction.addToBackStack(null); // Añadir a la pila de retroceso para permitir la navegación hacia atrás
                transaction.commit();
            }

            return true; // Indicar que el ítem fue seleccionado correctamente
        });

    }

    // Métodos llamados por los botones
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
