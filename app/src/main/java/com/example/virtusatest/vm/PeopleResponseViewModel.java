package com.example.virtusatest.vm;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtusatest.model.PeopleResponseItem;
import com.example.virtusatest.network.ApiClient;
import com.example.virtusatest.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleResponseViewModel extends ViewModel {
    private static final String TAG = PeopleResponseViewModel.class.getSimpleName();
    private final MutableLiveData<List<PeopleResponseItem>> peopleResponse = new MutableLiveData<>();
    public LiveData<List<PeopleResponseItem>> getPeopleResponse() {
        return peopleResponse;
    }
    private final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public void makeApiCall() {
        Call<List<PeopleResponseItem>> call = apiService.getPeopleResponse();
        call.enqueue(new Callback<List<PeopleResponseItem>>() {
            @Override
            public void onResponse(Call<List<PeopleResponseItem>> call, Response<List<PeopleResponseItem>> response) {
                if (response.body() != null) {
                    peopleResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PeopleResponseItem>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: "+"Invoked");
            }
        });
    }

}