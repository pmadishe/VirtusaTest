package com.example.virtusatest.vm;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtusatest.model.RoomsResponseItem;
import com.example.virtusatest.network.ApiClient;
import com.example.virtusatest.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomResponseViewModel extends ViewModel {
    private static final String TAG = RoomResponseViewModel.class.getSimpleName();
    private final MutableLiveData<List<RoomsResponseItem>> roomsResponse = new MutableLiveData<>();
    private final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public LiveData<List<RoomsResponseItem>> getRoomsResponse() {
        return roomsResponse;
    }

    public void makeApiCall() {
        Call<List<RoomsResponseItem>> call = apiService.getRoomsResponse();
        call.enqueue(new Callback<List<RoomsResponseItem>>() {
            @Override
            public void onResponse(Call<List<RoomsResponseItem>> call, Response<List<RoomsResponseItem>> response) {
                if (response.body() != null) {
                    roomsResponse.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<RoomsResponseItem>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: "+"Invoked");
            }
        });
    }

}