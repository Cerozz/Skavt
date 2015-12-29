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

            int st_vozlov = vsebina.size();
            ime = new String[st_vozlov];
            opis = new String[st_vozlov];
            slike = new int[st_vozlov];

            for(int i = 0; i < st_vozlov;i++){
                ime[i] = vsebina.get(i).ime;
                opis[i] = vsebina.get(i).opis;
                slike[i] = vsebina.get(i).slika;
            }
        }
        else if (title.equals("Ognji"))
        {
            vsebina = new Vsebina().getOgnji();

            int st_ognjev = vsebina.size();
            ime = new String[st_ognjev];
            opis = new String[st_ognjev];
            slike = new int[st_ognjev];

            for(int i = 0; i < st_ognjev;i++){
                ime[i] = vsebina.get(i).ime;
                opis[i] = vsebina.get(i).opis;
                slike[i] = vsebina.get(i).slika;
            }
        }
        else if (title.equals("Orientacija"))
        {
            vsebina = new Vsebina().getOrientacije();

            int st_orientacij = vsebina.size();
            ime = new String[st_orientacij];
            opis = new String[st_orientacij];
            slike = new int[st_orientacij];

            for(int i = 0; i < st_orientacij;i++){
                ime[i] = vsebina.get(i).ime;
                opis[i] = vsebina.get(i).opis;
                slike[i] = vsebina.get(i).slika;
            }
        }
        else if (title.equals("Zavetje")){
            Toast toast = Toast.makeText(getApplicationContext(), "ni še implementirano", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (title.equals("Nasveti")){
            Toast toast = Toast.makeText(getApplicationContext(), "ni še implementirano", Toast.LENGTH_SHORT);
            toast.show();
        }

        ListAdapter adapter = new Adapter_contentmenu(this, ime, slike);
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
