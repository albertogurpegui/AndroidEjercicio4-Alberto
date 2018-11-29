package com.example.albertoguerpegui.task4_alberto.Teachers;

import android.graphics.drawable.Drawable;

public class CardView_Teacher_Data {
    private Drawable photos_course;
    private String names_course;

    public CardView_Teacher_Data(Drawable photos, String names) {
        this.photos_course = photos;
        this.names_course = names;
    }

    public void setPhotos_subject(Drawable photos) {
        this.photos_course = photos;
    }

    public void setNames_subject(String names) {
        this.names_course = names;
    }

    public Drawable getPhotos_subject() {
        return photos_course;
    }

    public String getNames_subject() { return names_course; }
}
