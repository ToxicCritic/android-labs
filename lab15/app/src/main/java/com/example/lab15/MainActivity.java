package com.example.lab15;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends MyBaseActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> notesList;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.notesList);
        notesList = new ArrayList<>();

        // Настроим RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter(notesList, (position) -> {
            // Обработка нажатия на элемент списка
            String noteText = notesList.get(position);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_TEXT, noteText);
            intent.putExtra(EXTRA_ID, position);
            startActivityForResult(intent, EDIT_ACTION);
        });
        recyclerView.setAdapter(adapter);

        // Обработка нажатия на кнопку "Add"
        Button btnAdd = findViewById(R.id.addButton);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, CREATE_ACTION);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String newText = data.getStringExtra(EXTRA_TEXT);
            int position = data.getIntExtra(EXTRA_ID, -1);

            switch (requestCode) {
                case CREATE_ACTION:
                    notesList.add(newText); // Добавляем запись в список
                    break;
                case EDIT_ACTION:
                    notesList.set(position, newText); // Редактируем запись по индексу
                    break;
            }
            adapter.notifyDataSetChanged(); // Обновляем адаптер
        }
    }
}
