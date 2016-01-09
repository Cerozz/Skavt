package com.example.zoki.skavt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Element extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);
        Vsebina vsebina = (Vsebina) getIntent().getSerializableExtra("Vsebina");
        setTitle(vsebina.ime);
        Button button = (Button) findViewById(R.id.button2);
        button.setVisibility(View.GONE);
        if(vsebina.ime.equals("Osmica") ||vsebina.ime.equals("Ambulantni") ||vsebina.ime.equals("Bičev") ||vsebina.ime.equals("Podaljševalni") ||vsebina.ime.equals("Prusikov")){
            button.setVisibility(View.VISIBLE);
        }
        if (vsebina.uporaba != null) {
            TextView tvUporaba = (TextView) findViewById(R.id.tvUporaba);
            tvUporaba.setText(vsebina.uporaba);
        }

        TextView tvZahtevnost = (TextView) findViewById(R.id.tvElementDifficulty);
        tvZahtevnost.setText("Zahtevnost: " + vsebina.zahtevnost);

        TextView tvOpis = (TextView) findViewById(R.id.tvOpis);
        tvOpis.setText(vsebina.opis);

        if (vsebina.slika != 0) {
            ImageView ivSlika = (ImageView) findViewById(R.id.ivSlika);
            ivSlika.setImageResource(vsebina.slika);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Element.this, Postopek.class);
                startActivity(start);
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
            Intent start = new Intent(Element.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }
}
