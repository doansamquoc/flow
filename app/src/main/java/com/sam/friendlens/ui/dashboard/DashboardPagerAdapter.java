package com.sam.friendlens.ui.dashboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sam.friendlens.ui.dashboard.activity.ActivityFragment;
import com.sam.friendlens.ui.dashboard.home.HomeFragment;
import com.sam.friendlens.ui.dashboard.new_feed.NewFeedFragment;
import com.sam.friendlens.ui.dashboard.profile.ProfileFragment;
import com.sam.friendlens.ui.dashboard.search.SearchFragment;

public class DashboardPagerAdapter extends FragmentStateAdapter {
    public DashboardPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return switch (position) {
            case 1 -> new SearchFragment();
            case 2 -> new NewFeedFragment();
            case 3 -> new ActivityFragment();
            case 4 -> new ProfileFragment();
            default -> new HomeFragment();
        };
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
