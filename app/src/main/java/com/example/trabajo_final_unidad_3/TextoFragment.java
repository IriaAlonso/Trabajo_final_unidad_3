package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TextoFragment extends Fragment {

    private static final String ARG_TEXT = "texto";

    public TextoFragment() {
    }

    // Método para crear una nueva instancia del fragmento con el texto
    public static TextoFragment newInstance(String texto) {
        TextoFragment fragment = new TextoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, texto);
        fragment.setArguments(args);
        return fragment;
    }

    // Inflar el layout y configurar el TextView con el texto recibido
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        String texto = getArguments() != null ? getArguments().getString(ARG_TEXT) : "";

        TextView textView = rootView.findViewById(R.id.textView);
        textView.setText(texto);

        return rootView;
    }
}
