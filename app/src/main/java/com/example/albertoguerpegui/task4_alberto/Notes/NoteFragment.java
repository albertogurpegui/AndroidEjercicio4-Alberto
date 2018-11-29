package com.example.albertoguerpegui.task4_alberto.Notes;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albertoguerpegui.task4_alberto.R;


public class NoteFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewNotes(view);
        configAdaparterNotes();

        return view;
    }

    public void configRecyclerViewNotes(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void configAdaparterNotes(){
        mAdapter = new NoteAdapter(createData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public NoteObject[] createData() {
        NoteObject notes1 = new NoteObject("2018/11/19", "Enpresa", "5.00", "Curriculum");
        NoteObject notes2 = new NoteObject("2018/07/21", "IOS", "10.00","Post");
        NoteObject notes3 = new NoteObject("2018/08/14", "GG Empresarial", "7.00","Tabajo Final");
        NoteObject notes4 = new NoteObject("2018/12/30", "Ingles","8.50","Writing");
        NoteObject notes5 = new NoteObject("2018/09/15", "Acceso a datos","7.00","Hibernate");
        NoteObject notes6 = new NoteObject("2018/10/21", "Android","9.00","Singleton");
        NoteObject notes7 = new NoteObject("2018/09/16", "Procesos","4.90","Hilos");

        NoteObject[] data = {notes1,notes2,notes3,notes4,notes5,notes6,notes7};
        return data;
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