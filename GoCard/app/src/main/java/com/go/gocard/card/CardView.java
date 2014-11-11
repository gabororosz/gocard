package com.go.gocard.card;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CardView {

    private CardViewEventHandler mEventHandler;
    private View mRootView;

    private EditText mEditMail;
    private EditText mEditPhone;
    private EditText mEditName;
    private EditText mEditTitle;
    private Button mBtnSend;
    private Button mBtnGoToSite;

    public void initView(final LayoutInflater inflater, final ViewGroup container, CardViewEventHandler eventHandler) {
        mEventHandler = eventHandler;
        mRootView = initLayoutRootView(inflater, container);
        initComponents();
        initEvents();
    }

    private View initLayoutRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(CardResources.LAYOUT_THIS, container, false);
    }

    private void initComponents() {
        mEditMail = getEditTextById(CardResources.ID_EDIT_MAIL);
        mEditPhone = getEditTextById(CardResources.ID_EDIT_PHONE);
        mEditName = getEditTextById(CardResources.ID_EDIT_NAME);
        mEditTitle = getEditTextById(CardResources.ID_EDIT_TITLE);
        mBtnSend = getButtonById(CardResources.ID_BTN_SEND);
        mBtnGoToSite = getButtonById(CardResources.ID_BTN_GOTOSITE);
    }

    private EditText getEditTextById(int id) {
        return (EditText) mRootView.findViewById(id);
    }

    private Button getButtonById(int id) {
        return (Button) mRootView.findViewById(id);
    }

    private void initEvents() {
        initMailEditEvent();
        initPhoneEditEvent();
        initNameEditEvent();
        initTitleEditEvent();
        initSendEvent();
        initGoToSiteEvent();
    }

    private void initGoToSiteEvent() {
        mBtnGoToSite.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEventHandler.goToSiteClicked();
            }
        });
    }

    private void initSendEvent() {
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventHandler.sendClicked();
            }
        });
    }

    private void initTitleEditEvent() {
        mEditTitle.addTextChangedListener(new TextWatcher() {

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEventHandler.titleEdited(s.toString());
            }

            @Override public void afterTextChanged(Editable s) {
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }

    private void initNameEditEvent() {
        mEditName.addTextChangedListener(new TextWatcher() {

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEventHandler.nameEdited(s.toString());
            }

            @Override public void afterTextChanged(Editable s) {
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }

    private void initPhoneEditEvent() {
        mEditPhone.addTextChangedListener(new TextWatcher() {

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEventHandler.phoneEdited(s.toString());
            }

            @Override public void afterTextChanged(Editable s) {
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }

    private void initMailEditEvent() {
        mEditMail.addTextChangedListener(new TextWatcher() {

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEventHandler.mailEdited(s.toString());
            }

            @Override public void afterTextChanged(Editable s) {
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }

    public void updateView(CardParams params) {
        mEditMail.setText(params.getEmail());
        mEditName.setText(params.getName());
        mEditPhone.setText(params.getMobile());
        mEditTitle.setText(params.getTitle());
    }

    public View getRootView() {
        return mRootView;
    }
}