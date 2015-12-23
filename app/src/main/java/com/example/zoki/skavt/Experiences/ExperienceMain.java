package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;

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

public class ExperienceMain extends AppCompatActivity {

    private ListView lvExperiences, lvMyExperiences;
    private String username;
    private TextView tvUsername;

    private ArrayList<String> my_experience, experiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvUsername.setText("Pozdravljen/a: " + username);


        new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/experiences");

        Button btnNewExperience = (Button) findViewById(R.id.btnNewExperience);
        btnNewExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceMain.this, ExperienceCreate.class);
                startActivity(intent);
            }
        });


        lvExperiences = (ListView) findViewById(R.id.lvExperiences);
        lvExperiences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExperienceMain.this, ExperienceDetails.class);
                intent.putExtra("POSITION", Integer.toString(position));
                startActivity(intent);
            }
        });

        lvMyExperiences = (ListView) findViewById(R.id.lvMyExperiences);
        lvMyExperiences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExperienceMain.this, ExperienceDetails.class);
                intent.putExtra("POSITION", Integer.toString(position));
                startActivity(intent);
            }
        });
    }


    public class JSONTaskGet extends AsyncTask<String, Void, ArrayList<String>> {

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
                experiences = new ArrayList<>();
                my_experience = new ArrayList<>();
                for (int i = 0; i < finalObject.length(); i++) {
                    try {
                        JSONObject odgovor = finalObject.getJSONObject(i);
                        String title = odgovor.getString("Title");
                        String author = odgovor.getString("Author");
                        String likes = Integer.toString(odgovor.getInt("Likes"));
                        experiences.add(i, title + "\n" + "Avtor: " + author + ",  " + "Všečki: " + likes);
                        if (author.equals(username)) {
                            my_experience.add(title + ",  " + "Všečki: " + likes);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                return experiences;

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

            ArrayAdapter adapter_all = new ArrayAdapter<String>(ExperienceMain.this, R.layout.row_list, result);
            ArrayAdapter adapter_my = new ArrayAdapter<String>(ExperienceMain.this, R.layout.row_list, my_experience);

            if (result != null && lvMyExperiences != null) {
                lvExperiences.setAdapter(adapter_all);
                lvMyExperiences.setAdapter(adapter_my);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Napaka pri komunikaciji z strežnikom", Toast.LENGTH_SHORT);
                toast.show();

            }

        }
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
}
