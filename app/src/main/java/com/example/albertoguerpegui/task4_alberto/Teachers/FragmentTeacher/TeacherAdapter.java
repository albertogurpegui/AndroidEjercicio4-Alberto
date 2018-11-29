package com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.professorViewHolder> {

    private List<TeacherObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(TeacherObject item);
    }


    public TeacherAdapter(List<TeacherObject> myDataset, TeacherAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public TeacherAdapter.professorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new professorViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(professorViewHolder professorViewHolder, int i) {
        final TeacherObject item = mDataset.get(i);
        professorViewHolder.textView.setText(item.getNameprofessor());
        professorViewHolder.imageView.setImageResource(item.getImgprofessor());
        professorViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(item);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class professorViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public professorViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
            imageView = v.findViewById(R.id.imageViewitem);
        }
    }
}
