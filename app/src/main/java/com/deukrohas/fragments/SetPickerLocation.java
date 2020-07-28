package com.deukrohas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deukrohas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetPickerLocation extends Fragment {

    public SetPickerLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_picker_location, container, false);
    }
}
