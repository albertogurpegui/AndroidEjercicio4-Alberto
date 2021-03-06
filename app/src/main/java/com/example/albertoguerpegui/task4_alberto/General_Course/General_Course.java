package com.example.albertoguerpegui.task4_alberto.General_Course;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity.ComunityFragment;
import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.UserDAO;
import com.example.albertoguerpegui.task4_alberto.Data.Repository.UserRepository;
import com.example.albertoguerpegui.task4_alberto.FormData.FormsActivity;
import com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons.ClassFragment;
import com.example.albertoguerpegui.task4_alberto.Login.Login;
import com.example.albertoguerpegui.task4_alberto.Notifications.NotificationFragment;
import com.example.albertoguerpegui.task4_alberto.Notes.NoteFragment;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher.TeacherFragment;
import com.example.albertoguerpegui.task4_alberto.User;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class General_Course extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String USER = "USER";
    private static User user;
    private String mUri, sUserName, sSurname, sEmail;
    private TextView mName, mSurname, mEmail;
    private  ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_course);


        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView =  findViewById(R.id.nav_view);
        LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_general_course_navheader, navigationView);

        navigationView.setNavigationItemSelectedListener(this);
        mImageView = navigationView.findViewById(R.id.imageViewU);
        mName = navigationView.findViewById(R.id.tvtUserName);
        mSurname = navigationView.findViewById(R.id.tvtUserSurname);
        mEmail = navigationView.findViewById(R.id.tvtEmail);
        setTitle("Classes");
        Fragment fragment = new ClassFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_generalcourse, fragment);
        ft.commit();
        /*mRecyclerView = (RecyclerView) findViewById(R.id.class_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerActivity
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);*/
        UserRepository userRepository = new UserRepository(getApplication());
        userRepository.mUser.observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if(user!=null){
                    mUri = user.getUrl();
                    sEmail = user.getEmail();
                    sUserName = user.getName();
                    sSurname = user.getSurname();
                    putInfo();
                }
            }
        });
/*
        user = new User();
       Intent intent_receive = this.getIntent();
        if(intent_receive != null){
            user = intent_receive.getParcelableExtra(Login.USER);
             mUri = user.getUrl();
             sEmail = user.getEmail();
             sUserName = user.getName();
             sSurname = user.getSurname();

        }
        */



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void putInfo(){
        mName.setText(sUserName);
        mSurname.setText(sSurname);
        mEmail.setText(sEmail);

        try {

            if (mUri != null) {

                Uri mUserImage = Uri.parse(mUri);
                final InputStream imageStream = getContentResolver().openInputStream(mUserImage);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                mImageView.setImageBitmap(selectedImage);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }

        //TODO Salir al clicar atrás sin usar Intent
        //NO Conseguido
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        changeFragment(item.getItemId());
        return true;
    }

    public void changeFragment(int id){
        Fragment fragment = null;

        //iniciamos los fragments dependiendo del item selecionado
        switch (id) {
            case R.id.nav_clases:
                setTitle("Lessons");
                fragment = new ClassFragment();
                break;
            case R.id.nav_notificaciones:
                setTitle("Notifications");
                fragment = new NotificationFragment();
                break;
            case R.id.nav_notas:
                setTitle("Marks");
                fragment = new NoteFragment();
                break;
            case R.id.nav_profesores:
                setTitle("Teachers");
                fragment = new TeacherFragment();
                break;
            case R.id.nav_comunidades:
                setTitle("Communities");
                fragment = new ComunityFragment();
                break;
        }

        //Remplazamos el fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_generalcourse, fragment);
            ft.commit();
        }
    }


    public void onclicklogout(MenuItem item) {
        (new General_Course.LogOutAsyncTask(UTADBBDD.INSTANCE)).execute();
        Intent navigate = new Intent(getApplicationContext(), Login.class);
        navigate.setFlags(navigate.FLAG_ACTIVITY_NEW_TASK | navigate.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(navigate);
        finish();
    }

    private static class LogOutAsyncTask extends AsyncTask<Void,Void,Void> {
        public UserDAO userDAO;

        public LogOutAsyncTask(UTADBBDD utadbbdd) {
            userDAO = utadbbdd.userdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDAO.deleteAll();
            return null;
        }
    }
}