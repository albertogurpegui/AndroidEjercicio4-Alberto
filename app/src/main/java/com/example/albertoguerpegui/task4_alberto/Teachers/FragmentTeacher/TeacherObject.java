package com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher;

import android.os.Parcel;
import android.os.Parcelable;

public class TeacherObject implements Parcelable {
    private String nameprofessor;
    private int imgprofessor;
    private String surnameprofessor;
    private String textDescProfessor;

    public String getTextDescProfessor() {
        return textDescProfessor;
    }

    public void setTextDescProfessor(String textDescProfessor) {
        this.textDescProfessor = textDescProfessor;
    }



    public String getSurnameprofessor() {
        return surnameprofessor;
    }

    public void setSurnameprofessor(String surnameprofessor) {
        this.surnameprofessor = surnameprofessor;
    }

    public TeacherObject() {
    }

    public TeacherObject(String nameprofessor, int imgprofessor, String surnameprofessor, String textDescProfessor) {
        this.nameprofessor = nameprofessor;
        this.imgprofessor = imgprofessor;
        this.surnameprofessor = surnameprofessor;
        this.textDescProfessor = textDescProfessor;
    }

    public TeacherObject(Parcel in) {
        nameprofessor = in.readString();
        imgprofessor = in.readInt();
        surnameprofessor = in.readString();
        textDescProfessor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameprofessor);
        dest.writeInt(imgprofessor);
        dest.writeString(surnameprofessor);
        dest.writeString(textDescProfessor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeacherObject> CREATOR = new Creator<TeacherObject>() {
        @Override
        public TeacherObject createFromParcel(Parcel in) {
            return new TeacherObject(in);
        }

        @Override
        public TeacherObject[] newArray(int size) {
            return new TeacherObject[size];
        }
    };

    public String getNameprofessor() {
        return nameprofessor;
    }

    public void setNameprofessor(String nameprofessor) {
        this.nameprofessor = nameprofessor;
    }

    public int getImgprofessor() {
        return imgprofessor;
    }

    public void setImgprofessor(int imgclass) {
        this.imgprofessor = imgprofessor;
    }
}
