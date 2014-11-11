package com.go.gocard.card;

import android.content.Context;

import com.go.gocard.common.CommonPreferences;

public class CardDependencies {
    private final CardFragment mCardFragment;

    public CardFragment getCardFragment() {
        return mCardFragment;
    }

    public CardDependencies(Context context) {
        mCardFragment = new CardFragment();

        final CardDataStore dataStore = new CardDataStore();
        final CardInteractor interactor = new CardInteractor(context, dataStore);
        final CardNavigator navigator = new CardNavigator(mCardFragment);
        final CommonPreferences preferences = new CommonPreferences(context);
        final CardView view = new CardView();
        final CardParams params = new CardParams(context, preferences);
        params.loadCardParams();

        mCardFragment.setInteractor(interactor);
        mCardFragment.setNavigator(navigator);
        mCardFragment.setView(view);
        mCardFragment.setParams(params);
    }
}