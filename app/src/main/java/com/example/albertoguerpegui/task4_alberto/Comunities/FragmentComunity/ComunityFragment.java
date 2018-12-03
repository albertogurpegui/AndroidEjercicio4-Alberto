package com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.albertoguerpegui.task4_alberto.Comunities.Comunity_FragmentDialog;
import com.example.albertoguerpegui.task4_alberto.Data.Repository.ComunityRepository;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher.TeacherObject;

import java.util.ArrayList;
import java.util.List;

public class ComunityFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ComunityFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewComunity(view);
        configAdaparterComunity();
        return view;
    }
    // Método que configura el recycler view del fragment
    public void configRecyclerViewComunity(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    //Método que configura el adapter del fragment,
    //en este metodo se hace la transicion del fragment al dialog fragmet pasando item como parametro
    public void configAdaparterComunity(){
        ComunityRepository comunityRepository = new ComunityRepository(getActivity().getApplication());
        comunityRepository.mAllComunity.observe(this, new Observer<List<ComunityObject>>() {
            @Override
            public void onChanged(@Nullable List<ComunityObject> comunityObjects) {
                mAdapter = new ComunityAdapter(comunityObjects, new ComunityAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(ComunityObject item) {
                        //Toast.makeText(getActivity(),"Class " + item.getNameclass(),Toast.LENGTH_LONG).show();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                        if (prev != null) {
                            transaction.remove(prev);
                        }
                        transaction.addToBackStack(null);

                        Comunity_FragmentDialog cfd = Comunity_FragmentDialog.newInstance(item);
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
    public void onDetach()   {
        super.onDetach();
    }

    public void onclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("prueba@gmail.com"));
        intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        startActivity(intent.createChooser(intent, "Send email via..."));

    }
}