package com.example.zoki.skavt;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ExperienceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);

        Intent intent = getIntent();
        String ExperienceID = intent.getStringExtra("POSITION");

        new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences/" + ExperienceID);

        ImageView im = (ImageView)findViewById(R.id.imageView);
        //im.setImageResource(R.drawable.paklenica);

        RatingBar rateExperience = (RatingBar)findViewById(R.id.ratingBar);
        rateExperience.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast = Toast.makeText(getApplicationContext(), "Izkušnjo si ocenil z oceno: " + rating, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public class JSONTaskGet extends AsyncTask<String, ArrayList<Izkusnja>, Izkusnja> {

        @Override
        protected Izkusnja doInBackground(String... params) {
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

                JSONObject finalObject = new JSONObject(finalJson);
                Izkusnja iz = new Izkusnja(finalObject.getInt("ExperienceID"),finalObject.getString("Title"), finalObject.getString("Details"), finalObject.getInt("CatID"));
                return iz;

            } catch (JSONException | IOException e) {
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
        protected void onPostExecute(Izkusnja result) {
            super.onPostExecute(result);
            TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
            TextView tvDetails = (TextView)findViewById(R.id.tvDetails);
            if (result != null){
                tvTitle.setText(result.Naslov);
                tvDetails.setText(result.Opis);

            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "Napaka pri komunikaciji z strežnikom", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }




}
