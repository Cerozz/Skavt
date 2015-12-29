package com.example.zoki.skavt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_contentmenu extends ArrayAdapter<String> {

    private final int[] slike;

    public Adapter_contentmenu(Context context, String[] ime, int[] slike) {
        super(context, R.layout.row, ime);
        this.slike = slike;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(getContext());
        View customView = inf.inflate(R.layout.row, parent, false);
        String ime = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.textView);
        ImageView slika = (ImageView) customView.findViewById(R.id.imageView);
        text.setText(ime);
        slika.setImageResource(slike[position]);
        return customView;
    }
}
