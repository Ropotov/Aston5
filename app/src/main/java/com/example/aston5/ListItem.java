package com.example.aston5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ListItem implements Parcelable {

    public int mId = 0;
    public String mFirstName = "";
    public String mLastName = "";
    public String mPhone = "";

    public ListItem(int id, String firstName, String lastName, String phone) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mPhone = phone;
    }

    protected ListItem(Parcel in) {
        mId = in.readInt();
        mFirstName = in.readString();
        mLastName = in.readString();
        mPhone = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mPhone);
    }
}
