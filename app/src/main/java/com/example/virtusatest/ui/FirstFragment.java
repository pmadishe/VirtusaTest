package com.example.virtusatest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtusatest.adapters.PeopleResponseAdapter;
import com.example.virtusatest.vm.PeopleResponseViewModel;
import com.example.virtusatest.R;
import com.example.virtusatest.databinding.FragmentFirstBinding;
import com.example.virtusatest.model.PeopleResponseItem;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private PeopleResponseAdapter adapter;
    private PeopleResponseViewModel viewModel;
    private final List<PeopleResponseItem> peopleResponseItemList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        FragmentFirstBinding binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        initRecyclerView(view);
        populatePeopleData();
        return view;
    }

    private void populatePeopleData() {
        viewModel = new ViewModelProvider(this).get(PeopleResponseViewModel.class);
        viewModel.makeApiCall();
        getPeopleResponse();
    }

    private void initRecyclerView(View view) {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.rv_people);
        recyclerView.setLayoutManager(linearLayoutManager);
        // adapter
        adapter = new PeopleResponseAdapter(getActivity(), peopleResponseItemList);
        recyclerView.setAdapter(adapter);
    }

    private void getPeopleResponse() {
        viewModel.getPeopleResponse().observe(this.getViewLifecycleOwner(), peopleResponse -> {
            if (peopleResponse != null) {

                List<PeopleResponseItem> peopleItemList = peopleResponse;
                peopleResponseItemList.addAll(peopleItemList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}