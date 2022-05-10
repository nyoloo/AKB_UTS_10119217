package com.nyoloo.nyoloselfapp.ui.Daily;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyoloo.nyoloselfapp.R;
import com.nyoloo.nyoloselfapp.database.Friend;

import java.util.List;

// Tanggal Pengerjaan   : 29 April 2022
// Nama                 : Tri Tafriyadi
// NIM                  : 10119213
// Kelas                : IF-6
public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendViewHolder> {
    private final Context context;
    private List<Friend> friendList;

    public FriendsListAdapter(Context context){ this.context =context;}
    @SuppressLint("NotifyDataSetChanged")
    public void setFriendList(List<Friend> list){
        this.friendList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FriendsListAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_friend_rows,parent,false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsListAdapter.FriendViewHolder holder, int position) {
    holder.friendName.setText((this.friendList.get(position).friendName));
    holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.friendList.get(position).imagename)));
    holder.codeName.setText((this.friendList.get(position).codeName));
    }

    @Override
    public int getItemCount() {
        return this.friendList.size();
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder{
        TextView friendName;
        TextView codeName;
        ImageView imagename;
        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            friendName = itemView.findViewById(R.id.friend_recycle_name);
            imagename =itemView.findViewById(R.id.friend_recycle_image);
            codeName = itemView.findViewById(R.id.friend_recycle_codename);
        }
    }
    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }
}
