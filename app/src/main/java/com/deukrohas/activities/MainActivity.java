package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.deukrohas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
