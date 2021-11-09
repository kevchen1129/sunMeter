package com.example.sunmeter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> rankList;
    public MainAdapter(Context context,ArrayList<User> rankList){
        this.context = context;
        this.rankList = rankList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User  user = rankList.get(position);
        holder.firstName.setText(String.valueOf(user.getFirstName()));
        holder.age.setText(String.valueOf(user.getAge()));
       holder.profile.setImageResource(R.drawable.ic_launcher_background);


    }

    @Override
    public int getItemCount() {
        return rankList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName , age;
        ImageView profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvfirstName);
           // lastName = itemView.findViewById(R.id.tvlastName);
            age = itemView.findViewById(R.id.tvAge);
            profile = itemView.findViewById(R.id.profile);
        }
    }
}
