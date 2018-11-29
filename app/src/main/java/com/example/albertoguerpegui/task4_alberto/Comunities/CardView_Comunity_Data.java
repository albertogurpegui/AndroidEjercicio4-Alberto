package com.example.albertoguerpegui.task4_alberto.Comunities;

import android.graphics.drawable.Drawable;

public class CardView_Comunity_Data {
    private Drawable photos_course;
    private String names_course;

    public CardView_Comunity_Data(Drawable photos, String names) {
        this.photos_course = photos;
        this.names_course = names;
    }

    public void setPhotos_comunity(Drawable photos) {
        this.photos_course = photos;
    }

    public void setNames_comunity(String names) {
        this.names_course = names;
    }

    public Drawable getPhotos_comunity() {
        return photos_course;
    }

    public String getNames_comunity() {
        return names_course;
    }
}
