package com.example.virtusatest.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtusatest.vm.DetailsViewModel;
import com.example.virtusatest.databinding.FragmentDetailBinding;
import com.example.virtusatest.model.PeopleResponseItem;

import java.util.Objects;

public class DetailFragment extends Fragment {
    private static final String TAG = DetailFragment.class.getSimpleName();

    private DetailsViewModel viewModel;
    private PeopleResponseItem responseItem;
    private FragmentDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        SharedPreferences sh = getContext()
                .getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        long abc = sh.getInt("id", 0);

        viewModel.makeApiCall(abc);

        responseItem = viewModel.getSingleItemResponse().getValue();
        Log.d(TAG, "onCreate: " + responseItem);

        // responseItem = singleItem;
        viewModel.getSingleItemResponse().observe(this.getViewLifecycleOwner(), this::setDetailFragmentData);
        return view;
    }

    private void setDetailFragmentData(PeopleResponseItem singleItem) {
        binding.firstNameTv.setText(singleItem.getFirstName());
        binding.lastNameTv.setText(singleItem.getLastName());
        binding.favColorTv.setText(singleItem.getFavouriteColor());
        binding.emailTv.setText(singleItem.getEmail());
        binding.idTv.setText(singleItem.getId());
        binding.jobTitleTv.setText(singleItem.getJobtitle());
    }

}

