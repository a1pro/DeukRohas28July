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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.deukrohas.R;
import com.deukrohas.activities.MainHomeActivity;
import com.deukrohas.utils.SharePref;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private Button login_register,login_guest;
    private ImageView login_button;
    private NavController navController;
    private EditText login_email;
    private SharePref sharePref;
    private String loginType;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        intializeView(view);
        sharePref=new SharePref(getContext());
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loginFragment_to_signUpFragment);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_email.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                }else {
                    sharePref.setEmail(login_email.getText().toString().trim());
                    if (login_email.getText().toString().matches("sender@gmail.com")) {
                        Intent intent = new Intent(getContext(), MainHomeActivity.class);
                        getActivity().startActivity(intent);
                        getActivity().finish();
                        sharePref.setLoginType("1");
                    } else if (login_email.getText().toString().matches("receiver@gmail.com")) {
                        sharePref.setLoginType("2");
                        Intent intent = new Intent(getContext(), MainHomeActivity.class);
                        getActivity().startActivity(intent);
                        getActivity().finish();
                    }

                }
            }
        });
        login_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainHomeActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    private void intializeView(View view) {
        sharePref=new SharePref(getContext());
        navController = Navigation.findNavController(getActivity(), R.id.coommon_nav1);
        login_register=view.findViewById(R.id.login_register);
        login_button=view.findViewById(R.id.login_button);
        login_guest=view.findViewById(R.id.login_guest);
        login_email=view.findViewById(R.id.login_email);
    }
}
