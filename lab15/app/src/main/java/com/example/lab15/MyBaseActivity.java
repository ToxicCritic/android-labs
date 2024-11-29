package com.example.lab15;

import androidx.appcompat.app.AppCompatActivity;

// MyBaseActivity.java
public class MyBaseActivity extends AppCompatActivity {
    // Константы для действий
    protected static final int CREATE_ACTION = 0x000312;
    protected static final int EDIT_ACTION = 0x000313;

    // Ключи для передачи данных
    protected static final String EXTRA_TEXT = "text";
    protected static final String EXTRA_ID = "id";
}

