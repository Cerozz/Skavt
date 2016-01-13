package com.example.zoki.skavt;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class Postopek extends AppCompatActivity {

    ViewPager viewPager;
    AdapterSwipe adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postopek);
        final String title = getIntent().getExtras().getString("ime");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new AdapterSwipe(this, title);
        viewPager.setAdapter(adapter);
    }
}
