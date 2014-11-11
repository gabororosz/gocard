package com.go.gocard.card;

import android.content.Context;

import com.go.gocard.common.CommonPreferences;

public class CardParams {
    private final Context mContext;
    private final CommonPreferences mPreferences;

    private String mEmail;
    private String mMobile;
    private String mName;
    private String mTitle;

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setMobile(String mobile) {
        this.mMobile = mobile;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public CardParams(Context context, CommonPreferences preferences) {
        mContext = context;
        mPreferences = preferences;
    }

    public CardParams(Context context, CommonPreferences preferences, String email, String mobile, String name, String title) {
        this(context, preferences);
        this.mEmail = email;
        this.mMobile = mobile;
        this.mName = name;
        this.mTitle = title;
    }

    public CardParams loadCardParams() {
        String mail = mPreferences.getKeyMail();
        String phone = mPreferences.getKeyPhone();
        String name = mPreferences.getKeyName();
        String jobTitle = mPreferences.getKeyJobTitle();

        Boolean isUserDataNull = mail == null || phone == null || name == null || jobTitle == null;

        if (isUserDataNull) {
            return new CardParams(mContext, mPreferences);
        } else {
            return new CardParams(mContext, mPreferences, mail, phone, name, jobTitle);
        }
    }

    public void saveCardParams() {
        mPreferences.setKeyJobTitle(mTitle);
        mPreferences.setKeyMail(mEmail);
        mPreferences.setKeyName(mName);
        mPreferences.setKeyPhone(mMobile);
    }
}