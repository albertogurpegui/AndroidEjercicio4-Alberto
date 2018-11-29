package com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;

public class ComunityAdapter extends RecyclerView.Adapter<ComunityAdapter.ComunityViewHolder> {

    private List<ComunityObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ComunityObject item);
    }


    public ComunityAdapter(List<ComunityObject> myDataset, ComunityAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public ComunityAdapter.ComunityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ComunityViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ComunityViewHolder comunityViewHolder, int i) {
        final ComunityObject item = mDataset.get(i);
        comunityViewHolder.textView.setText(item.getNamecomunity());
        comunityViewHolder.imageView.setImageResource(item.getImgcomunity());
        comunityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(item);
                }
            }
        });
    }



    @Override
    public int getItemCount()    {
        return 4;
    }

    static class ComunityViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public ComunityViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
            imageView = v.findViewById(R.id.imageViewitem);
        }

        public void bind(final ComunityObject item, final OnItemClickListener listener) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
