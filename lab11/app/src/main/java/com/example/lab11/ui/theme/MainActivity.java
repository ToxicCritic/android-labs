package com.example.lab11.ui.theme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab11.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChooseColor = findViewById(R.id.btnChooseColor);
        btnChooseColor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        Button btnOpenThirdActivity = findViewById(R.id.btnOpenThirdActivity);
        btnOpenThirdActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setWindowBackgroundColor(); // Восстанавливаем цвет фона
    }
}
