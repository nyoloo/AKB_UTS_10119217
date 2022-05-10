package com.nyoloo.nyoloselfapp.ui.Music;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nyoloo.nyoloselfapp.database.AppDatabase;
import com.nyoloo.nyoloselfapp.database.Song;
import com.nyoloo.nyoloselfapp.database.Videos;
import com.nyoloo.nyoloselfapp.databinding.VideosFragmentBinding;

import java.util.List;
import java.util.concurrent.Executors;

// Tanggal Pengerjaan   : 7 Mei 2022
// Nama                 : Tiyo Haryo Subaktiono
// NIM                  : 10119217
// Kelas                : IF-6
public class VideosFragment extends Fragment {

    private VideosListAdapter videosListAdapter;
    private VideosFragmentBinding binding;
    public static VideosFragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = VideosFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();


        initRecycle();

        loadVideosList();;

        AppDatabase db = AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        FloatingActionButton fabButton = binding.clearTable;
        fabButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.songDao().deleteAllSongs();
            db.songDao().insert(Song.isiLagu());
            handler.post(this::loadVideosList);
        }));

        return root;
    }
    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewVideos;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        videosListAdapter = new VideosListAdapter(this.getLifecycle());
        recyclerView.setAdapter((videosListAdapter));
    }

    private void loadVideosList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Videos> videosList = db.videosDao().getAllVideos();
        videosListAdapter.setVideosList(videosList);
    }

}