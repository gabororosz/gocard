package com.go.gocard.card;

import android.content.Context;
import android.location.Location;

import com.go.gocard.common.Notifier;
import com.go.gocard.model.Accuracy;
import com.go.gocard.model.Card;
import com.go.gocard.model.CardDatum;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CardDataStore {
    public void sendCard(final Context context, CardParams params, Location location, final Notifier notifier) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(context.getString(CardResources.URL_GOCARD_REST))
                .build();

        CardService service = restAdapter.create(CardService.class);
        Card card = getJsonBody(location, params);
        service.sendCard(card, new Callback<JSONObject>() {
            @Override public void success(JSONObject jsonObject, Response response) {
                notifier.success();
            }

            @Override public void failure(RetrofitError error) {
                notifier.failed();
            }
        });
    }

    private Card getJsonBody(Location location, CardParams params) {
        Card card = new Card();

        CardDatum cardData = new CardDatum();
        cardData.setEmail(params.getEmail());
        cardData.setMobile(params.getMobile());
        cardData.setName(params.getName());
        cardData.setTitle(params.getTitle());
        card.setCardDatum(cardData);

        if(location != null) {
            List<Double> positions = Arrays.asList(location.getLongitude(), location.getLatitude());
            card.setPositions(positions);

            Accuracy accuracy = new Accuracy();
            accuracy.setHorizontal(location.getAccuracy());
            accuracy.setVertical(location.getAccuracy());
            card.setAccuracy(accuracy);
        }

        return card;
    }
}