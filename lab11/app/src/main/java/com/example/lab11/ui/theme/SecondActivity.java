package com.example.lab11.ui.theme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab11.R;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            // Переход на главную активность
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Закрываем текущую активность
        });

        ListView listView = findViewById(R.id.listViewColors);
        int[] colorValues = getResources().getIntArray(R.array.color_values);
        String[] colorNames = getResources().getStringArray(R.array.color_names);

        ColorAdapter adapter = new ColorAdapter(this, colorNames, colorValues);
        listView.setAdapter(adapter);

        // Обработчик щелчка по элементу списка
        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            int selectedColor = colorValues[position];
            saveBackgroundColor(selectedColor); // Сохраняем цвет в настройки

            // Обновляем фон текущего окна
            getWindow().getDecorView().setBackgroundColor(selectedColor);

        });
    }
}
