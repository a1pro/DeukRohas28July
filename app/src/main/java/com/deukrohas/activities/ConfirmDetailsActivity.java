package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deukrohas.R;
import com.deukrohas.utils.Common;

public class ConfirmDetailsActivity extends AppCompatActivity {

    private ImageView back_image;
    private RelativeLayout confirm_details;
    private TextView add_item_details;
    private LinearLayout change_package;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);
        add_item_details=findViewById(R.id.add_item_details);
        change_package=findViewById(R.id.change_package);
        add_item_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        change_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ConfirmDetailsActivity.this,MainHomeActivity.class);
//                intent.putExtra("changeintent","change");
//                startActivity(intent);
                onBackPressed();
                Common.CHANGE_PACKAGE=true;
            }
        });
        back_image=findViewById(R.id.back_image);
        confirm_details=findViewById(R.id.confirm_details);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        confirm_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConfirmDetailsActivity.this,OrderConfim.class);
                startActivity(intent);
            }
        });
    }
}
