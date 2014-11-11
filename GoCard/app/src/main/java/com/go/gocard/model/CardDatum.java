package com.go.gocard.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;

public class CardDatum implements Parcelable{

    private static final String FIELD_TITLE = "title";
    private static final String FIELD_MOBILE = "mobile";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_EMAIL = "email";

    @SerializedName(FIELD_TITLE)
    private String mTitle;
    @SerializedName(FIELD_MOBILE)
    private String mMobile;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_EMAIL)
    private String mEmail;

    public CardDatum(){

    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getEmail() {
        return mEmail;
    }

    public CardDatum(Parcel in) {
        mTitle = in.readString();
        mMobile = in.readString();
        mName = in.readString();
        mEmail = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CardDatum> CREATOR = new Creator<CardDatum>() {
        public CardDatum createFromParcel(Parcel in) {
            return new CardDatum(in);
        }

        public CardDatum[] newArray(int size) {
        return new CardDatum[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mMobile);
        dest.writeString(mName);
        dest.writeString(mEmail);
    }

    @Override
    public String toString(){
        return "title = " + mTitle + ", mobile = " + mMobile + ", name = " + mName + ", email = " + mEmail;
    }
}