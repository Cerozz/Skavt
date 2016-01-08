package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ExperienceDetails extends AppCompatActivity {

    private Button btnLike;
    private TextView tvTitle, tvDetails, tvLike, tvAuthor, tvCategory;
    private int numberOfLikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);

        Intent intent = getIntent();
        String ExperienceID = intent.getStringExtra("POSITION");

        new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences/" + ExperienceID);

        btnLike = (Button) findViewById(R.id.btnLike);
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfLikes++;
                tvLike.setText("Število všečkov: " + Integer.toString(numberOfLikes));
                btnLike.setEnabled(false);
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

    public class JSONTaskGet extends AsyncTask<String, ArrayList<Experience>, Experience> {

        @Override
        protected Experience doInBackground(String... params) {
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
                Experience ex = gson.fromJson(finalJson, Experience.class);

                return ex;
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
            return null;
        }


        @Override
        protected void onPostExecute(Experience result) {
            super.onPostExecute(result);
            tvTitle = (TextView) findViewById(R.id.tvTitle);
            tvDetails = (TextView) findViewById(R.id.tvDetails);
            tvLike = (TextView) findViewById(R.id.tvLike);
            tvAuthor = (TextView) findViewById(R.id.tvAuthor);
            if (result != null) {
                tvTitle.setText(result.Title);
                tvAuthor.setText("Avtor: " + result.Author);
                tvDetails.setText(result.Details);
                numberOfLikes = result.Likes;
                tvLike.setText("Število všečkov: " + Integer.toString(numberOfLikes));
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Napaka pri komunikaciji z strežnikom", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }

}
