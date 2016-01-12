package com.example.zoki.skavt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.zoki.skavt.Experiences.ExperienceLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] poglavja = {"Vozli", "Zavetje", "Ognji", "Orientacija", "Nasveti", "Deli izkušnje", "Svetilka"};
        int[] slike = {R.drawable.rope, R.drawable.home, R.drawable.flames, R.drawable.compass, R.drawable.books, R.drawable.social, R.drawable.flashlight};
        String[] opisi = {"Informacije o raznih vozlih, čemu so namenjeni, prednosti ter postopki izdelave", "Informacije o zavetjih, kdaj jih uporabimo, za koliko ljudi služijo in njihove prednosti", "Različni ognji, njihove prednosti, priprava ter njihov nameni", "Pomoč pri navigaciji z uporabo kompasa, navigacijskih kart ter zvezd in planetov", "Dodatni nasveti in znanja kot prva pomoč, sledi živali in podobno", "Platforma za branje in deljenje izkušenj(potrebuje internetno povezavo)", "Uporaba bliskavice kot svetilka in možnost svetlobnega SOS signala"};
        ListAdapter adapter = new Adapter(this, poglavja, slike, opisi);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String ime = String.valueOf(parent.getItemAtPosition(position));
                        if (!ime.equals("Svetilka") && !ime.equals("Deli izkušnje")) {
                            Intent start = new Intent(MainActivity.this, SubDirectory.class);
                            Bundle extra = new Bundle();
                            extra.putString("ime", ime);
                            start.putExtras(extra);
                            startActivity(start);
                        } else if (ime.equals("Svetilka")) {
                            Intent start = new Intent(MainActivity.this, Flashlight.class);
                            startActivity(start);
                        } else if (ime.equals("Deli izkušnje")) {
                            Intent start = new Intent(MainActivity.this, ExperienceLogin.class);
                            startActivity(start);
                        }
                    }
                }
        );
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
            Intent start = new Intent(MainActivity.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }
}
