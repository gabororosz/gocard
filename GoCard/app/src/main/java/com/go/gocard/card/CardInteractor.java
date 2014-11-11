package com.go.gocard.card;

import android.content.Context;
import android.location.Location;

import com.go.gocard.common.Notifier;

public class CardInteractor {
    private final Context mContext;
    private final CardDataStore mCardDataStore;

    public CardInteractor(Context context, CardDataStore cardDataStore) {
        mContext = context;
        mCardDataStore = cardDataStore;
    }

    public void sendCardData(CardParams cardParams, Location location, Notifier notifier) {
        final Notifier repositorySendCardNotifier = getRepositorySendCardNotifier(notifier);
        mCardDataStore.sendCard(mContext, cardParams, location, repositorySendCardNotifier);
    }
    private Notifier getRepositorySendCardNotifier(final Notifier notifier) {
        return new Notifier() {
            @Override public void success() {
                notifier.success();
            }

            @Override public void failed() {
                notifier.failed();
            }
        };
    }
}