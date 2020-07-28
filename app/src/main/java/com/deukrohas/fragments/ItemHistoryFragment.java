package com.deukrohas.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.deukrohas.R;
import com.deukrohas.activities.OrderDetails;
import com.deukrohas.adapter.ItemHistoryAdapter;
import com.deukrohas.interfaces.ItemHistoryClickListener;
import com.deukrohas.retrofitclasses.ApiListener;
import com.deukrohas.retrofitclasses.RetrofitClientIntance;
import com.deukrohas.retrofitclasses.models.CreateDeliverTaskModel;
import com.deukrohas.retrofitclasses.models.GetAllTaskModel;
import com.deukrohas.utils.Common;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemHistoryFragment extends Fragment {

    //    private RelativeLayout item_history_relative,item_history_relative2,item_history_relative3;
    private RecyclerView item_history_recycler;
    private Retrofit retrofit;
    private ItemHistoryAdapter adapter;
    private List<GetAllTaskModel.Datum> list=new ArrayList<>();
    private ProgressBar progress_bar;
    private ItemHistoryClickListener itemHistoryClickListener;

    public ItemHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_history, container, false);
        intialUi(view);
        progress_bar.setVisibility(View.VISIBLE);
        itemHistoryClickListener=new ItemHistoryClickListener() {
            @Override
            public void onClick(int jobId) {
                getDetails(jobId);
            }
        };
        hitGetAllTaskApi();
        adapter = new ItemHistoryAdapter(list, getContext(),itemHistoryClickListener);
        item_history_recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        item_history_recycler.setLayoutManager(linearLayoutManager);
        item_history_recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    private void getDetails(int jobId) {
        Intent intent=new Intent(getContext(),OrderDetails.class);
        intent.putExtra("jobId",""+jobId);
        startActivity(intent);
    }

    private void hitGetAllTaskApi() {
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("api_key", "516b6685f446481f43127670504b254314edc1f92dd97b385e1405");
            paramObject.put("job_status", 0);
            paramObject.put("job_type", 0);
            paramObject.put("start_date", "2020-07-01");
            paramObject.put("end_date", "2030-07-30");
            paramObject.put("custom_fields", 0);
            paramObject.put("is_pagination", 1);
            paramObject.put("requested_page", 1);
            paramObject.put("customer_id", "");
            paramObject.put("fleet_id", 0);
            paramObject.put("team_id", 440310);
            retrofit = RetrofitClientIntance.retroInit();
            final ApiListener apiListener = retrofit.create(ApiListener.class);

            Call<GetAllTaskModel> userCall = apiListener.getAllTask(paramObject.toString());
//        Call<GetAllTaskModel> call = apiListener.getAllTask(
//                "516b6685f446481f43127670504b254314edc1f92dd97b385e1405",
//                0,
//                0,
//                "2020-07-01",
//                "2022-07-30",
//                0,
//                1,
//                1,
//                "",
//                0,
//                0
//                );
            userCall.enqueue(new Callback<GetAllTaskModel>() {
                @Override
                public void onResponse(Call<GetAllTaskModel> call, Response<GetAllTaskModel> response) {
                    progress_bar.setVisibility(View.GONE);
                    if (response.isSuccessful()) {


                        GetAllTaskModel model = response.body();
                        // Log.e("resoponedata",""+model.getData());
                        if (model != null) {
                            if (model.getStatus() == 200) {
                             //   Toast.makeText(getContext(), "" + model.getData().size(), Toast.LENGTH_SHORT).show();
                                for (int i = 0; i < model.getData().size(); i++) {
                                    list.add(model.getData().get(i));
                                    adapter = new ItemHistoryAdapter(list, getContext(),itemHistoryClickListener);
                                    item_history_recycler.setAdapter(adapter);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GetAllTaskModel> call, Throwable t) {
                    progress_bar.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            progress_bar.setVisibility(View.GONE);
            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void intialUi(View view) {
        item_history_recycler = view.findViewById(R.id.item_history_recycler);
        progress_bar= view.findViewById(R.id.progress_bar);
    }
}
