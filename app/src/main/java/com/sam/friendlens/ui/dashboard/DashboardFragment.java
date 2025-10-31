package com.sam.friendlens.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sam.friendlens.R;
import com.sam.friendlens.data.model.User;
import com.sam.friendlens.databinding.FragmentDashboardBinding;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private ViewPager2 pageViewPager;
    private BottomNavigationView bottomNav;
    private final ViewPager2.OnPageChangeCallback onPageChangedCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            onPageChanged(position);
        }
    };

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pageViewPager = binding.pageViewPager;
        bottomNav = binding.bottomNav;

        pageViewPager.setAdapter(new DashboardPagerAdapter(this));
        pageViewPager.registerOnPageChangeCallback(onPageChangedCallback);
        bottomNav.setOnItemSelectedListener(this::onNavItemSelected);
    }

    private List<User> getSampleFriends() {
        List<User> friends = new ArrayList<>();
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        friends.add(
                new User("u2", Instant.now(), Instant.now(), "bob2004", "Bob", "https://picsum.photos/101", "bob@gmail.com", "Male", "05-26-2004")
        );
        return friends;
    }

    private boolean onNavItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home_page) {
            pageViewPager.setCurrentItem(0, true);
            return true;
        } else if (id == R.id.action_search_page) {
            pageViewPager.setCurrentItem(1, true);
            return true;
        } else if (id == R.id.action_camera_page) {
            pageViewPager.setCurrentItem(2, true);
            return true;
        } else if (id == R.id.action_message_page) {
            pageViewPager.setCurrentItem(3, true);
            return true;
        } else if (id == R.id.action_profile_page) {
            pageViewPager.setCurrentItem(4, true);
            return true;
        }
        return false;
    }

    private void onPageChanged(int position) {
        bottomNav.getMenu().getItem(position).setChecked(true);
    }
}

