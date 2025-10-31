package com.sam.friendlens.ui.dashboard.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Timestamp;
import com.sam.friendlens.data.dto.ConversationItem;
import com.sam.friendlens.data.model.Conversation;
import com.sam.friendlens.data.model.User;
import com.sam.friendlens.databinding.FragmentMessageBinding;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {
    private FragmentMessageBinding binding;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMessageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.conversationRecyclerView;

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new ConversationAdapter(getSampleConversations()));
    }

    private List<ConversationItem> getSampleConversations() {
        List<ConversationItem> list = new ArrayList<>();
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u2", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );
        list.add(
                new ConversationItem(
                        new Conversation("1", Instant.now(), Instant.now(), "u1", "u2", "Hello", "u1", Timestamp.now()),
                        new User("u1", Instant.now(), Instant.now(), "doan", "Doan Sam", "https://m.yodycdn.com/blog/gigachad-meme-yodyvn4.jpg", "doan@gmail.com", "Male", "05-26-2004"))
        );

        return list;
    }
}