package com.go.gocard.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class Accuracy implements Parcelable{

    private static final String FIELD_VERTICAL = "vertical";
    private static final String FIELD_HORIZONTAL = "horizontal";


    @SerializedName(FIELD_VERTICAL)
    private double mVertical;
    @SerializedName(FIELD_HORIZONTAL)
    private double mHorizontal;


    public Accuracy(){

    }

    public void setVertical(double vertical) {
        mVertical = vertical;
    }

    public double getVertical() {
        return mVertical;
    }

    public void setHorizontal(double horizontal) {
        mHorizontal = horizontal;
    }

    public double getHorizontal() {
        return mHorizontal;
    }

    public Accuracy(Parcel in) {
        mVertical = in.readDouble();
        mHorizontal = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Accuracy> CREATOR = new Creator<Accuracy>() {
        public Accuracy createFromParcel(Parcel in) {
            return new Accuracy(in);
        }

        public Accuracy[] newArray(int size) {
        return new Accuracy[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mVertical);
        dest.writeDouble(mHorizontal);
    }

    @Override
    public String toString(){
        return "vertical = " + mVertical + ", horizontal = " + mHorizontal;
    }


}