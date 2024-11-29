package com.example.lab13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // Устанавливаем слушатель для изменения текста
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Можно оставить пустым
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, есть ли текст в EditText
                String inputText = s.toString().trim(); // Убираем пробелы по краям

                // Если в EditText есть текст, то делаем кнопку доступной
                if (inputText.length() > 0) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Можно оставить пустым
            }
        });

        // Обработчик нажатия на кнопку
        button.setOnClickListener(v -> {
            // Копируем содержимое EditText в TextView
            String text = editText.getText().toString().trim();
            textView.setText(text);
        });
    }
}
