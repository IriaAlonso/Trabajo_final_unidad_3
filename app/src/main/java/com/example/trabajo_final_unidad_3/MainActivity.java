package com.example.trabajo_final_unidad_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // Declaracio de variables globales
    private ArrayList<Pokemon> arrayPkm;
    private PkmAdaptador pkmadaptador;
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
        // Lista pokemon
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
        // Configura el adaptador y lo asigna al recicleVIEW
        pkmadaptador = new PkmAdaptador(arrayPkm);
        RecyclerView rv_pkm = findViewById(R.id.rv_pkm);
        rv_pkm.setLayoutManager(new LinearLayoutManager(this));
        rv_pkm.setAdapter(pkmadaptador);

        TabLayout tl = findViewById(R.id.tab);
        tl.addTab(tl.newTab().setText("Pokemon"));
        tl.addTab(tl.newTab().setText("Regiones"));
        tl.addTab(tl.newTab().setText("Medallas"));
        final int[] previousTabPosition = {-1};
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main), "Proximamente...", Snackbar.LENGTH_LONG);
                snackbar.setAction("Deshacer", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Acción al hacer clic en "Deshacer"
                    }
                });
                snackbar.show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    // Metodo llamado cuando se presiona el boton que muestra los colores
    public void onClick(View view) {
        pkmadaptador.activarColores(true);

    }
    // Metodo llamado cuando se presiona el boton que muestra el tipo
    public void onClick2(View view) {
        pkmadaptador.mostrarTipo(true);
    }



}