package com.example.lab14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonNext = findViewById(R.id.buttonNext);

        // Кнопка для перехода ко второй активности
        buttonNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            // Передаем данные в интент
            intent.putExtra("text1", editText1.getText().toString());
            intent.putExtra("text2", editText2.getText().toString());
            startActivityForResult(intent, 1); // Ожидаем результат
        });
    }

    // Метод для получения данных обратно от второй активности
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Извлекаем переданные данные
                String text1 = data.getStringExtra("text1");
                String text2 = data.getStringExtra("text2");

                // Отображаем данные в EditText
                editText1.setText(text1);
                editText2.setText(text2);
            }
        }
    }
}
