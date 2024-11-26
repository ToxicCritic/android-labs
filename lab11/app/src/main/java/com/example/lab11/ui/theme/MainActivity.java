package com.example.lab11.ui.theme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab11.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChooseColor = findViewById(R.id.btnChooseColor);
        btnChooseColor.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        int color = preferences.getInt("backgroundColor", 0xFFFFFFFF); // Белый по умолчанию
        getWindow().getDecorView().setBackgroundColor(color);
    }

}
