package com.deukrohas.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.deukrohas.fragments.HomeFragment;
import com.deukrohas.fragments.ItemHistoryFragment;
import com.deukrohas.fragments.Notification;
import com.deukrohas.fragments.ProfileFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new HomeFragment();
        }
        else if (position == 1)
        {
            fragment = new Notification();
        }
        else if (position == 2)
        {
            fragment = new ItemHistoryFragment();
        }
        else if (position == 3)
        {
            fragment = new ProfileFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Home";
        }
        else if (position == 1)
        {
            title = "Notification";
        }
        else if (position == 2)
        {
            title = "Item History";
        }
        else if (position == 3)
        {
            title = "Profile";
        }
        return title;
    }
}
