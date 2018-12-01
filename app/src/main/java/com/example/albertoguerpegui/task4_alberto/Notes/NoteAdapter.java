package com.example.albertoguerpegui.task4_alberto.Notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<NoteObject> mDataset;

    public NoteAdapter(List<NoteObject> myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recyclerview, viewGroup, false);
        return new NoteViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder notesViewHolder, final int i) {
        final NoteObject item = mDataset.get(i);
        notesViewHolder.date.setText(item.getDate());
        notesViewHolder.clases.setText(item.getClasses());
        notesViewHolder.title.setText(item.getExercise());
        notesViewHolder.note.setText(item.getNotes());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView date;
        public TextView clases;
        public TextView title;
        public TextView note;

        public NoteViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.item4);
            clases = v.findViewById(R.id.item2);
            date = v.findViewById(R.id.item3);
            note = v.findViewById(R.id.item1);
            note.setVisibility(View.VISIBLE);
        }
    }
}
