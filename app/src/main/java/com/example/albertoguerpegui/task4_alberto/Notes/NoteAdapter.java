package com.example.albertoguerpegui.task4_alberto.Notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotificationViewHolder> {

    private NoteObject[] mDataset;

    public NoteAdapter(NoteObject[] myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recyclerview, viewGroup, false);
        return new NotificationViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder notesViewHolder, final int i) {
        final NoteObject item = mDataset[i];
        notesViewHolder.date.setText(item.getDate());
        notesViewHolder.classes.setText(item.getClasses());
        notesViewHolder.exercise.setText(item.getExercise());
        if (notesViewHolder.note.getText()!=null){
            notesViewHolder.note.setVisibility(View.VISIBLE);
            notesViewHolder.note.setText(item.getNotes());
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        public TextView date;
        public TextView classes;
        public TextView note;
        public TextView exercise;

        public NotificationViewHolder(View v) {
            super(v);
            note = v.findViewById(R.id.item1);
            classes = v.findViewById(R.id.item2);
            date = v.findViewById(R.id.item3);
            exercise = v.findViewById(R.id.item4);
        }
    }
}
