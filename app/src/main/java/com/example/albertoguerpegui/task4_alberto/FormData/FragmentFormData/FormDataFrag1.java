package com.example.albertoguerpegui.task4_alberto.FormData.FragmentFormData;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.albertoguerpegui.task4_alberto.Login.Login;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FormDataFrag1 extends Fragment {
    @BindView(R.id.etName) EditText mName;
    @BindView(R.id.etSurname) EditText mSurname;
    @BindView(R.id.etSurname2) EditText mSurname2;
    @BindView(R.id.etBirthday) EditText mBirthday;
    @BindView(R.id.etAddress) EditText mAddress;
    @BindView(R.id.etPostalCode) EditText mPostalCode;
    @BindView(R.id.etCity) EditText mCity;
    @BindView(R.id.spPhoneType) Spinner mPhoneType;
    @BindView(R.id.etPhone) EditText mPhone;
    @BindView(R.id.fABtnNext) FloatingActionButton fabtnNext;
    @BindView(R.id.tilName) TextInputLayout layoutName;
    @BindView(R.id.tilSurname) TextInputLayout layoutSurname;
    @BindView(R.id.tilSurname2) TextInputLayout layoutSurname2;
    @BindView(R.id.tilBirthday) TextInputLayout layoutBirthday;
    @BindView(R.id.tilAddress) TextInputLayout layoutAddress;
    @BindView(R.id.tilPostalCode) TextInputLayout layoutPostalCode;
    @BindView(R.id.tilCity) TextInputLayout layoutCity;
    @BindView(R.id.tilPhone) TextInputLayout layoutPhone;
    @BindView(R.id.btnclearDate) Button btnClearDate;



    private User user;


    private String name;

    private String surname;

    private String surname2;

    private String birthday;

    private String address;

    private String postalCode;

    private String city;

    private String phone;

    private FormDataFrag1.OnFragmentInteractionListener mListener;

    public FormDataFrag1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_form_data, container, false);


        //Creación ButterKnife
        ButterKnife.bind(this, mView);
        fabtnNext.setEnabled(false);

        user = new User();
        Intent intent_receive = getActivity().getIntent();
        if (intent_receive != null) {
            user =  intent_receive.getParcelableExtra(Login.USER);
        }

        textListener();
        onClickbirthday();
        clearDate();
        onClickedNext();
        return mView;
    }


    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };


    public void textListener() {

        mName.addTextChangedListener(enableButtonNext);
        mSurname.addTextChangedListener(enableButtonNext);
        mSurname2.addTextChangedListener(enableButtonNext);
        mBirthday.addTextChangedListener(enableButtonNext);
        mAddress.addTextChangedListener(enableButtonNext);
        mPostalCode.addTextChangedListener(enableButtonNext);
        mCity.addTextChangedListener(enableButtonNext);
        mPhone.addTextChangedListener(enableButtonNext);

    }

    public TextWatcher enableButtonNext = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            name = mName.getText().toString();
            surname = mSurname.getText().toString();
            surname2 = mSurname2.getText().toString();
            address = mAddress.getText().toString();
            birthday = mBirthday.getText().toString();
            postalCode = mPostalCode.getText().toString();
            city = mCity.getText().toString();
            mPhoneType.getSelectedItem();
            phone = mPhone.getText().toString();

            if (!name.isEmpty()) {
                layoutName.setHelperText(" ");
            }
            if (!surname.isEmpty()) {
                layoutSurname.setHelperText(" ");
            }
            if (!surname2.isEmpty()) {
                layoutSurname2.setHelperText(" ");
            }
            if (!address.isEmpty()) {
                layoutAddress.setHelperText(" ");
            }
            if (!birthday.isEmpty()) {
                layoutBirthday.setHelperText(" ");
            }
            if (!postalCode.isEmpty()) {
                layoutPostalCode.setHelperText(" ");
            }
            if (!city.isEmpty()) {
                layoutCity.setHelperText(" ");
            }
            if (!phone.isEmpty()) {
                layoutPhone.setHelperText(" ");
            }

            fabtnNext.setEnabled(enableButton());

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public boolean enableButton() {
        //Todo ignorar el Warning (no es aplicable a este caso)
        if (!name.isEmpty() || !surname.isEmpty() || !surname2.isEmpty() || !birthday.isEmpty() || !address.isEmpty() ||
                !postalCode.isEmpty() || !city.isEmpty() || !phone.isEmpty()) {

            return true;
        } else {

            return false;
        }

    }

    public boolean allDone() {
        //Todo ignorar el Warning (no es aplicable a este caso)
        if (!name.isEmpty() && !surname.isEmpty() && !surname2.isEmpty() && !birthday.isEmpty() && !address.isEmpty() &&
                !postalCode.isEmpty() && !city.isEmpty() && !phone.isEmpty()) {

            return true;
        } else {

            return false;
        }

    }

    public void textListenerError() {
        if (name.equals("")) {
            layoutName.setHelperTextEnabled(true);
            layoutName.setError("You forgot to write your " + layoutName.getHint());
        }

        if (surname.equals("")) {
            layoutSurname.setHelperTextEnabled(true);
            layoutSurname.setError("You forgot to write your \n" + layoutSurname.getHint());
        }
        if (surname2.equals("")) {
            layoutSurname2.setHelperTextEnabled(true);
            layoutSurname2.setError("You forgot to write your " + layoutSurname2.getHint());
        }
        if (birthday.equals("")) {
            layoutBirthday.setHelperTextEnabled(true);
            layoutBirthday.setError("You forgot to write your " + layoutBirthday.getHint());
        }
        if (address.equals("")) {
            layoutAddress.setHelperTextEnabled(true);
            layoutAddress.setError("You forgot to write your " + layoutAddress.getHint());
        }
        if (postalCode.equals("")) {
            layoutPostalCode.setHelperTextEnabled(true);
            layoutPostalCode.setError("You forgot to write your " + layoutPostalCode.getHint());
        }
        if (city.equals("")) {
            layoutCity.setHelperTextEnabled(true);
            layoutCity.setError("You forgot to write your " + layoutCity.getHint());
        }
        if (phone.equals("")) {
            layoutPhone.setHelperTextEnabled(true);
            layoutPhone.setError("You forgot to write your " + layoutPhone.getHint());
        }
    }

    //Botón de reseteo de Birthday
    public void clearDate() {
        btnClearDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBirthday.setText("");
            }
        });
    }

    public void onClickedNext() {
        fabtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (enableButton()) {
                    textListenerError();

                }

                if (allDone()) {
                    user.setName(mName.getText().toString());
                    user.setSurname(mSurname.getText().toString());
                    user.setSurname2(mSurname2.getText().toString());
                    user.setAddress(mAddress.getText().toString());
                    user.setPostalcode(mPostalCode.getText().toString());
                    user.setCity(mCity.getText().toString());
                    user.setPhonetype(mPhoneType.getSelectedItem().toString());
                    user.setPhone(mPhone.getText().toString());

                    if (mListener != null) {
                        mListener.frag1tofrag2(v);
                    }
                }
            }
        });
                 
    }


    //Llamada al Dialog de Fecha
    public void onClickbirthday() {
        mBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(getLayoutInflater().getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    //Setea la Fecha escogida con el Formato escogido en el EditText Birthday
    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mBirthday.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    //
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

    public interface OnFragmentInteractionListener {
        
         void frag1tofrag2(View view);
    }
}
