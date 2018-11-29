package com.example.albertoguerpegui.task4_alberto.Comunities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity.ComunityObject;
import com.example.albertoguerpegui.task4_alberto.R;

import java.util.Objects;

public class Comunity_FragmentDialog extends DialogFragment {

    private ImageView logo;
    private TextView description;
    private TextView title_comunity;
    private TextView name_comunity;
    private TextView text_description;
    private TextView topic_name;
    private DrawerLayout drawer;
    private RecyclerView recycle;
    private RecyclerView.Adapter mAdapterComunity;
    private RecyclerView.LayoutManager mLayoutManagerComunity;
    private FloatingActionButton my_fab;
    private ComunityObject item;
    public static final String COMUNITY = "COMUNITY";
    //Método para recoger el objeto que lo pasas como parametro en el fragment
    //Creo un nuevo dialogo para poner los argumentos del objeton en el dialogo creado
    public static Comunity_FragmentDialog newInstance(ComunityObject comunityObject) {
        Comunity_FragmentDialog dialog = new Comunity_FragmentDialog();
        Bundle data = new Bundle();
        data.putParcelable(COMUNITY,comunityObject);
        dialog.setArguments(data);
        return dialog;
    }
    //Aqui recoges los argumentos del objeto y se los igualas al objeto del dialog fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(COMUNITY);
        }
    }
    //En estas lineas de codigo se crea el AlertDialog poniendo los datos del cardview y del objeto anteriormente escogido
    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_comunity__fragment_dialog, null);
        CardView_Comunity_Data num_alumComunity = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Nº Students");
        CardView_Comunity_Data classroom = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Classroom");
        CardView_Comunity_Data events = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Events");
        CardView_Comunity_Data projects = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Projects");
        CardView_Comunity_Data valuation = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null), "Valuation");
        CardView_Comunity_Data[] elements = {num_alumComunity,classroom,events,projects,valuation};
        builder.setView(view).setPositiveButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:community@u-tad.com"));
                startActivity(Intent.createChooser(emailIntent,"Send Email via..."));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {


                    }
                });
        title_comunity = view.findViewById(R.id.title_Comunity);
        name_comunity = view.findViewById(R.id.name_comunity);
        logo = view.findViewById(R.id.imgcomunity);
        topic_name = view.findViewById(R.id.title_topic);
        recycle = view.findViewById(R.id.recyclerViewComunity);
        description = view.findViewById(R.id.description);
        text_description = view.findViewById(R.id.text_desc);
        mLayoutManagerComunity = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(mLayoutManagerComunity);
        updateDialog(item);
        mAdapterComunity = new RecyclerAdapter_Comunity_Data(elements);
        recycle.setAdapter(mAdapterComunity);
        my_fab = view.findViewById(R.id.my_fab);

        return builder.create();
    }
    //En este método se ponen los datos del item en los textview y en la imageview
    public void updateDialog(ComunityObject item){
        if (item!=null) {
            name_comunity.setText(item.getNamecomunity());
            logo.setImageResource(item.getImgcomunity());
            text_description.setText(item.getTextDescriptionCommunity());
            topic_name.setText(item.getTopicCommunity());
            title_comunity.setText(item.getCordinator());
        }
    }



}
