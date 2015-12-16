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

public class SubDirectory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdirectory);
        setTitle(getIntent().getExtras().getString("ime"));
        String[] poglavja = {"Osmica", "Example 1", "Example 2", "Example 3", "Example 4", "Example 5"};
        String[] opis = {"_ je koristen za _", "_ je koristen za _", "_ je koristen za _", "_ je koristen za _", "_ je koristen za _", "_ je koristen za _"};
        int[] slike = {R.drawable.rope, R.drawable.rope, R.drawable.rope, R.drawable.rope, R.drawable.rope, R.drawable.rope};
        ListAdapter adapter = new Adapter(this, poglavja, slike, opis);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String ime = String.valueOf(parent.getItemAtPosition(position));
                        Intent start = new Intent(SubDirectory.this, Element.class);
                        Bundle extra = new Bundle();
                        extra.putString("ime", ime);
                        start.putExtras(extra);
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
