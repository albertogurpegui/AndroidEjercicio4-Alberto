package com.example.albertoguerpegui.task4_alberto.FormData.FragmentFormData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.albertoguerpegui.task4_alberto.FormData.FormsActivity;
import com.example.albertoguerpegui.task4_alberto.Login.Login;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.User;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

public class PersonalDataFrag2 extends Fragment {
    @BindView(R.id.imageView) CircularImageView mImage;
    @BindView(R.id.textViewN) TextView mName;
    @BindView(R.id.textViewS) TextView mSurname;
    @BindView(R.id.etDescripccion) EditText mDescription;
    @BindView(R.id.radio_boys) RadioButton mRadioMale;
    @BindView(R.id.radio_girls) RadioButton mRadioFemale;
    @BindView(R.id.ch_cinema) CheckBox mCinema;
    @BindView(R.id.ch_walk) CheckBox mWalk;
    @BindView(R.id.ch_play_music) CheckBox mPlayMusic;
    @BindView(R.id.tilDescription) TextInputLayout layoutDescription;
    @BindView(R.id.tilGender) TextInputLayout layoutGender;
    @BindView(R.id.tilHobbies) TextInputLayout layoutHobbies;
    @BindView(R.id.fabtnOK) FloatingActionButton fabtnOK;


    private ArrayList<String> hobbies = new ArrayList<String>();
    private User user;
    public static final String USER = "USER";
    private String sImageRef;
    private PersonalDataFrag2.OnFragmentInteractionListener mListener;

    public PersonalDataFrag2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        View mView =  inflater.inflate(R.layout.fragment_personal_data, container, false);

        ButterKnife.bind(this, mView);
        user = new User();
        onClickedImage();
        onClickedOk();


        Intent a = getActivity().getIntent();
        if (a != null) {
            user = (User) a.getParcelableExtra(Login.USER);
            mName.setText(user.getName());
            mSurname.setText(user.getSurname());
        }
        mImage = mView.findViewById(R.id.imageView);


        return mView;
    }

    public void onClickedImage() {
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Context mContext = FormsActivity.getContextOfApplication();
        if (resultCode == RESULT_OK) {
            try {

                Uri imageUri = data.getData();
                final InputStream imageStream = mContext.getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                mImage.setImageBitmap(selectedImage);

                if (imageUri != null) {
                    sImageRef = imageUri.toString();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(FormsActivity.getContextOfApplication(), "Something went wrong", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(FormsActivity.getContextOfApplication(), "You haven't picked any Image", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickedOk() {
        fabtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se igualan los campos de texto a sus variables correspondientes
                String description = mDescription.getText().toString();
                String gender = "";
                if (description.equals("")) {
                    layoutDescription.setHelperTextEnabled(true);

                } else {
                    layoutDescription.setHelperTextEnabled(false);
                    layoutDescription.setHelperText("");
                }
                if (mRadioMale.isChecked()) {
                    gender = mRadioMale.getText().toString();
                    layoutGender.setHelperTextEnabled(false);
                    layoutGender.setHelperText("");
                } else if (mRadioFemale.isChecked()) {
                    gender = mRadioFemale.getText().toString();
                    layoutGender.setHelperTextEnabled(false);
                    layoutGender.setHelperText("");
                } else {
                    layoutGender.setHelperTextEnabled(true);
                    layoutGender.setError("You have to selected a Gender");
                }
                if (mCinema.isChecked()) {
                    hobbies.add(mCinema.getText().toString());
                }
                if (mWalk.isChecked()) {
                    hobbies.add(mWalk.getText().toString());
                }
                if (mPlayMusic.isChecked()) {
                    hobbies.add(mPlayMusic.getText().toString());
                }

                if (!mCinema.isChecked() && !mWalk.isChecked() && !mPlayMusic.isChecked()) {
                    layoutHobbies.setHelperTextEnabled(true);
                }else {
                    layoutGender.setHelperText("");
                }
                if (!gender.equals("")) {

                    if (mListener != null) {
                        user.setUrl(sImageRef);
                        user.setDescription(description);
                        user.setGender(gender);
                        user.setHobbies(hobbies);
                        mListener.saveUserData(v, user);

                    }

                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PersonalDataFrag2.OnFragmentInteractionListener) {
            mListener = (PersonalDataFrag2.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
         void saveUserData(View view, User user);
    }
}