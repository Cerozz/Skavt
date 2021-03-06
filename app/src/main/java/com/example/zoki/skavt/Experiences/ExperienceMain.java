package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.MainActivity;
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

public class ExperienceMain extends AppCompatActivity {

    private ListView lvExperiences;
    private String username;
    private TextView tvUsername;
    private ProgressBar spinner;

    private ArrayList<Experience> experiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvUsername.setText("Pozdravljen/a: " + username);

        spinner = (ProgressBar)findViewById(R.id.pbExperiences);

        spinner.setVisibility(View.VISIBLE);

        Button btnNewExperience = (Button) findViewById(R.id.btnNewExperience);
        btnNewExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceMain.this, ExperienceCreate.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });


        lvExperiences = (ListView) findViewById(R.id.lvExperiences);
        lvExperiences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExperienceMain.this, ExperienceDetails.class);
                Experience ex = (Experience) parent.getItemAtPosition(position);
                intent.putExtra("USERNAME", username);
                intent.putExtra("experience", ex);
                startActivity(intent);

            }
        });


        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MojSkavt loginName = (MojSkavt) getApplicationContext();
                loginName.setLoginName(null);
                Intent intent = new Intent(ExperienceMain.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        spinner.setVisibility(View.VISIBLE);
        new JSONTaskGet().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/experiences");
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
            Intent start = new Intent(ExperienceMain.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }

    public class JSONTaskGet extends AsyncTask<String, Void, ArrayList<Experience>> {

        @Override
        protected ArrayList<Experience> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();

                final Gson gson = new Gson();

                experiences = gson.fromJson(finalJson, new TypeToken<List<Experience>>() {
                }.getType());

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
            return experiences;
        }


        @Override
        protected void onPostExecute(ArrayList<Experience> result) {
            super.onPostExecute(result);

            spinner.setVisibility(View.GONE);

            ListView lvExperiences = (ListView) findViewById(R.id.lvExperiences);
            ExperienceAdapter adapter = new ExperienceAdapter(ExperienceMain.this, result);
            lvExperiences.setAdapter(adapter);

        }
    }
}
