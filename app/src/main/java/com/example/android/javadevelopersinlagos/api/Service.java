package com.example.android.javadevelopersinlagos.api;

import com.example.android.javadevelopersinlagos.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Maro on 9/16/2017.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
