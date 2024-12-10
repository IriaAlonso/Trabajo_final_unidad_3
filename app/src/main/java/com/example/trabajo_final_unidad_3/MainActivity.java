package com.example.trabajo_final_unidad_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText);
        Button addFragmentButton = findViewById(R.id.addFragmentButton);

        addFragmentButton.setOnClickListener(v -> {
            String inputText = editText.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("input_text", inputText);
            MyFragment myFragment = new MyFragment();
            myFragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, myFragment);
            transaction.commit();
        });
    }
}
