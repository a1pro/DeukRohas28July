package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.deukrohas.R;
import com.deukrohas.retrofitclasses.ApiListener;
import com.deukrohas.retrofitclasses.RetrofitClientIntance;
import com.deukrohas.retrofitclasses.models.CreateDeliverTaskModel;
import com.deukrohas.utils.Common;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddDeliveryInfo extends AppCompatActivity {

    private EditText current_location,recieverName;
    private Button confirm;
    private ImageView back_image;
    private String location;
    private EditText mobile_number;
    private LinearLayout change_package;
    private Retrofit retrofit;
    private String latitude,longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_info);
        current_location = findViewById(R.id.current_location);
        confirm = findViewById(R.id.confirm);
        back_image = findViewById(R.id.back_image);
        recieverName=findViewById(R.id.recieverName);
        mobile_number = findViewById(R.id.mobile_number);
        change_package=findViewById(R.id.change_package);
        change_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (getIntent() != null) {
            location = getIntent().getStringExtra("location");
            latitude= getIntent().getStringExtra("latitude");
            longitude= getIntent().getStringExtra("longtitude");
        }
        if (location != null) {
            current_location.setText(location);
        }

        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        current_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDeliveryInfo.this, SetReceiverLocation.class);
                startActivity(intent);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mobile_number.getText().toString().isEmpty()) {
                    mobile_number.setError("Please enter mobile number");
                    Toast.makeText(AddDeliveryInfo.this, "Please enter mobile number", Toast.LENGTH_SHORT).show();
                } else {
                    htiCreateTaskApi(mobile_number.getText().toString());
                }
            }
        });
    }

    private void htiCreateTaskApi(String toString) {
        String name="";
        if (recieverName.getText().toString().isEmpty()){
            name="";
        }else {
            name=recieverName.getText().toString();
        }
        retrofit = RetrofitClientIntance.retroInit();
        final ApiListener apiListener = retrofit.create(ApiListener.class);
        Call<CreateDeliverTaskModel> call = apiListener.createTask(Common.TOOKAN_API_KEY,"4447584","","0"
        ,"groceries delivery",toString,"From App","app@gmail.com",current_location.getText().toString(),
                latitude,longitude,"2020-07-20 19:00:00",
                "app@example.com",name,"+125487540","frigate bay 2",
                "30.7188978","76.810298","2020-08-14 21:00:00","1","1",
                "0",1,"-330","Template_1","Template_2",
                1,"",0,0);
        call.enqueue(new Callback<CreateDeliverTaskModel>() {
            @Override
            public void onResponse(Call<CreateDeliverTaskModel> call, Response<CreateDeliverTaskModel> response) {
                if (response.isSuccessful()){
                    CreateDeliverTaskModel model=response.body();
                    if (model!=null){
                        if (model.getStatus()==200){
                            Toast.makeText(AddDeliveryInfo.this, ""+model.getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddDeliveryInfo.this, OrderConfim.class);
                            startActivity(intent);
                        }
                    }else
                    {
                        Toast.makeText(AddDeliveryInfo.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CreateDeliverTaskModel> call, Throwable t) {
                Toast.makeText(AddDeliveryInfo.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Common.CHANGE_PACKAGE){
            onBackPressed();
            Common.CHANGE_PACKAGE=false;
        }
    }
}
