package com.deukrohas.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.deukrohas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private TextView customer, driver;
    private Button signup_login;
    private NavController navController;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        intializeView(view);
        signup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_signUpFragment_to_loginFragment);
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.setTextColor(Color.WHITE);
                driver.setTextColor(Color.BLACK);
                customer.setBackgroundResource(R.drawable.left_round_back);
                driver.setBackgroundResource(R.drawable.right_round_back);
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.setTextColor(Color.BLACK);
                driver.setTextColor(Color.WHITE);
                customer.setBackgroundResource(R.drawable.left_round2_back);
                driver.setBackgroundResource(R.drawable.right_round2_back);
            }
        });
    return view;
    }

    private void intializeView(View view) {
        navController = Navigation.findNavController(getActivity(), R.id.coommon_nav1);
        customer = view.findViewById(R.id.customer);
        driver = view.findViewById(R.id.reciever);
        signup_login=view.findViewById(R.id.signup_login);
    }
}
