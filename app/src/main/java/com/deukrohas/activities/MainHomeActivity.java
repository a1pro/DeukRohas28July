package com.deukrohas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deukrohas.R;
import com.deukrohas.driver.fragmentsDriver.DriverHomeFragment;
import com.deukrohas.fragments.HomeFragment;
import com.deukrohas.fragments.ItemHistoryFragment;
import com.deukrohas.fragments.Notification;
import com.deukrohas.fragments.ProfileFragment;
import com.deukrohas.utils.SharePref;
import java.util.HashMap;


public class MainHomeActivity extends AppCompatActivity {

    private LinearLayout linear_home, linear_notification, linear_itemhistory, linear_profile;
    private ImageView homeicon, notificationicon, itemhostoryicon, profileicon;
    private TextView hometext, notificationtext, itemhostorytext, profiletext;

    private SharePref sharePref;
    private String loginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        intializeUI();
        sharePref=new SharePref(this);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap=sharePref.getUserInfo();
        loginType=hashMap.get(SharePref.LOGIN_TYPE);

        if (loginType!=null){
            if (loginType.equalsIgnoreCase("1")){
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.coommon_nav2, new HomeFragment()).commit();
                }
            }else {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.coommon_nav2, new DriverHomeFragment()).commit();
                }
            }
        }


        linear_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbottombar(1);
                if (loginType!=null){
                    if (loginType.equalsIgnoreCase("1")){
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.coommon_nav2, new HomeFragment()).commit();
                    }else {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.coommon_nav2, new DriverHomeFragment()).commit();
                    }
                }
            }
        });

        linear_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbottombar(2);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.coommon_nav2, new Notification()).commit();
            }
        });

        linear_itemhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbottombar(3);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.coommon_nav2, new ItemHistoryFragment()).commit();
            }
        });

        linear_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbottombar(4);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.coommon_nav2, new ProfileFragment()).commit();
            }
        });
//        if (getIntent()!=null){
//            String packageIntent=getIntent().getStringExtra("changeintent");
//            if (packageIntent!=null) {
//                layoutBottomSheet = findViewById(R.id.bottom_sheet);
//                sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
//                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                } else {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                }
//            }
//        }
    }

    private void setbottombar(int value) {
        switch (value) {
            case 1:
                hometext.setTextColor(getResources().getColor(R.color.red));
                homeicon.setImageResource(R.mipmap.home_red);

                notificationtext.setTextColor(getResources().getColor(R.color.grey));
                notificationicon.setImageResource(R.mipmap.notification);

                itemhostorytext.setTextColor(getResources().getColor(R.color.grey));
                itemhostoryicon.setImageResource(R.mipmap.historygery);

                profiletext.setTextColor(getResources().getColor(R.color.grey));
                profileicon.setImageResource(R.mipmap.profilegrey);

                break;
            case 2:
                hometext.setTextColor(getResources().getColor(R.color.grey));
                homeicon.setImageResource(R.mipmap.home);

                notificationtext.setTextColor(getResources().getColor(R.color.red));
                notificationicon.setImageResource(R.mipmap.notification_red);

                itemhostorytext.setTextColor(getResources().getColor(R.color.grey));
                itemhostoryicon.setImageResource(R.mipmap.historygery);

                profiletext.setTextColor(getResources().getColor(R.color.grey));
                profileicon.setImageResource(R.mipmap.profilegrey);
                break;
            case 3:
                hometext.setTextColor(getResources().getColor(R.color.grey));
                homeicon.setImageResource(R.mipmap.home);

                notificationtext.setTextColor(getResources().getColor(R.color.grey));
                notificationicon.setImageResource(R.mipmap.notification);

                itemhostorytext.setTextColor(getResources().getColor(R.color.red));
                itemhostoryicon.setImageResource(R.mipmap.historyred);

                profiletext.setTextColor(getResources().getColor(R.color.grey));
                profileicon.setImageResource(R.mipmap.profilegrey);
                break;
            case 4:
                hometext.setTextColor(getResources().getColor(R.color.grey));
                homeicon.setImageResource(R.mipmap.home);

                notificationtext.setTextColor(getResources().getColor(R.color.grey));
                notificationicon.setImageResource(R.mipmap.notification);

                itemhostorytext.setTextColor(getResources().getColor(R.color.grey));
                itemhostoryicon.setImageResource(R.mipmap.historygery);

                profiletext.setTextColor(getResources().getColor(R.color.red));
                profileicon.setImageResource(R.mipmap.profile);
                break;
            default:
                hometext.setTextColor(getResources().getColor(R.color.red));
                homeicon.setImageResource(R.mipmap.home_red);

                notificationtext.setTextColor(getResources().getColor(R.color.grey));
                notificationicon.setImageResource(R.mipmap.notification);

                itemhostorytext.setTextColor(getResources().getColor(R.color.grey));
                itemhostoryicon.setImageResource(R.mipmap.historygery);

                profiletext.setTextColor(getResources().getColor(R.color.grey));
                profileicon.setImageResource(R.mipmap.profilegrey);
                break;
        }
    }

    private void intializeUI() {
        linear_home = findViewById(R.id.linear_home);
        linear_notification = findViewById(R.id.linear_notification);
        linear_itemhistory = findViewById(R.id.linear_itemhistory);
        linear_profile = findViewById(R.id.linear_profile);
        homeicon = findViewById(R.id.homeicon);
        hometext = findViewById(R.id.hometext);
        itemhostorytext= findViewById(R.id.itemhostorytext);
        notificationtext = findViewById(R.id.notificationtext);
        notificationicon = findViewById(R.id.notificationicon);
        itemhostoryicon = findViewById(R.id.itemhostoryicon);
        profileicon = findViewById(R.id.profileicon);
        profiletext= findViewById(R.id.profiletext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
