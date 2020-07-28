package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.deukrohas.R;
import com.deukrohas.retrofitclasses.ApiListener;
import com.deukrohas.retrofitclasses.RetrofitClientIntance;
import com.deukrohas.retrofitclasses.models.GetAllTaskModel;
import com.deukrohas.retrofitclasses.models.GetTaskDetailModel;
import com.deukrohas.utils.SharePref;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderDetails extends AppCompatActivity {

    private Button track_order;
    private ImageView back_image;
    private SharePref sharePref;
    private String loginType;
    private Retrofit retrofit;
    private TextView order_details_item_sent_on, order_details_receiver_address,
            order_details_receiver_number, order_details_receiver_name, order_details_pickup_mobile_number,
            order_details_pickup_address, order_details_order_id,order_details_status;
    private LinearLayout order_details_linear;
    private ProgressBar progress_bar;
    private String trackingLink,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        intializeUI();
        progress_bar.setVisibility(View.VISIBLE);
        if (getIntent() != null) {
            String jobId = getIntent().getStringExtra("jobId");
            if (jobId != null) {
                order_details_order_id.setText("Order ID: " + jobId);
                int jobid = Integer.parseInt(jobId);
                hitGetDetailsApi(jobid);
            }
        }
        sharePref = new SharePref(this);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = sharePref.getUserInfo();
        loginType = hashMap.get(SharePref.LOGIN_TYPE);

        if (loginType != null) {
            if (loginType.equalsIgnoreCase("1")) {
                track_order.setVisibility(View.VISIBLE);
            } else {
                track_order.setVisibility(View.GONE);
            }
        }
        track_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetails.this, TrackOrder.class);
                intent.putExtra("URL",""+trackingLink);
                intent.putExtra("Status",""+status);
                startActivity(intent);
            }
        });
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void hitGetDetailsApi(int jobid) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(jobid);
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("api_key", "516b6685f446481f43127670504b254314edc1f92dd97b385e1405");
            paramObject.put("job_ids", (Object) arr);
            paramObject.put("include_task_history", 440310);


            retrofit = RetrofitClientIntance.retroInit();
            final ApiListener apiListener = retrofit.create(ApiListener.class);

            Call<GetTaskDetailModel> userCall = apiListener.getTaskDetails("516b6685f446481f43127670504b254314edc1f92dd97b385e1405",
                    arr, 0);
            userCall.enqueue(new Callback<GetTaskDetailModel>() {
                @Override
                public void onResponse(Call<GetTaskDetailModel> call, Response<GetTaskDetailModel> response) {
                    progress_bar.setVisibility(View.GONE);
                    if (response.isSuccessful()) {

                        order_details_linear.setVisibility(View.VISIBLE);
                        GetTaskDetailModel model = response.body();
                        if (model != null) {
                            if (model.getStatus() == 200) {
                                for (int i = 0; i < model.getData().size(); i++) {

                                    order_details_pickup_address.setText(model.getData().get(i).getJobPickupAddress());

                                    order_details_pickup_mobile_number.setText(model.getData().get(i).getJobPickupPhone());

                                    order_details_receiver_name.setText(model.getData().get(i).getCustomerUsername());

                                    order_details_receiver_number.setText(model.getData().get(i).getCustomerPhone());

                                    order_details_receiver_address.setText(model.getData().get(i).getJobAddress());

                                    order_details_item_sent_on.setText(model.getData().get(i).getJobPickupDatetime());
                                    trackingLink=model.getData().get(i).getTrackingLink();
                                    track_order.setVisibility(View.VISIBLE);
                                    int i1=model.getData().get(i).getJobStatus();
                                    if (i1==0){
                                        status=String.valueOf(i1);
                                        order_details_status.setText("Assigned");
                                    }else if (i1==1){
                                        status=String.valueOf(i1);
                                        order_details_status.setText("Ongoing");
                                    }else if (i1==2){
                                        status=String.valueOf(i1);
                                        order_details_status.setText("Completed");
                                    }
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GetTaskDetailModel> call, Throwable t) {
                    progress_bar.setVisibility(View.GONE);
                    Toast.makeText(OrderDetails.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (
                JSONException e) {
            progress_bar.setVisibility(View.GONE);
            Toast.makeText(OrderDetails.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void intializeUI() {
        track_order = findViewById(R.id.track_order);
        back_image = findViewById(R.id.back_image);
        order_details_item_sent_on = findViewById(R.id.order_details_item_sent_on);
        order_details_pickup_address = findViewById(R.id.order_details_pickup_address);
        order_details_pickup_mobile_number = findViewById(R.id.order_details_pickup_mobile_number);
        order_details_receiver_name = findViewById(R.id.order_details_receiver_name);
        order_details_receiver_number = findViewById(R.id.order_details_receiver_number);
        order_details_receiver_address = findViewById(R.id.order_details_receiver_address);
        order_details_order_id = findViewById(R.id.order_details_order_id);
        order_details_linear = findViewById(R.id.order_details_linear);
        progress_bar = findViewById(R.id.progress_bar);
        order_details_status=findViewById(R.id.order_details_status);
    }
}
