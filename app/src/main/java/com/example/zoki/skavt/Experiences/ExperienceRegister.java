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

public class ExperienceRegister extends AppCompatActivity {

    private EditText etRegisterUsername, etRegisterPassword;
    private TextView tvInfo;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_register);

        etRegisterUsername = (EditText)findViewById(R.id.etRegisterUsername);
        etRegisterPassword = (EditText)findViewById(R.id.etRegisterPassword);

        tvInfo = (TextView)findViewById(R.id.tvRegisterInfo);

        Button btnConfirmRegister = (Button)findViewById(R.id.btnRegisterConfirm);
        btnConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etRegisterUsername.getText().toString();
                password = etRegisterPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/users/" + username );
                } else {
                    tvInfo.setText("Vpiši vse podatke");
                }
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
                connection.setRequestMethod("POST");
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
                Toast toast = Toast.makeText(getApplicationContext(), "Uspešno dodan uporabnik: " + etRegisterUsername.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                tvInfo.setText("To uporabniško ime je že zasedeno");
            }
        }
    }
}