package com.deukrohas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deukrohas.R;
import com.deukrohas.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainHomeFragment extends Fragment {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    public MainHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_home, container, false);
        viewPager = view.findViewById(R.id.mainHomeViewPager);
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout =  view.findViewById(R.id.mainHomeTablayout);
        tabLayout.setupWithViewPager(viewPager);
    return  view;}
}
