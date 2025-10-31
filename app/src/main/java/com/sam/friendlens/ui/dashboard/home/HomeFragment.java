package com.sam.friendlens.ui.dashboard.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.friendlens.data.model.Media;
import com.sam.friendlens.data.model.Post;
import com.sam.friendlens.data.model.PostDisplay;
import com.sam.friendlens.data.model.User;
import com.sam.friendlens.databinding.FragmentHomeBinding;
import com.sam.friendlens.ui.dashboard.PostAdapter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = binding.postRecyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PostAdapter(getSamplePosts()));

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

    }

    private List<PostDisplay> getSamplePosts() {
        List<PostDisplay> list = new ArrayList<>();
        list.add(new PostDisplay(
                new Post("1", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("2", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("1", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("2", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("1", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("2", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("1", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day aksdj akjd kasjd kajkd jasjakjdkajdkakajd k akdjka  adak kadkaj ka akdj ak akjd   ajdka jaj ajkd kas kaj adkajakj a ka sk ajk akjajdjad ajdkjada jkdja kd"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("2", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("1", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        list.add(new PostDisplay(
                new Post("2", Instant.now(), Instant.now(), "u2", "Ha Noi", "Beautiful day"),
                new Media("m2", Instant.now(), Instant.now(), "2", "Image", "https://picsum.photos/601/900", 1),
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004"),
                22, true, 7, true
        ));
        return list;
    }
}