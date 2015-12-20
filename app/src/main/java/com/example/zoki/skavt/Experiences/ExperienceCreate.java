package com.example.zoki.skavt.Experiences;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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

        //dropdown za izbiranje
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button postExperience = (Button)findViewById(R.id.btnPostExperience);
        postExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTaskPost().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences/");
            }
        });
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
