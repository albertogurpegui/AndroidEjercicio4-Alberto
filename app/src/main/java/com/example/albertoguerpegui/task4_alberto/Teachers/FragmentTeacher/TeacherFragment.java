package com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher;

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

import com.example.albertoguerpegui.task4_alberto.Data.Repository.TeacherRepository;
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
        configAdaparterTeacher();
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
    public void configAdaparterTeacher(){
        TeacherRepository teacherRepository = new TeacherRepository(getActivity().getApplication());
        teacherRepository.mAllTeacher.observe(this, new Observer<List<TeacherObject>>() {
            @Override
            public void onChanged(@Nullable List<TeacherObject> classObjects) {
                mAdapter = new TeacherAdapter(classObjects, new TeacherAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(TeacherObject item) {
                        //Toast.makeText(getActivity(),"Class " + item.getNameclass(),Toast.LENGTH_LONG).show();
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