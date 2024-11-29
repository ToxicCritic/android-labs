package com.example.lab14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button buttonOk;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonOk = findViewById(R.id.buttonOk);
        buttonCancel = findViewById(R.id.buttonCancel);

        // Получаем данные из Intent
        Intent intent = getIntent();
        String text1 = intent.getStringExtra("text1");
        String text2 = intent.getStringExtra("text2");

        // Отображаем их в EditText
        editText1.setText(text1);
        editText2.setText(text2);

        // Обработка нажатия на кнопку OK
        buttonOk.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            // Передаем измененные данные обратно в MainActivity
            resultIntent.putExtra("text1", editText1.getText().toString());
            resultIntent.putExtra("text2", editText2.getText().toString());
            setResult(RESULT_OK, resultIntent); // Возвращаем результат
            finish(); // Закрываем вторую активность
        });

        // Обработка нажатия на кнопку Cancel
        buttonCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); // Возвращаем отмену
            finish(); // Закрываем вторую активность
        });
    }
}
