package com.deukrohas.driver.fragmentsDriver;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.deukrohas.R;
import com.deukrohas.driver.activitiesdriver.OrderDetailsDriver;

/**
 * A simple {@link Fragment} subclass.
 */
public class DriverHomeFragment extends Fragment {

    private SwitchCompat switchCompat;
    private LinearLayout offlineLinear;
    private ScrollView onlineScroll;
    private CardView cardView1,cardView2,cardView3,cardView4;
    private TextView driver_status;



    public DriverHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_driver_home, container, false);
        switchCompat=view.findViewById(R.id.switchCompat);
        offlineLinear=view.findViewById(R.id.offlineLinear);
        onlineScroll=view.findViewById(R.id.onlineScroll);
        driver_status=view.findViewById(R.id.driver_status);
        cardView1=view.findViewById(R.id.cardView1);
        cardView2=view.findViewById(R.id.cardView2);
        cardView3=view.findViewById(R.id.cardView3);
        cardView4=view.findViewById(R.id.cardView4);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), OrderDetailsDriver.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), OrderDetailsDriver.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), OrderDetailsDriver.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), OrderDetailsDriver.class);
                startActivity(intent);
            }
        });
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()){
                    driver_status.setText("Online");
                    onlineScroll.setVisibility(View.VISIBLE);
                    offlineLinear.setVisibility(View.GONE);
                }else {
                    driver_status.setText("Offline");
                    onlineScroll.setVisibility(View.GONE);
                    offlineLinear.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }
}
