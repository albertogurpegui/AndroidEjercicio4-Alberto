package com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albertoguerpegui.task4_alberto.Data.Repository.LessonRepository;
import com.example.albertoguerpegui.task4_alberto.Lessons.Class_FragmentDialog;
import com.example.albertoguerpegui.task4_alberto.R;

import java.util.ArrayList;
import java.util.List;

public class ClassFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ClassFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewClass(view);
        configAdaparterClass();
        return view;
    }
    // Método que configura el recycler view del fragment
    public void configRecyclerViewClass(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    //Método que configura el adapter del fragment,
    //en este metodo se hace la transicion del fragment al dialog fragmet pasando item como parametro
    public void configAdaparterClass(){
        LessonRepository lessonRepository = new LessonRepository(getActivity().getApplication());
        lessonRepository.mAllClass.observe(this, new Observer<List<ClassObject>>() {
            @Override
            public void onChanged(@Nullable List<ClassObject> classObjects) {
                mAdapter = new ClassAdapter(classObjects, new ClassAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(ClassObject item) {
                        //Toast.makeText(getActivity(),"Class " + item.getNameclass(),Toast.LENGTH_LONG).show();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                        if (prev != null) {
                            transaction.remove(prev);
                        }
                        transaction.addToBackStack(null);

                        Class_FragmentDialog cfd = Class_FragmentDialog.newInstance(item);
                        cfd.show(transaction, "dialog");
                    }
                });
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}