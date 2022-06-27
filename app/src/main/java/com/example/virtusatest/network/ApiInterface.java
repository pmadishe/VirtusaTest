package com.example.virtusatest.network;

import com.example.virtusatest.model.PeopleResponse;
import com.example.virtusatest.model.PeopleResponseItem;
import com.example.virtusatest.model.RoomsResponseItem;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("people")
    Call<List<PeopleResponseItem>> getPeopleResponse();

    @GET("people/{id}")
    Call<PeopleResponseItem> getSingleItemFromPeopleResponse(@Path("id") Long id);

    @GET("rooms")
    Call<List<RoomsResponseItem>> getRoomsResponse();
}
