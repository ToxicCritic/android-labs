package com.example.lab15;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends MyBaseActivity {

    private EditText editText;
    private Button btnOK;
    private Button btnCancel;
    private int itemPosition = -1; // Позиция элемента для редактирования, по умолчанию -1 (новая запись)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editText);
        btnOK = findViewById(R.id.btnOK);
        btnCancel = findViewById(R.id.btnCancel);

        // Получаем данные из Intent (если передано)
        Intent intent = getIntent();
        String text = intent.getStringExtra(EXTRA_TEXT);
        if (text != null) {
            editText.setText(text);
            itemPosition = intent.getIntExtra(EXTRA_ID, -1); // Получаем позицию записи для редактирования
        }

        // Добавляем обработчик изменения текста, чтобы активировать/деактивировать кнопку OK
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnOK.setEnabled(s.length() > 0); // Кнопка OK доступна только при наличии текста
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Обработка нажатия на кнопку OK
        btnOK.setOnClickListener(v -> {
            String updatedText = editText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_TEXT, updatedText);
            resultIntent.putExtra(EXTRA_ID, itemPosition);
            setResult(RESULT_OK, resultIntent); // Возвращаем данные в MainActivity
            finish(); // Закрываем текущую активность
        });

        // Обработка нажатия на кнопку Cancel
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); // Если нажали "Отменить", ничего не передаем
            finish(); // Закрываем текущую активность
        });
    }
}
