package com.deukrohas.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deukrohas.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class TrackOrder extends AppCompatActivity {

    private ImageView backImage;
    private RelativeLayout track_bottom_sheet;
    public static BottomSheetBehavior sheetBehavior;
    public LinearLayout layoutBottomSheet;
    private WebView webview;
    private ProgressBar progress_bar;
    private TextView item_delivery,item_pickup,item_placed,item_placed_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order);
        intializeUi();
        progress_bar.setVisibility(ProgressBar.VISIBLE);
        if (getIntent() != null) {
            String url = getIntent().getStringExtra("URL");
            String status = getIntent().getStringExtra("Status");
            if (status != null) {
                int i = Integer.parseInt(status);
                if (i == 0) {
                    item_placed.setTextColor(getResources().getColor(R.color.red));
                    item_placed_time.setTextColor(getResources().getColor(R.color.red));
                    item_delivery.setTextColor(getResources().getColor(R.color.grey));
                    item_pickup.setTextColor(getResources().getColor(R.color.grey));
                } else if (i == 1) {
                    item_placed.setTextColor(getResources().getColor(R.color.red));
                    item_placed_time.setTextColor(getResources().getColor(R.color.red));
                    item_delivery.setTextColor(getResources().getColor(R.color.grey));
                    item_pickup.setTextColor(getResources().getColor(R.color.red));
                } else if (i == 2) {
                    item_placed.setTextColor(getResources().getColor(R.color.red));
                    item_placed_time.setTextColor(getResources().getColor(R.color.red));
                    item_delivery.setTextColor(getResources().getColor(R.color.red));
                    item_pickup.setTextColor(getResources().getColor(R.color.red));
                }
            }
            if (url != null) {
                loadUrl(url);
                webview.setWebViewClient(new WebViewClient() {

                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                        progress_bar.setVisibility(ProgressBar.VISIBLE);
                        webview.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onPageCommitVisible(WebView view, String url) {
                        super.onPageCommitVisible(view, url);
                        progress_bar.setVisibility(ProgressBar.GONE);
                        webview.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        track_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
            }
        });
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
//                                CoordinatorLayout.LayoutParams.WRAP_CONTENT);
//                        params.setMargins(0, 250, 0, 0);
//                        layoutBottomSheet.setLayoutParams(params);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        break;
                    }
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadUrl(String url) {
        WebSettings settings = webview.getSettings();

        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setDomStorageEnabled(true);
        webview.clearView();
        webview.measure(100, 100);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.loadUrl(url);

    }

    private void intializeUi() {
        backImage = findViewById(R.id.back_image);
        track_bottom_sheet = findViewById(R.id.track_bottom_sheet);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        webview = findViewById(R.id.webview);
        progress_bar = findViewById(R.id.progress_bar);

        item_delivery = findViewById(R.id.item_delivery);
        item_pickup = findViewById(R.id.item_pickup);
        item_placed = findViewById(R.id.item_placed);
        item_placed_time = findViewById(R.id.item_placed_time);
    }

    private void toggleBottomSheet() {

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }
}
