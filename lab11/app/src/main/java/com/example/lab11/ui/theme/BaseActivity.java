package com.example.lab11.ui.theme;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "ColorPrefs";
    public static final String KEY_COLOR = "background_color";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowBackgroundColor();
    }

    // Метод для восстановления цвета фона из настроек
    protected void setWindowBackgroundColor() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int color = preferences.getInt(KEY_COLOR, 0xFFFFFFFF); // Белый цвет по умолчанию
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setBackgroundColor(color);
        }
    }

    // Метод для сохранения цвета в настройки
    protected void saveBackgroundColor(int color) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_COLOR, color);
        editor.apply();
    }
}
