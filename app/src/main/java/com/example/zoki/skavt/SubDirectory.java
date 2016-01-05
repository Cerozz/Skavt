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
import android.widget.Toast;

import java.util.ArrayList;

public class SubDirectory extends AppCompatActivity {

    String[] ime, opis;
    int[] slike;

    ArrayList<Vsebina> vsebina = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdirectory);
        String title = getIntent().getExtras().getString("ime");
        setTitle(title);

        if(title.equals("Vozli")){
            vsebina = new Vsebina().getVozli();
        }
        else if (title.equals("Ognji"))
        {
            vsebina = new Vsebina().getOgnji();
        }
        else if (title.equals("Orientacija"))
        {
            vsebina = new Vsebina().getOrientacije();
        }
        else if (title.equals("Zavetje")){
            vsebina = new Vsebina().getZavetje();
        }
        else if (title.equals("Nasveti")){
            vsebina = new Vsebina().getNasveti();
        }

        ListAdapter adapter = new Adapter_contentmenu(this, vsebina);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Vsebina vs = vsebina.get(position);
                        Intent start = new Intent(SubDirectory.this, Element.class);
                        start.putExtra("Vsebina", vs);
                        startActivity(start);
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
            Intent start = new Intent(SubDirectory.this, About.class);
            startActivity(start);
        }
        return super.onOptionsItemSelected(item);
    }
}
