package com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "Comunity")
public class ComunityObject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "namecomunity")
    private String namecomunity;
    @ColumnInfo(name = "imgcomunity")
    private int imgcomunity;
    @ColumnInfo(name = "textDescriptionCommunity")
    private String textDescriptionCommunity;
    @ColumnInfo(name = "topicCommunity")
    private String topicCommunity;
    @ColumnInfo(name = "cordinator")
    private String cordinator;

    public ComunityObject(String namecomunity, int imgcomunity, String textDescriptionCommunity, String topicCommunity, String cordinator) {
        this.namecomunity = namecomunity;
        this.imgcomunity = imgcomunity;
        this.textDescriptionCommunity = textDescriptionCommunity;
        this.topicCommunity = topicCommunity;
        this.cordinator = cordinator;
    }

    public ComunityObject(Parcel in) {
        id = in.readInt();
        namecomunity = in.readString();
        imgcomunity = in.readInt();
        topicCommunity = in.readString();
        textDescriptionCommunity = in.readString();
        cordinator = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
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

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNamecomunity() {
        return namecomunity;
    }

    public void setNamecomunity(String namecomunity) {
        this.namecomunity = namecomunity;
    }

    public int getImgcomunity() {
        return imgcomunity;
    }

    public void setImgcomunity(int imgcomunity) {
        this.imgcomunity = imgcomunity;
    }

    public String getTextDescriptionCommunity() {
        return textDescriptionCommunity;
    }

    public void setTextDescriptionCommunity(String textDescriptionCommunity) {
        this.textDescriptionCommunity = textDescriptionCommunity;
    }

    public String getTopicCommunity() {
        return topicCommunity;
    }

    public void setTopicCommunity(String topicCommunity) {
        this.topicCommunity = topicCommunity;
    }

    public String getCordinator() {
        return cordinator;
    }

    public void setCordinator(String cordinator) {
        this.cordinator = cordinator;
    }
}
