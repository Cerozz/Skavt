package com.example.zoki.skavt.Experiences;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class ExperienceLogin extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private TextView tvInfo;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_login);

        etUsername = (EditText) findViewById(R.id.etPassword);
        etPassword = (EditText) findViewById(R.id.etUsername);

        tvInfo = (TextView) findViewById(R.id.tvInfoLogin);

        Button btnLogin = (Button) findViewById(R.id.btnConfirm);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = new String(Hex.encodeHex(DigestUtils.sha256(etPassword.getText().toString())));

                if (!username.isEmpty() && !password.isEmpty()) {
                    new JSONTaskGet().execute("http://skavtskiprirocnik.azurewebsites.net/api/users/" + username + "/" + password);
                } else {
                    tvInfo.setText("Vpiši vse podatke");
                }
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceLogin.this, ExperienceRegister.class);
                startActivity(intent);
            }
        });

        MojSkavt globalVariable = (MojSkavt) getApplicationContext();
        String loginName = globalVariable.getLoginName();

        if (loginName != null){
            Intent intent = new Intent(ExperienceLogin.this, ExperienceMain.class);
            intent.putExtra("USERNAME", loginName);
            startActivity(intent);
        }
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

            } catch (SocketTimeoutException e) {
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

            if (result.equals("true")) {
                MojSkavt loginName = (MojSkavt) getApplicationContext();
                loginName.setLoginName(username);

                Intent intent = new Intent(ExperienceLogin.this, ExperienceMain.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            } else {
                tvInfo.setText("Napačno uporabniško ime oz. geslo");
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
            Intent start = new Intent(ExperienceLogin.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }

}
