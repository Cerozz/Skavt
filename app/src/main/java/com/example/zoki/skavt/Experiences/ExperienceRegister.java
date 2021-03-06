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
import android.widget.TextView;

import com.example.zoki.skavt.About;
import com.example.zoki.skavt.R;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class ExperienceRegister extends AppCompatActivity {

    private EditText etRegisterUsername, etRegisterPassword;
    private TextView tvLike;
    private String username, password;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_register);

        etRegisterUsername = (EditText) findViewById(R.id.etRegisterUsername);
        etRegisterPassword = (EditText) findViewById(R.id.etRegisterPassword);

        tvLike = (TextView)findViewById(R.id.tvLike);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        Button btnConfirmRegister = (Button) findViewById(R.id.btnRegisterConfirm);
        btnConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etRegisterUsername.getText().toString();
                password = etRegisterPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    password = new String(Hex.encodeHex(DigestUtils.sha256(password)));
                    new JSONTaskCheckUsername().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/users/" + username);
                } else {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Vpiši vse podatke!", Snackbar.LENGTH_LONG);
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
            Intent start = new Intent(ExperienceRegister.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }

    public class JSONTaskCheckUsername extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (SocketTimeoutException e) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Napaka pri komunikaciji z strežnikom!", Snackbar.LENGTH_LONG);
                snackbar.show();
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
            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result == null){

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Ni internetne povezave!", Snackbar.LENGTH_LONG);
                snackbar.show();;

            }
            else if (result.equals("false")) {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "To uporabniško ime je že zasedeno!", Snackbar.LENGTH_LONG);
                    snackbar.show();

            }
            else if (result.equals("true")){
                new JSONTaskPostUser().execute("http://skavtskiprirocnikapi.azurewebsites.net/api/users/" + username + "/" + password);
            }
            
        }
    }

    public class JSONTaskPostUser extends AsyncTask<String, Void, String> {

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
            if (result == null){
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Napaka pri povezavi!", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
            else if (result.equals("true")) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Uspešno dodan uporabnik: " + username , Snackbar.LENGTH_LONG);
                snackbar.show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent start = new Intent(ExperienceRegister.this, ExperienceLogin.class);
                startActivity(start);
            }
        }
    }
}
