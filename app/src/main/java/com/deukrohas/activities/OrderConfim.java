package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.deukrohas.R;

public class OrderConfim extends AppCompatActivity {

    private ImageView back_image;

    private Button track_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confim);
        back_image=findViewById(R.id.back_image);
        track_order=findViewById(R.id.track_order);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        track_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderConfim.this,TrackOrder.class);
                startActivity(intent);
            }
        });
    }

}
