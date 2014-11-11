package com.go.gocard.card;

import com.go.gocard.model.Card;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface CardService {
    @POST("/locations") void sendCard(@Body Card body, Callback<JSONObject> callback);
}