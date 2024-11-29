package com.example.lab11.ui.theme;

import android.os.Bundle;

import com.example.lab11.R;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setWindowBackgroundColor(); // Восстанавливаем цвет фона
    }
}
