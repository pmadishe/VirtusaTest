package com.example.virtusatest.vm;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtusatest.model.PeopleResponseItem;
import com.example.virtusatest.network.ApiClient;
import com.example.virtusatest.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends ViewModel {

    private static final String TAG = DetailsViewModel.class.getSimpleName();
    private final MutableLiveData<PeopleResponseItem> singleItem = new MutableLiveData<>();
    private final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public LiveData<PeopleResponseItem> getSingleItemResponse() {
        return singleItem;
    }

    public void makeApiCall(Long id) {

        Call<PeopleResponseItem> call = apiService.getSingleItemFromPeopleResponse(id);
        call.enqueue(new Callback<PeopleResponseItem>() {
            @Override
            public void onResponse(Call<PeopleResponseItem> call, Response<PeopleResponseItem> response) {
                Log.d(TAG, "onResponse response:: " + response);
                if (response.body() != null) {
                    singleItem.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<PeopleResponseItem> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: "+"Invoked");
            }
        });
    }
}
