package com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.albertoguerpegui.task4_alberto.Comunities.Comunity_FragmentDialog;
import com.example.albertoguerpegui.task4_alberto.R;

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
        mAdapter = new ComunityAdapter(createData(), new ComunityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ComunityObject item) {
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
    //Lista de datos del fragment
    public List<ComunityObject> createData() {
        ComunityObject cibersegurity = new ComunityObject("Cibersegurity",R.drawable.basedatos, "CiberSegurity Topic","CiberSegurity Community", "Daniel Lopez");
        ComunityObject development = new ComunityObject("Development", R.drawable.android, "Development Topic", "Development Community", "Jaime La torre");
        ComunityObject big_data = new ComunityObject("Big Data", R.drawable.fct, "Big Data Topic", "Big Data Community", "Pedro Camacho");
        ComunityObject videogames = new ComunityObject("Videogames", R.drawable.computing, "VideoGames Topic", "VideoGames Community", "Jhonny");
        List<ComunityObject> data = new ArrayList<>();
        data.add(cibersegurity);
        data.add(development);
        data.add(big_data);
        data.add(videogames);
        return data;
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