package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExperienceDetails extends AppCompatActivity {

    private Button btnLike;
    private TextView tvTitle;
    private TextView tvDetails;
    private TextView tvLike;
    private TextView tvAuthor;
    private int numberOfLikes;
    private Experience experience;
    private Button btnDelete;
    private CoordinatorLayout coordinatorLayout;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");

        experience = (Experience) getIntent().getSerializableExtra("experience");

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDetails = (TextView) findViewById(R.id.tvDetails);
        tvLike = (TextView) findViewById(R.id.tvLike);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        tvTitle.setText(experience.Title);
        tvAuthor.setText("Avtor: " + experience.Author);
        tvDetails.setText(experience.Details);
        numberOfLikes = experience.Likes;
        tvLike.setText("Število všečkov: " + Integer.toString(numberOfLikes));



        btnLike = (Button) findViewById(R.id.btnLike);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTaskPostLike().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/likes/" + Integer.toString(experience.ExperienceID));
            }
        });

        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(experience.Author.equals(username)){
                    new JsonTaskDeleteExperience().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/experiences/" +Integer.toString(experience.ExperienceID));
                }
                else{
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Odstranite lahko le svoje izkušnje!", Snackbar.LENGTH_LONG);
                    snackbar.show();
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
            Intent start = new Intent(ExperienceDetails.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }

    public class JSONTaskPostLike extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String finalJson = "";
            try {
                URL url = new URL(params[0]);
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
            tvLike.setText("Število všečkov: " + result);
        }
    }

    public class JsonTaskDeleteExperience extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String finalJson = "";
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
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
            if (result.equals("true"))
            {
                Intent intent = new Intent(ExperienceDetails.this, ExperienceMain.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        }
    }
}
