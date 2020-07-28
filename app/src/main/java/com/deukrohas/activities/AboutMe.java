package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.deukrohas.R;

public class AboutMe extends AppCompatActivity {

    private ImageView back_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        intializeUI();
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void intializeUI() {
        back_image=findViewById(R.id.back_image);
    }
}
