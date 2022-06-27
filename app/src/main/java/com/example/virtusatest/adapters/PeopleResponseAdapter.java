package com.example.virtusatest.adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.virtusatest.R;
import com.example.virtusatest.model.PeopleResponseItem;
import java.util.List;

public class PeopleResponseAdapter extends RecyclerView.Adapter<PeopleResponseAdapter.ViewHolder>{
    private List<PeopleResponseItem> peopleResponseItemList;
    private Context context;

    public PeopleResponseAdapter(Context context, List<PeopleResponseItem> list) {
        this.context = context;
        this.peopleResponseItemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view=LayoutInflater.from(context)
                .inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PeopleResponseItem item = peopleResponseItemList.get(position);

        holder.firstNameTextView.setText(item.getFirstName());
        Glide.with(context)
                .load(item.getAvatar())
                .circleCrop()
                .into(holder.avatarImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Storing data into SharedPreferences
                SharedPreferences sharedPreferences = context
                        .getSharedPreferences("MySharedPref", MODE_PRIVATE);

                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt("id", holder.getLayoutPosition()+1);
                myEdit.commit();

                Navigation.findNavController(holder.itemView)
                        .navigate(R.id.action_FirstFragment_to_DetailFragment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return peopleResponseItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public ImageView avatarImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            this.firstNameTextView = (TextView) itemView.findViewById(R.id.firstName);
            this.avatarImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }

}  