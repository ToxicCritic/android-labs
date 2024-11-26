package com.example.lab11.ui.theme;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab11.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String[] colorNames = getResources().getStringArray(R.array.color_names);
        int[] colorValues = getResources().getIntArray(R.array.color_values);

        ColorAdapter adapter = new ColorAdapter(this, colorNames, colorValues);
        ListView listView = findViewById(R.id.listViewColors);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            int selectedColor = (int) adapter.getItem(position);
            SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("backgroundColor", selectedColor);
            editor.apply();

            getWindow().getDecorView().setBackgroundColor(selectedColor);
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
