package com.go.gocard.common;

import android.content.Context;
import android.content.SharedPreferences;

public class CommonPreferences {
    protected final String PREFERENCES_GOCARD = "preferences_gocard";
    protected final String PREFERENCE_KEY_NAME = "user_name";
    protected final String PREFERENCE_KEY_JOB_TITLE = "user_jobtitle";
    protected final String PREFERENCE_KEY_PHONE = "user_phone";
    protected final String PREFERENCE_KEY_MAIL = "user_mail";

    private final Context mContext;

    public CommonPreferences(Context context) {
        mContext = context;
    }

    public String getKeyName() {
        return getValue(PREFERENCE_KEY_NAME);
    }

    public void setKeyName(String name) {
        setKey(PREFERENCE_KEY_NAME, name);
    }

    public String getKeyJobTitle() {
        return getValue(PREFERENCE_KEY_JOB_TITLE);
    }

    public void setKeyJobTitle(String jobTitle) {
        setKey(PREFERENCE_KEY_JOB_TITLE, jobTitle);
    }

    public String getKeyPhone() {
        return getValue(PREFERENCE_KEY_PHONE);
    }

    public void setKeyPhone(String phone) {
        setKey(PREFERENCE_KEY_PHONE, phone);
    }

    public String getKeyMail() {
        return getValue(PREFERENCE_KEY_MAIL);
    }

    public void setKeyMail(String mail) {
        setKey(PREFERENCE_KEY_MAIL, mail);
    }

    private String getValue(String key) {
        SharedPreferences prefs = mContext.getSharedPreferences(PREFERENCES_GOCARD, 0);
        return prefs.getString(key, null);
    }

    private void setKey(String key, String value) {
        SharedPreferences prefs = mContext.getSharedPreferences(PREFERENCES_GOCARD, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }
}