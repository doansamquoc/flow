package com.sam.friendlens.ui.dashboard.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sam.friendlens.R;
import com.sam.friendlens.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private ViewPager2 viewPager;

    private TabLayout tabLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = binding.profileTabViewPager;
        tabLayout = binding.profileTabLayout;

        viewPager.setAdapter(new ProfilePagerAdapter(this));
        handleTabChange();
    }

    private void handleTabChange() {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.gallery_on);
                    break;
                case 1:
                    tab.setIcon(R.drawable.users);
                    break;
                case 2:
                    tab.setIcon(R.drawable.settings_sliders);
                    break;
            }
        }).attach();
    }
}