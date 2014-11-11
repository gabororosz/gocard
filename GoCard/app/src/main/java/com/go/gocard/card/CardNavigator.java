package com.go.gocard.card;

import android.content.Intent;
import android.net.Uri;

import com.go.gocard.gocard.R;

public class CardNavigator {
    private final CardFragment mFragment;

    public CardNavigator(CardFragment fragment) {
        mFragment = fragment;
    }

    public void goToSite() {
        String url = mFragment.getString(CardResources.URL_GOCARD_SITE);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        mFragment.startActivity(i);
    }
}
