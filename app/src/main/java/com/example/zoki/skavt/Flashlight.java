package com.example.zoki.skavt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myString = "001001001000001000001000001001001001";
                for (int i = 0; i < myString.length(); i++) {
                    if (myString.charAt(i) == '0') {
                        try {
                            manager.setTorchMode("0", true);
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            manager.setTorchMode("0", false);
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.info) {
            Intent start = new Intent(Flashlight.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }
}

