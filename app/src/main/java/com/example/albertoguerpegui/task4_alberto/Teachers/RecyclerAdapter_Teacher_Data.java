package com.example.albertoguerpegui.task4_alberto.Teachers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;


public class RecyclerAdapter_Teacher_Data extends RecyclerView.Adapter<RecyclerAdapter_Teacher_Data.MyViewHolder> {
    private CardView_Teacher_Data[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImagenView;

        public MyViewHolder(View v) {
            super(v);
            mTextView =  v.findViewById(R.id.professor_Name);
            mImagenView = v.findViewById(R.id.profesor_Photo);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerAdapter_Teacher_Data(CardView_Teacher_Data[] myDataset) { mDataset = myDataset; }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RecyclerAdapter_Teacher_Data.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_recycler_professor_data, parent, false);
        return new MyViewHolder(rootView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        CardView_Teacher_Data item = mDataset [position];
        holder.mTextView.setText(item.getNames_subject());
        holder.mImagenView.setImageDrawable(item.getPhotos_subject());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
