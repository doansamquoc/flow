package com.sam.friendlens.ui.dashboard.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sam.friendlens.ui.dashboard.friend.FriendFragment;
import com.sam.friendlens.ui.dashboard.photo.PhotoFragment;
import com.sam.friendlens.ui.dashboard.setting.SettingFragment;

public class ProfilePagerAdapter extends FragmentStateAdapter {
    public ProfilePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return switch (position) {
            case 1 -> new FriendFragment();
            case 2 -> new SettingFragment();
            default -> new PhotoFragment();
        };
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
