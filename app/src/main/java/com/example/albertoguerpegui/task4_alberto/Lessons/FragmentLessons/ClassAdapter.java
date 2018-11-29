package com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    private List<ClassObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ClassObject item);
    }


    public ClassAdapter(List<ClassObject> myDataset, ClassAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public ClassAdapter.ClassViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ClassViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder classViewHolder, int i) {
        final ClassObject item = mDataset.get(i);
        classViewHolder.textView.setText(item.getNameclass());
        classViewHolder.imageView.setImageResource(item.getImgclass());
        classViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    static class ClassViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public ClassViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
            imageView = v.findViewById(R.id.imageViewitem);
        }
    }
}
