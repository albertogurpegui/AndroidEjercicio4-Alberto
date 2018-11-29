package com.example.albertoguerpegui.task4_alberto.FormData;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.albertoguerpegui.task4_alberto.FormData.FragmentFormData.FormDataFrag1;
import com.example.albertoguerpegui.task4_alberto.FormData.FragmentFormData.PersonalDataFrag2;
import com.example.albertoguerpegui.task4_alberto.General_Course.General_Course;
import com.example.albertoguerpegui.task4_alberto.Login.Login;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.User;


public class FormsActivity extends FragmentActivity implements FormDataFrag1.OnFragmentInteractionListener, PersonalDataFrag2.OnFragmentInteractionListener {

    private User user;
    public static final String USER = "USER";
    public static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mContext = getApplicationContext();
        setContentView(R.layout.activity_forms);
        if (findViewById(R.id.pager) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FormDataFrag1 formDataFragment = new FormDataFrag1();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.pager, formDataFragment).commit();
        }

    }


    @Override
    public void frag1tofrag2(View view) {

        PersonalDataFrag2 profileDataFrag2 = new PersonalDataFrag2();
        Bundle args = new Bundle();
        args.putParcelable(USER, user);
        profileDataFrag2.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.pager, profileDataFrag2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static Context getContextOfApplication() {
        return mContext;
    }



    @Override
    public void saveUserData(View view, User user) {
        User mUser;
        mUser = user;
        Intent saveIntent = new Intent(this, General_Course.class);
        saveIntent.putExtra(Login.USER, mUser);
        startActivity(saveIntent);
    }
}