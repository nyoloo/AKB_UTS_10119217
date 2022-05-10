package com.nyoloo.nyoloselfapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nyoloo.nyoloselfapp.database.AppDatabase;
import com.nyoloo.nyoloselfapp.database.Gallery;
import com.nyoloo.nyoloselfapp.databinding.FragmentGalleryBinding;

import java.util.List;


public class GalleryFragment extends Fragment {

    private GalleryListAdapter galleryListAdapter;
    private FragmentGalleryBinding binding;
    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initRecycle();

        loadGalleryList();


        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewGallery;
        recyclerView.setLayoutManager(new GridLayoutManager(binding.getRoot().getContext(),
                2));

        galleryListAdapter = new GalleryListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((galleryListAdapter));
    }

    private void loadGalleryList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Gallery> galleryList = db.galleryDao().getAllGallery();
        galleryListAdapter.setGalleryList(galleryList);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}