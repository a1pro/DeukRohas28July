package com.deukrohas.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deukrohas.R;
import com.deukrohas.activities.MainHomeActivity;
import com.deukrohas.utils.SharePref;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {

    private static final int SPLASH_DELAY = 3000;

    private final Handler mHandler = new Handler();
    private NavController navController;
    private final Launcher mLauncher = new Launcher();
    private SharePref sharePref;
    private String loginType;

    public SplashFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();

        mHandler.postDelayed(mLauncher, SPLASH_DELAY);
    }

    @Override
    public void onStop() {
        mHandler.removeCallbacks(mLauncher);
        super.onStop();
    }

    private class Launcher implements Runnable {
        @Override
        public void run() {
            open();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_splash, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.coommon_nav1);
        sharePref=new SharePref(getContext());
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap=sharePref.getUserInfo();
        loginType=hashMap.get(SharePref.LOGIN_TYPE);
        return  view;
    }
    private void open() {
        if (loginType!=null){
            Intent intent = new Intent(getContext(), MainHomeActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }else {
            navController.navigate(R.id.action_splashFragment_to_loginFragment);
        }
    }
}
