package com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "Lesson")
public class ClassObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "nameclass")
    private String nameclass;
    @ColumnInfo(name = "imgclass")
    private int imgclass;
    @ColumnInfo(name = "course")
    private String course;
    @ColumnInfo(name = "textDescriptionClass")
    private String textDescriptionClass;

    public ClassObject(String nameclass, int imgclass, String course, String textDescriptionClass) {
        this.nameclass = nameclass;
        this.imgclass = imgclass;
        this.course = course;
        this.textDescriptionClass = textDescriptionClass;
    }

    public ClassObject(Parcel in) {
        id = in.readInt();
        nameclass = in.readString();
        imgclass = in.readInt();
        course = in.readString();
        textDescriptionClass = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nameclass);
        dest.writeInt(imgclass);
        dest.writeString(course);
        dest.writeString(textDescriptionClass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClassObject> CREATOR = new Creator<ClassObject>() {
        @Override
        public ClassObject createFromParcel(Parcel in) {
            return new ClassObject(in);
        }

        @Override
        public ClassObject[] newArray(int size) {
            return new ClassObject[size];
        }
    };

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public int getImgclass() {
        return imgclass;
    }

    public void setImgclass(int imgclass) {
        this.imgclass = imgclass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTextDescriptionClass() {
        return textDescriptionClass;
    }

    public void setTextDescriptionClass(String textDescriptionClass) {
        this.textDescriptionClass = textDescriptionClass;
    }
}
