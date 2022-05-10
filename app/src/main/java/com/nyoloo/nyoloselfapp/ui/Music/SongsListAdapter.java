package com.nyoloo.nyoloselfapp.ui.Music;

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
import com.nyoloo.nyoloselfapp.database.Song;

import java.util.List;

// Tanggal Pengerjaan   : 7 Mei 2022
// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.SongsViewHolder> {
    private final Context context;
    private List<Song> songsList;

    public SongsListAdapter(Context context){ this.context =context;}
    @SuppressLint("NotifyDataSetChanged")
    public void setSongsList(List<Song> list){
        this.songsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongsListAdapter.SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_songs_rows,parent,false);
        return new SongsViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull SongsListAdapter.SongsViewHolder holder, int position) {
        holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.songsList.get(position).imagename)));
        holder.titlesong.setText((this.songsList.get(position).titlesong));
        holder.artistname.setText((this.songsList.get(position).artistname));
    }

    @Override
    public int getItemCount()  {
        return this.songsList.size();
    }
    public static class SongsViewHolder extends RecyclerView.ViewHolder{
        ImageView imagename;
        TextView titlesong;
        TextView artistname;
        public SongsViewHolder (@NonNull View itemView) {
            super(itemView);
            imagename =itemView.findViewById(R.id.song_recycle_image);
            titlesong =itemView.findViewById(R.id.song_recycle_title);
            artistname =itemView.findViewById(R.id.song_recycle_artist);
        }
    }
    private int getDrawableByName(String name){
        Resources res = context.getResources();
        return res.getIdentifier(name,"drawable",context.getPackageName());
    }
}
