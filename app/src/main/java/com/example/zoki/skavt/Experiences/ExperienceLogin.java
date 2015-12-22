package com.example.zoki.skavt.Experiences;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoki.skavt.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class ExperienceLogin extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextView tvInfo;
    private String username, password;
    private Boolean IsLoggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_login);

        IsLoggedIn = false;

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        tvInfo = (TextView)findViewById(R.id.tvInfoLogin);

        Button btnLogin = (Button)findViewById(R.id.btnConfirm);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()){
                    new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/users/" + username + "/" + password);
                }
                else {
                    tvInfo.setText("Vpiši vse podatke");
                }
            }
        });

        Button btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceLogin.this, ExperienceRegister.class);
                startActivity(intent);
            }
        });
    }

    public class JSONTaskGet extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
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
                return buffer.toString();

            }catch (SocketTimeoutException e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Napaka pri komunikaciji z strežnikom, preverite internetno povezavo", Toast.LENGTH_SHORT);
                toast.show();
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

            if (result.equals("true")){
                IsLoggedIn = true;
                Intent intent = new Intent(ExperienceLogin.this, ExperienceMain.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
            else{
                tvInfo.setText("Napačno uporabniško ime oz. geslo");
            }


        }
    }

}
