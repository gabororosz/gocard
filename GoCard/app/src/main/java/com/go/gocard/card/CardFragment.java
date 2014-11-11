package com.go.gocard.card;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.go.gocard.common.Notifier;
import com.google.android.gms.location.DetectedActivity;

import io.nlopez.smartlocation.SmartLocation;

public class CardFragment extends Fragment implements CardViewEventHandler{
    private CardView mView;
    private CardInteractor mInteractor;
    private CardNavigator mNavigator;
    private CardParams mParams;
    private Location mLocation;

    public void setView(CardView view) {
        mView = view;
    }

    public void setInteractor(CardInteractor interactor) {
        mInteractor = interactor;
    }

    public void setNavigator(CardNavigator navigator) {
        mNavigator = navigator;
    }

    public void setParams(CardParams params) {
        mParams = params;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView.initView(inflater, container, this);
        if(mParams == null) {
            throw new IllegalStateException(getActivity().getString(CardResources.ERROR_CARDPARAM_IS_NULL));
        } else {
            mView.updateView(mParams);
        }
        return mView.getRootView();
    }

    @Override public void onResume() {
        super.onResume();
        SmartLocation.getInstance().start(
            getActivity(),
            new SmartLocation.OnLocationUpdatedListener() {
                @Override
                public void onLocationUpdated(Location location, DetectedActivity detectedActivity) {
                    mLocation = location;
                }
            }
        );
    }

    @Override public void onPause() {
        super.onPause();
        SmartLocation.getInstance().stop(getActivity());
    }

    @Override public void onDestroy() {
        super.onDestroy();
        SmartLocation.getInstance().cleanup(getActivity());
    }

    @Override public void mailEdited(String mail) {
        mParams.setEmail(mail);
    }

    @Override public void phoneEdited(String phone) {
        mParams.setMobile(phone);
    }

    @Override public void nameEdited(String name) {
        mParams.setName(name);
    }

    @Override public void titleEdited(String title) {
        mParams.setTitle(title);
    }

    @Override public void sendClicked() {
        mParams.saveCardParams();
        final Notifier notifier = getInteractorSendCardNotifier();
        mInteractor.sendCardData(mParams, mLocation, notifier);
    }

    private Notifier getInteractorSendCardNotifier() {
        return new Notifier() {
            @Override public void success() {
                Toast toast = Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG);
                toast.show();
            }

            @Override public void failed() {
                Toast toast = Toast.makeText(getActivity(), "Failure", Toast.LENGTH_LONG);
                toast.show();
            }
        };
    }

    @Override public void goToSiteClicked() {
        mNavigator.goToSite();
    }
}