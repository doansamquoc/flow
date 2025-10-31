package com.sam.friendlens.ui.dashboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sam.friendlens.ui.dashboard.camera.CameraFragment;
import com.sam.friendlens.ui.dashboard.home.HomeFragment;
import com.sam.friendlens.ui.dashboard.message.MessageFragment;
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
            case 0 -> new HomeFragment();
            case 1 -> new SearchFragment();
            case 3 -> new MessageFragment();
            case 4 -> new ProfileFragment();
            default -> new CameraFragment();
        };
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
