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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] poglavja = {"Vozli", "Zavetje", "Ognji", "Navigacija", "Nasveti", "Deli izkušnje", "Svetilka"};
        int[] slike = {R.drawable.rope, R.drawable.home, R.drawable.flames, R.drawable.compass, R.drawable.books, R.drawable.social, R.drawable.flashlight};
        String[] opisi = {"O vozlih, kako jih naredimo in čemu so namenjeni", "Gradnja učinkovitega zavetja", "Različni ognji in njihovi nameni", "Kako uporabiti navigacijske zemljevide in kompas", "Koristno znanje za vsakogar", "Objavi svoje izkušnje (potrebuje internetno povezavo)", "Svetilka za temne dni"};
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
                            Intent start = new Intent(MainActivity.this, Experiences.class);
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
