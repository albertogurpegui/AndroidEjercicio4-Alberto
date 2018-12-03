package com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "Teacher")
public class TeacherObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nameprofessor")
    private String nameprofessor;
    @ColumnInfo(name = "imgprofessor")
    private int imgprofessor;
    @ColumnInfo(name = "surnameprofessor")
    private String surnameprofessor;
    @ColumnInfo(name = "textDescProfessor")
    private String textDescProfessor;


    public TeacherObject(String nameprofessor, int imgprofessor, String surnameprofessor, String textDescProfessor) {
        this.nameprofessor = nameprofessor;
        this.imgprofessor = imgprofessor;
        this.surnameprofessor = surnameprofessor;
        this.textDescProfessor = textDescProfessor;
    }

    public TeacherObject(Parcel in) {
        id = in.readInt();
        nameprofessor = in.readString();
        imgprofessor = in.readInt();
        surnameprofessor = in.readString();
        textDescProfessor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
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

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNameprofessor() {
        return nameprofessor;
    }

    public void setNameprofessor(String nameprofessor) {
        this.nameprofessor = nameprofessor;
    }

    public int getImgprofessor() {
        return imgprofessor;
    }

    public void setImgprofessor(int imgprofessor) {
        this.imgprofessor = imgprofessor;
    }

    public String getSurnameprofessor() {
        return surnameprofessor;
    }

    public void setSurnameprofessor(String surnameprofessor) {
        this.surnameprofessor = surnameprofessor;
    }

    public String getTextDescProfessor() {
        return textDescProfessor;
    }

    public void setTextDescProfessor(String textDescProfessor) {
        this.textDescProfessor = textDescProfessor;
    }
}
