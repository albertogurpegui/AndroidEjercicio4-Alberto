package com.example.albertoguerpegui.task4_alberto.Notes;


import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albertoguerpegui.task4_alberto.Data.Repository.NoteRepository;
import com.example.albertoguerpegui.task4_alberto.R;

import java.util.List;


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

    public void configRecyclerViewNotes(View view) {
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void configAdaparterNotes() {
        NoteRepository noteRepository = new NoteRepository(getActivity().getApplication());
        noteRepository.mAllNote.observe(this, new Observer<List<NoteObject>>() {
            @Override
            public void onChanged(@Nullable List<NoteObject> noteObjects) {
                mAdapter = new NoteAdapter(noteObjects);
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
