package com.example.zoki.skavt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ElementAlt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_alt);
        Vsebina vsebina = (Vsebina) getIntent().getSerializableExtra("Vsebina");
        setTitle(vsebina.ime);
        TextView opis1 = (TextView) findViewById(R.id.opis1);
        TextView opis2 = (TextView) findViewById(R.id.opis2);
        TextView opis3 = (TextView) findViewById(R.id.opis3);
        TextView opis4 = (TextView) findViewById(R.id.opis4);
        TextView title1 = (TextView) findViewById(R.id.title1);
        TextView title2 = (TextView) findViewById(R.id.title2);
        TextView title3 = (TextView) findViewById(R.id.title3);
        TextView title4 = (TextView) findViewById(R.id.title4);
        TextView[] titli = {title1, title2, title3, title4};
        TextView[] opisi = {opis1, opis2, opis3, opis4};
        for(int x = 0; x < vsebina.kat.length; x++){
            titli[x].setText(vsebina.kat[x]);
            opisi[x].setText(vsebina.opisArr[x]);
        }
    }
}
