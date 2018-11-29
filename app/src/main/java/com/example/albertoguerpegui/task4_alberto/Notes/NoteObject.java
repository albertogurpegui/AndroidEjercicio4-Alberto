package com.example.albertoguerpegui.task4_alberto.Notes;

import android.os.Parcel;
import android.os.Parcelable;

public class NoteObject implements Parcelable {
    private String date;
    private String classes;
    private String notes;
    private String exercise;

    public NoteObject(String date, String classes, String notes, String exercise) {
        this.date = date;
        this.classes = classes;
        this.notes = notes;
        this.exercise = exercise;
    }

    protected NoteObject(Parcel in) {
        date = in.readString();
        classes = in.readString();
        notes = in.readString();
        exercise = in.readString();
    }

    public static final Creator<NoteObject> CREATOR = new Creator<NoteObject>() {
        @Override
        public NoteObject createFromParcel(Parcel in) {
            return new NoteObject(in);
        }

        @Override
        public NoteObject[] newArray(int size) {
            return new NoteObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(classes);
        dest.writeString(notes);
        dest.writeString(exercise);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
}
