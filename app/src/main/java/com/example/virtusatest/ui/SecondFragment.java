package com.example.virtusatest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtusatest.R;
import com.example.virtusatest.vm.RoomResponseViewModel;
import com.example.virtusatest.adapters.RoomsResponseAdapter;
import com.example.virtusatest.databinding.FragmentSecondBinding;
import com.example.virtusatest.model.RoomsResponseItem;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    private RoomsResponseAdapter roomAdapter;
    private RoomResponseViewModel roomViewModel;
    private RecyclerView recyclerView;
    private final List<RoomsResponseItem> roomsResponseItemList = new ArrayList<>();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        FragmentSecondBinding binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        initRoomRecyclerView(view);
        populateRoomData();
        return view;

    }

    private void populateRoomData(){
        roomViewModel = new ViewModelProvider(this).get(RoomResponseViewModel.class);
        roomViewModel.makeApiCall();
        getRoomsResponse();
    }

    private void initRoomRecyclerView(View vi) {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = vi.findViewById(R.id.rv_rooms);
        recyclerView.setLayoutManager(linearLayoutManager);
        // adapter
        roomAdapter = new RoomsResponseAdapter(getActivity(), roomsResponseItemList);
        recyclerView.setAdapter(roomAdapter);
    }

    private void getRoomsResponse() {
        roomViewModel.getRoomsResponse().observe(this.getViewLifecycleOwner(), roomsResponse -> {
            if (roomsResponse != null) {

                List<RoomsResponseItem> roomsItemList = roomsResponse;
                roomsResponseItemList.addAll(roomsItemList);
                roomAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

}