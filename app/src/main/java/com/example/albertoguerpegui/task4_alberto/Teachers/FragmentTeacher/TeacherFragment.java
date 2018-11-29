package com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.Teachers.Teacher_FragmentDialog;

import java.util.ArrayList;
import java.util.List;

public class TeacherFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TeacherFragment() {
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
        mAdapter = new TeacherAdapter(createData(), new TeacherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TeacherObject item) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);

                Teacher_FragmentDialog cfd = Teacher_FragmentDialog.newInstance(item);
                cfd.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
    //Lista de datos del fragment
    public List<TeacherObject> createData() {
        TeacherObject pedro = new TeacherObject("Pedro",R.drawable.pedro, "Camacho", "Computing expert");
        TeacherObject jaime = new TeacherObject("Jaime", R.drawable.jaime, "La Torre","Database expert");
        TeacherObject laura = new TeacherObject("Laura", R.drawable.laura, "Jaen", "OpenERP expert");
        TeacherObject meritxell = new TeacherObject("Meritxell", R.drawable.meritxel,"Bretos", "Company expert");
        TeacherObject david = new TeacherObject("David", R.drawable.david, "Jardon", "Adroid expert");
        TeacherObject cristina = new TeacherObject("Cristina",R.drawable.cristina, "Espinosa", "English expert");
        TeacherObject dani = new TeacherObject("Daniel", R.drawable.daniel_lopez, "Lopez", "TFG expert");
        TeacherObject carlos = new TeacherObject("Carlos", R.drawable.carlos, "Jimenez", "IOS expert");
        List<TeacherObject> data = new ArrayList<>();
        data.add(pedro);
        data.add(jaime);
        data.add(meritxell);
        data.add(david);
        data.add(laura);
        data.add(cristina);
        data.add(dani);
        data.add(carlos);
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