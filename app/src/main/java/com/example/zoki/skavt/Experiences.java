package com.example.zoki.skavt;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Experiences extends AppCompatActivity {

    private ListView lvExperiences;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiences);

        new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences");

        Button btnNewExperience = (Button)findViewById(R.id.btnNewExperience);
        btnNewExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Experiences.this, CreateExperience.class);
                startActivity(intent);
            }
        });

        lvExperiences = (ListView)findViewById(R.id.lvExperiences);
        lvExperiences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Experiences.this, ExperienceDetails.class);
                intent.putExtra("POSITION", Integer.toString(position));
                startActivity(intent);
            }
        });
    }

    public class JSONTaskGet extends AsyncTask<String, ArrayList<Izkusnja>, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params) {
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

                JSONArray finalObject = new JSONArray(finalJson);
                ArrayList<String> izkusnje = new ArrayList<>();
                for (int i = 0; i < finalObject.length(); i++) {
                    try {
                        JSONObject bla = finalObject.getJSONObject(i);
                        String naslov = bla.getString("Title");
                        izkusnje.add(i, naslov);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                return izkusnje;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
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
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);

            ArrayAdapter adapter = new ArrayAdapter<String>(Experiences.this, R.layout.row_list, result);

            if (result != null){
                lvExperiences.setAdapter(adapter);
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "Napaka pri komunikaciji z strežnikom", Toast.LENGTH_SHORT);
                toast.show();

            }

        }
    }
}
