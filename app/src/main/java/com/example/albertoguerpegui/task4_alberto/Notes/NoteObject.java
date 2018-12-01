package com.example.albertoguerpegui.task4_alberto.Notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "Note")
public class NoteObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "classes")
    private String classes;
    @ColumnInfo(name = "notes")
    private String notes;
    @ColumnInfo(name = "exercise")
    private String exercise;

    public NoteObject(String date, String classes, String notes, String exercise) {
        this.date = date;
        this.classes = classes;
        this.notes = notes;
        this.exercise = exercise;
    }

    protected NoteObject(Parcel in) {
        id = in.readInt();
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
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeString(classes);
        dest.writeString(notes);
        dest.writeString(exercise);
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
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
