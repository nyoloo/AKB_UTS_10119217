package com.nyoloo.nyoloselfapp.ui.Daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nyoloo.nyoloselfapp.database.AppDatabase;
import com.nyoloo.nyoloselfapp.database.Friend;
import com.nyoloo.nyoloselfapp.databinding.FriendsFragmentBinding;

import java.util.List;


// Kelas                : IF-6
public class FriendsFragment extends Fragment {

    private FriendsListAdapter friendListAdapter;

    private FriendsFragmentBinding binding;
    public static FriendsFragment newInstance() {
        return new FriendsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FriendsFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadFriendList();

        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewFriends;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.HORIZONTAL,false));

        friendListAdapter = new FriendsListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((friendListAdapter));
    }

    private void loadFriendList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Friend> friendList = db.friendDao().getAllFriends();
        friendListAdapter.setFriendList(friendList);
    }



}
