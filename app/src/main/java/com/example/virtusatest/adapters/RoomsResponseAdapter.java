package com.example.virtusatest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.virtusatest.R;
import com.example.virtusatest.model.RoomsResponseItem;
import java.util.List;

public class RoomsResponseAdapter extends RecyclerView.Adapter<RoomsResponseAdapter.ViewHolder>{
    private List<RoomsResponseItem> roomsResponseItemList;
    private Context context;

    public RoomsResponseAdapter(Context context, List<RoomsResponseItem> list) {
        this.context = context;
        this.roomsResponseItemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view=LayoutInflater.from(context)
                .inflate(R.layout.rv_rooms_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RoomsResponseItem item = roomsResponseItemList.get(position);

        holder.id.setText(item.getId());
        holder.isOccupied.setText(isRoomOccupied(item));
        holder.maxOccupancy.setText(String.valueOf(item.getMaxOccupancy()));

    }

    private String isRoomOccupied(RoomsResponseItem item) {
        if (item.isIsOccupied()) {
            return "Occupied";
        } else {
            return "Vacant";
        }
    }

    @Override
    public int getItemCount() {
        return roomsResponseItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {  
        public TextView isOccupied;
        public TextView maxOccupancy;
        public TextView id;

        public ViewHolder(View itemView) {  
            super(itemView);  
            this.isOccupied = (TextView) itemView.findViewById(R.id.isOccupied);
            this.maxOccupancy = (TextView) itemView.findViewById(R.id.maxOccupancy);
            this.id = (TextView) itemView.findViewById(R.id.id);
        }
    }  
}  