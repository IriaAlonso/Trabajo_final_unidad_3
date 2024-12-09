package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.editTextInput);
    }

    // Método que se ejecuta cuando se presiona el botón
    public void onCrearFragmento(View view) {
        String texto = editTextInput.getText().toString();

        if (!texto.isEmpty()) {
            // Crear el fragmento con el texto
            TextoFragment textFragment = TextoFragment.newInstance(texto);

            // Reemplazar el contenido del contenedor con el nuevo fragmento
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor_fragment, textFragment)
                    .commit();
        } else {
            Toast.makeText(this, "Campo vacío inválido >:[", Toast.LENGTH_SHORT).show();
        }
    }
}
