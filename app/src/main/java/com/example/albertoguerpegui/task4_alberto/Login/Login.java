package com.example.albertoguerpegui.task4_alberto.Login;


import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.albertoguerpegui.task4_alberto.Data.Repository.UserRepository;
import com.example.albertoguerpegui.task4_alberto.FormData.FormsActivity;
import com.example.albertoguerpegui.task4_alberto.General_Course.General_Course;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.User;


public class Login extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private TextInputLayout mTilEmail, mTilPass;
    private Button login;
    private User user;
    public static String USER = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        user = new User();
        mEmail = findViewById(R.id.etEmail);
        mPassword = findViewById(R.id.etPass);
        mTilEmail = findViewById(R.id.tilEmail);
        mTilPass = findViewById(R.id.tilPass);
        checkButon();

        UserRepository userRepository = new UserRepository(getApplication());
        userRepository.mUser.observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null){
                    Intent saveIntent = new Intent(getApplicationContext(), General_Course.class);
                    startActivity(saveIntent);
                }
            }
        });

    }


    public void login() {
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();


            }
        });

    }

    public void checkButon() {

        mEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                //Actualización del estado del botón según los datos introducidos en los EditText

                if (mEmail.getText().toString().isEmpty() || mPassword.getText().toString().isEmpty()) {
                    login.setEnabled(false);


                } else {

                    login.setEnabled(true);
                }



            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                //No es necesario

            }

            @Override
            public void afterTextChanged(Editable s) {

                // TODO Auto-generated method stub
                //No es necesario

            }
        });
        mPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                //Actualización del estado del botón según los datos introducidos en los EditText

                if (mPassword.getText().toString().isEmpty() || mEmail.getText().toString().isEmpty()) {
                    login.setEnabled(false);

                } else {
                    login.setEnabled(true);
                }


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                //No es necesario

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                //No es necesario

            }
        });
        login();
    }

    public void checkLogin() {
        //login ok

        Intent navigate = new Intent(Login.this, FormsActivity.class);

        user.setEmail(mEmail.getText().toString());
        navigate.putExtra(Login.USER, user);


        if (checkEmail() && checkPass()) {

           startActivity(navigate);
        }

        if (checkEmail() && !checkPass()) {
            mTilEmail.setHelperText(" ");
            mTilPass.setError("Enter a password greater than 6 characters");
        }else{

            mTilPass.setHelperText(" ");
        }


        //email incorrecto y pass iconrrecta
        int user = mEmail.getText().toString().trim().length();
        int pass = mPassword.getText().toString().trim().length();
        if (!checkEmail() || !checkPass() || user == 0) {

            if (!checkEmail()) {
                mTilEmail.setError("Email NOT Valid");
            }

            if (user == 0) {
                mTilEmail.setError("Enter a Email");
            }

            if (pass == 0) {
                mTilPass.setError("Enter a password");
            } else if (pass < 6 && pass > 0) {
                mTilPass.setError("Enter a password greater than 6 characters");

            }


        }
    }

    private boolean checkPass() {
        int pass = mPassword.getText().toString().trim().length();
        if (pass >= 6 ) {
            return true;
        }
        return false;
    }


    private boolean checkEmail() {
        String emailAddress = mEmail.getText().toString().trim();
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            return true;
        } else {

            return false;
        }
    }


}