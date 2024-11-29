package com.example.lab15;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<String> notesList;
    private OnNoteClickListener listener;

    public NotesAdapter(List<String> notesList, OnNoteClickListener listener) {
        this.notesList = notesList;
        this.listener = listener;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.noteText.setText(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteText;

        public NoteViewHolder(View itemView) {
            super(itemView);
            noteText = itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(v -> listener.onNoteClick(getAdapterPosition()));
        }
    }

    public interface OnNoteClickListener {
        void onNoteClick(int position);
    }
}
