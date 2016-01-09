package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class ExperienceCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_create);

        Button postExperience = (Button) findViewById(R.id.btnPostExperience);
        postExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTaskPost().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences/");
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

    public class JsonTaskPost extends AsyncTask<String, ArrayList<Experience>, ArrayList<Experience>> {

        @Override
        protected ArrayList<Experience> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String message = new JSONObject().toString();
            InputStream is = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.connect();


                //setup send
                OutputStream os = new BufferedOutputStream(connection.getOutputStream());
                os.write(message.getBytes());
                //clean up
                os.flush();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
            return null;
        }


        @Override
        protected void onPostExecute(ArrayList<Experience> result) {
            super.onPostExecute(result);


            Toast toast = Toast.makeText(getApplicationContext(), "Izkušnja je bila objavljena", Toast.LENGTH_SHORT);
            toast.show();

        }
    }
}
