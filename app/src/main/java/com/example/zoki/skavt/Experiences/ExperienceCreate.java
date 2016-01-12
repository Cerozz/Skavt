package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class ExperienceCreate extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_create);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");

        final EditText etTitle = (EditText)findViewById(R.id.etNewExperienceTitle);
        final EditText etDetails = (EditText)findViewById(R.id.etNewExperienceDetails);

        Button postExperience = (Button) findViewById(R.id.btnPostExperience);
        postExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTaskExperiencePost().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/experiences/" + etTitle.getText().toString() + "/" + etDetails.getText().toString() + "/" + username);
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
            Intent start = new Intent(ExperienceCreate.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }

    public class JsonTaskExperiencePost extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String finalJson = "";
            try {
                URL url = new URL(params[0].replace(" ", "%20"));

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.connect();
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                finalJson = buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return finalJson;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                    .coordinatorLayout);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Izkušnja je bila objavljena!", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
    }
}
