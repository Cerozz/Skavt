package com.example.zoki.skavt;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_contentmenu extends ArrayAdapter<Vsebina> {

    private final ArrayList<Vsebina> vsebina_list;

    public Adapter_contentmenu(Context context, ArrayList<Vsebina> vsebina_list) {
        super(context, R.layout.row, vsebina_list);
        this.vsebina_list = vsebina_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(getContext());
        View customView = inf.inflate(R.layout.row, parent, false);
        Vsebina vsebina = vsebina_list.get(position);

        TextView text = (TextView) customView.findViewById(R.id.textView);
        if (vsebina.ime.length() > 10){
            text.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        }

        TextView difficulty = (TextView) customView.findViewById(R.id.tvDifficulty);
        ImageView slika = (ImageView) customView.findViewById(R.id.imageView);
        text.setText(vsebina.ime);
        difficulty.setText("Zahtevnost: " + vsebina.zahtevnost);
        if (vsebina.slika > 0) {
            slika.setImageResource(vsebina.slika);
        }
        return customView;
    }
}
