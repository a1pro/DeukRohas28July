package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.deukrohas.R;

public class YourCurrentLocaton extends AppCompatActivity {

    private LinearLayout linear;
    private ImageView back_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_current_locaton);
        back_image=findViewById(R.id.back_image);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        linear=findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(YourCurrentLocaton.this,AddDeliveryInfo.class);
                startActivity(intent);
            }
        });
    }
}
