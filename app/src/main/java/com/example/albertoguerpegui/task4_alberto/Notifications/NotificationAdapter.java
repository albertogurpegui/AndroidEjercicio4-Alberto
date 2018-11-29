package com.example.albertoguerpegui.task4_alberto.Notifications;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationObject> mDataset;

    public NotificationAdapter(List<NotificationObject> myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recyclerview, viewGroup, false);
        return new NotificationViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder notesViewHolder, final int i) {
        final NotificationObject item = mDataset.get(i);
        notesViewHolder.date.setText(item.getDate());
        notesViewHolder.name.setText(item.getName());
        notesViewHolder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        public TextView date;
        public TextView name;
        public TextView title;

        public NotificationViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.item4);
            name = v.findViewById(R.id.item2);
            date = v.findViewById(R.id.item3);
        }
    }
}
