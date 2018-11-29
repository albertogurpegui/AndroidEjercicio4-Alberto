package com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity;

import android.os.Parcel;
import android.os.Parcelable;

public class ComunityObject implements Parcelable {
    private String namecomunity;
    private int imgcomunity;

    private String textDescriptionCommunity;
    private String topicCommunity;

    public String getCordinator() {
        return cordinator;
    }

    public void setCordinator(String cordinator) {
        this.cordinator = cordinator;
    }

    private String cordinator;

    public String getTopicCommunity() {
        return topicCommunity;
    }

    public void setTopicCommunity(String topicCommunity) {
        this.topicCommunity = topicCommunity;
    }



    public String getTextDescriptionCommunity() {
        return textDescriptionCommunity;
    }

    public void setTextDescriptionCommunity(String textDescriptionCommunity) {
        this.textDescriptionCommunity = textDescriptionCommunity;
    }


    public ComunityObject(String namecomunity, int imgcomunity, String topicCommunity, String textDescriptionCommunity, String coordinator) {
        this.namecomunity = namecomunity;
        this.imgcomunity = imgcomunity;
        this.topicCommunity = topicCommunity;
        this.textDescriptionCommunity = textDescriptionCommunity;
        this.cordinator = coordinator;
    }

    public ComunityObject(Parcel in) {
        namecomunity = in.readString();
        imgcomunity = in.readInt();
        topicCommunity = in.readString();
        textDescriptionCommunity = in.readString();
        cordinator = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namecomunity);
        dest.writeInt(imgcomunity);
        dest.writeString(topicCommunity);
        dest.writeString(textDescriptionCommunity);
        dest.writeString(cordinator);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ComunityObject> CREATOR = new Creator<ComunityObject>() {
        @Override
        public ComunityObject createFromParcel(Parcel in) {
            return new ComunityObject(in);
        }

        @Override
        public ComunityObject[] newArray(int size) {
            return new ComunityObject[size];
        }
    };

    public String getNamecomunity() {
        return namecomunity;
    }

    public void setNamecomunity(String namecomunity) {
        this.namecomunity = namecomunity;
    }

    public int getImgcomunity() {
        return imgcomunity;
    }

    public void setImgcomunity(int imgclass) {
        this.imgcomunity = imgcomunity;
    }
}
