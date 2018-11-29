package com.example.albertoguerpegui.task4_alberto.Notifications;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationObject implements Parcelable {
    private String date;
    private String name;
    private String title;

    public NotificationObject(String date, String name, String title) {
        this.date = date;
        this.name = name;
        this.title = title;
    }

    protected NotificationObject(Parcel in) {
        date = in.readString();
        name = in.readString();
        title = in.readString();
    }

    public static final Creator<NotificationObject> CREATOR = new Creator<NotificationObject>() {
        @Override
        public NotificationObject createFromParcel(Parcel in) {
            return new NotificationObject(in);
        }

        @Override
        public NotificationObject[] newArray(int size) {
            return new NotificationObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(name);
        dest.writeString(title);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
