//package com.nyoloo.nyoloselfapp.ui.Daily;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Handler;
//import android.os.Looper;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.nyoloo.nyoloselfapp.databinding.AktivityFragmentBinding;
//
//import java.util.List;
//import java.util.concurrent.Executors;
//
//public class AktfityFragment extends Fragment {
//    private AktivitiListAdapter activityListAdapter;
//    private AktivityFragmentBinding binding;
//    public static AktfityFragment newInstance() {
//        return new AktfityFragment();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        binding = AktivityFragmentBinding.inflate(inflater,container,false);
//        View root = binding.getRoot();
//
//        initRecycle();
//
//        loadActivitiesList();
//
//        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
//        Handler handler = new Handler(Looper.getMainLooper());
//
//        FloatingActionButton fabButton = binding.clearTable;
//        fabButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
//        {
//            db.activitiesDao().deleteAllActivities();
//            db.activitiesDao().insert(Activities.isiAktifitas());
//            handler.post(this::loadActivitiesList);
//        }));
//
//
//        return root;
//    }
//    private void initRecycle() {
//        RecyclerView recyclerView = binding.tabview;
//        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
//                LinearLayoutManager.VERTICAL,false));
//
//        activityListAdapter = new AktivitiListAdapter(binding.getRoot().getContext());
//        recyclerView.setAdapter((activityListAdapter));
//    }
//
//    private void loadActivitiesList() {
//        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
//        List<Activities> activitiesList = db.activitiesDao().getAllActivities();
//        activityListAdapter.setActivitiesList(activitiesList);
//    }
//
//
//}