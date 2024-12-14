package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        // Cargar el fragmento de la lista de Pokémon
        pokemonListFragment = new PokemonListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, pokemonListFragment)
                .commit();
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
