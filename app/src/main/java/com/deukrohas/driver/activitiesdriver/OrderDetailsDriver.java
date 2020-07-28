package com.deukrohas.driver.activitiesdriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.deukrohas.R;
import com.deukrohas.activities.TrackOrder;

public class OrderDetailsDriver extends AppCompatActivity {
    private ImageView back_image;

    private Button track_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        track_order=findViewById(R.id.track_order);
        track_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderDetailsDriver.this, TrackOrder.class);
                startActivity(intent);
            }
        });
        back_image=findViewById(R.id.back_image);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
