package com.go.gocard.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;

public class Card implements Parcelable{

    private static final String FIELD_ACCURACY = "accuracy";
    private static final String FIELD_POSITION = "position";
    private static final String FIELD_CARD_DATA = "cardData";

    @SerializedName(FIELD_ACCURACY)
    private Accuracy mAccuracy;
    @SerializedName(FIELD_POSITION)
    private List<Double> mPositions;
    @SerializedName(FIELD_CARD_DATA)
    private CardDatum mCardDatum;

    public Card(){

    }

    public void setAccuracy(Accuracy accuracy) {
        mAccuracy = accuracy;
    }

    public Accuracy getAccuracy() {
        return mAccuracy;
    }

    public void setPositions(List<Double> positions) {
        mPositions = positions;
    }

    public List<Double> getPositions() {
        return mPositions;
    }

    public void setCardDatum(CardDatum cardDatum) {
        mCardDatum = cardDatum;
    }

    public CardDatum getCardDatum() {
        return mCardDatum;
    }

    public Card(Parcel in) {
        mAccuracy = in.readParcelable(Accuracy.class.getClassLoader());
        in.readArrayList(Double.class.getClassLoader());
        mCardDatum = in.readParcelable(CardDatum.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        public Card[] newArray(int size) {
        return new Card[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mAccuracy, flags);
        dest.writeList(mPositions);
        dest.writeParcelable(mCardDatum, flags);
    }

    @Override
    public String toString(){
        return "accuracy = " + mAccuracy + ", positions = " + mPositions + ", cardDatum = " + mCardDatum;
    }
}