package com.example.zoki.skavt;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


public class Flashlight extends AppCompatActivity {

    private CameraManager manager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);
        try {
            manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        SharedPreferences sharedPrefs = getSharedPreferences("com.example.zoki.skavt", MODE_PRIVATE);
        toggle.setChecked(sharedPrefs.getBoolean("togg", true));
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try {
                        manager.setTorchMode("0", true);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.zoki.skavt", MODE_PRIVATE).edit();
                    editor.putBoolean("togg", true);
                    editor.commit();
                } else {
                    try {
                        manager.setTorchMode("0", false);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("com.example.zoki.skavt", MODE_PRIVATE).edit();
                    editor.putBoolean("togg", false);
                    editor.commit();
                }
            }

        });
    }
}

