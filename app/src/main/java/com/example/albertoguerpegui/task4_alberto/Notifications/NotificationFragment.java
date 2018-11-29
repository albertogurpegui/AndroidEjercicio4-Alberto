package com.example.albertoguerpegui.task4_alberto.Notifications;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albertoguerpegui.task4_alberto.R;


public class NotificationFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotificationFragment() {
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
        mAdapter = new NotificationAdapter(createData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public NotificationObject[] createData() {
        NotificationObject notificaciones1 = new NotificationObject("2018/11/19", "Laura", "Has conseguido un logro");
        NotificationObject notificaciones2 = new NotificationObject("2018/07/21", "Carlos", "Tienes una nota nueva");
        NotificationObject notificaciones3 = new NotificationObject("2018/08/14", "Meritxel", "Has conseguido un logro");
        NotificationObject notificaciones4 = new NotificationObject("2018/12/30", "David","Has mandado una tarea");
        NotificationObject notificaciones5 = new NotificationObject("2018/09/15", "Cristina","Has conseguido un logro");
        NotificationObject notificaciones6 = new NotificationObject("2018/10/21", "Laura","No has enviado la tarea");
        NotificationObject notificaciones7 = new NotificationObject("2018/09/16", "Jaime","No hay clase");
        NotificationObject notificaciones8 = new NotificationObject("2018/10/21", "Pedro","Te has copiado en este ejercicio");
        NotificationObject notificaciones9 = new NotificationObject("2018/09/16", "Yony","No sirves para nada");
        NotificationObject notificaciones10 = new NotificationObject("2018/10/21", "Joaquin","Aprobaste");

        NotificationObject[] data = {notificaciones1,notificaciones2,notificaciones3,notificaciones4,notificaciones5,notificaciones6,notificaciones7,notificaciones8,notificaciones9,notificaciones10};
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