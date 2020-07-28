package com.deukrohas.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deukrohas.R;
import com.deukrohas.activities.AboutMe;
import com.deukrohas.activities.MainHomeActivity;
import com.deukrohas.utils.Common;
import com.deukrohas.utils.SharePref;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private RelativeLayout relative, relative3;
    private ImageView logout;
    private SharePref sharePref;
    private SwitchCompat switchCompat;
    private TextView switch_text;
    private String loginType;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        sharePref = new SharePref(getContext());
        intializeUI(view);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = sharePref.getUserInfo();
        loginType = hashMap.get(SharePref.LOGIN_TYPE);

        if (loginType != null) {
            if (loginType.equalsIgnoreCase("1")) {
                switch_text.setText("Receiver");
            } else {
                switch_text.setText("Sender");
            }
        }
        if (Common.CHANGE_TYPE){
            switchCompat.setChecked(true);
        }else {
            switchCompat.setChecked(false);
        }
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AboutMe.class);
                getActivity().startActivity(intent);
            }
        });

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()) {
                    if (loginType.equalsIgnoreCase("1")) {
                        sharePref.setLoginType("2");
                    } else {
                        sharePref.setLoginType("1");
                    }
                    Common.CHANGE_TYPE=false;
                    switchCompat.setChecked(false);
                    Intent intent=new Intent(getContext(), MainHomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    if (loginType.equalsIgnoreCase("1")) {
                        sharePref.setLoginType("2");
                    } else {
                        sharePref.setLoginType("1");
                    }
                    Common.CHANGE_TYPE=true;
                    switchCompat.setChecked(true);
                    Intent intent=new Intent(getContext(), MainHomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePref.logoutUser(getContext());
            }
        });
        return view;
    }

    private void intializeUI(View view) {
        relative = view.findViewById(R.id.relative);
        relative3 = view.findViewById(R.id.relative3);
        logout = view.findViewById(R.id.logout);
        switchCompat = view.findViewById(R.id.switchCompat);
        switch_text = view.findViewById(R.id.switch_text);
    }
}
