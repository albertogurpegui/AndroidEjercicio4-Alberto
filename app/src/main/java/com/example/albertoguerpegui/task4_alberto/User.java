package com.example.albertoguerpegui.task4_alberto;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;


public class User implements Parcelable{

    private String email;
    private String name;
    private String surname;
    private String surname2;
    private int age;
    private String address;
    private String postalcode;
    private String city;
    private String phonetype;
    private String phone;
    private String url;
    private String description;
    private String gender;
    private ArrayList hobbies;


    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int birthday) {
        this.age = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList getHobbies() { return hobbies; }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
        Log.d("HBO", hobbies.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(email);
        out.writeString(name);
        out.writeString(surname);
        out.writeString(surname2);
        out.writeInt(age);
        out.writeString(address);
        out.writeString(postalcode);
        out.writeString(city);
        out.writeString(phonetype);
        out.writeString(phone);
        out.writeString(url);
        out.writeString(description);
        out.writeString(gender);
        out.writeList(hobbies);
    }
    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        hobbies = new ArrayList<User>();
        email = in.readString();
        name = in.readString();
        surname = in.readString();
        surname2 = in.readString();
        age = in.readInt();
        address = in.readString();
        postalcode = in.readString();
        city = in.readString();
        phonetype = in.readString();
        phone = in.readString();
        url = in.readString();
        description = in.readString();
        gender = in.readString();
        hobbies = in.readArrayList(User.class.getClassLoader());
    }
}

