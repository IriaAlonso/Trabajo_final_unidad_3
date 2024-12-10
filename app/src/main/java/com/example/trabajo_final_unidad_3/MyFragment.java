package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        // Obtén los argumentos del fragmento
        Bundle arguments = getArguments();
        if (arguments != null) {
            String inputText = arguments.getString("input_text", "Sin texto");
            // Establece el texto en el TextView
            TextView textView = view.findViewById(R.id.textView);
            textView.setText(inputText);
        }

        return view;
    }
}
