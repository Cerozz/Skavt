package com.example.zoki.skavt;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AdapterSwipe extends PagerAdapter {

    String vozel;

    private int[] osmica = {R.drawable.osmica1, R.drawable.osmica2, R.drawable.osmica3, R.drawable.osmica4, R.drawable.osmica5, R.drawable.osmica6};
    private int[] bicev = {R.drawable.bicev1, R.drawable.bicev2, R.drawable.bicev3, R.drawable.bicev4, R.drawable.bicev5};
    private int[] ambu = {R.drawable.ambu1, R.drawable.ambu2, R.drawable.ambu3, R.drawable.ambu4, R.drawable.ambu5, R.drawable.ambu6, R.drawable.ambu7};
    private int[] prusik = {R.drawable.prusik1, R.drawable.prusik2, R.drawable.prusik3, R.drawable.prusik4, R.drawable.prusik5, R.drawable.prusik7, R.drawable.prusik8};
    private String[] oOsmica = {"Vrv postavimo tako, da je prosti konec nad vrvjo v obliki kroga.", "Prosti konec potegnemo pod vrvjo v zgornji smeri", "Prosti konec vrvi vstavimo v prej nastalo zanko", "Vrv dokončno vključimo v zanko", "Malo zategnemo, če ste naredili pravilno, vozel pridobi obliko osmice", "Vozel dokončno zategnemo"};
    private String[] oBicev = {"Vrv kot zanko ovijemo okoli karabina", "Pod karabinom postavimo prosti konec vrvi pod navpičnim delom vrvi", "Prosti konec zasukamo, da nastane identična zanka kot na karabinu", "Nastalo zanko prav tako nastavimo na karabin", "Ko sta zanki zaklenjeni na karabinu, ju zategnemo"};
    private String[] oAmbu = {"Prosta konca vrvi postavimo skupaj", "Konca prekrižamo v obliki X", "Zasukamo, da sta obe vrvi vpleteni", "Konca postavimo navzgor, da dobi konstrukcija obliko črke U", "Prosta konca prekrižamo", "Kot na začetku, prekrižani vrvi vpletemo", "Vozel dokončno zategnemo"};
    private String[] oPrusik = {"Pripravimo vrvi", "Konec manjše vrvi damo kot zanko pod večjo vrv", "Preostanek manjše vrvi postavimo čez večjo vrv", "Manjšo vrv vnesemo v modro zanko pod večjo vrvjo", "Ta korak ponovimo trikrat", "Po treh ponovitvah, preostanek manjše vrvi damo pod zanko", "Kot zadnji korak vozel zategnemo"};

    private Context cot;
    private LayoutInflater layinf;

    public AdapterSwipe(Context cot, String vozel) {
        this.cot = cot;
        this.vozel = vozel;
    }


    @Override
    public int getCount() {
        if (vozel.equals("Osmica")) {
            return osmica.length;
        } else if (vozel.equals("Bičev")) {
            return bicev.length;
        } else if (vozel.equals("Ambulantni")) {
            return ambu.length;
        } else {
            return prusik.length;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layinf = (LayoutInflater) cot.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layinf.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.textViewOpis);
        if (vozel.equals("Osmica")) {
            imageView.setImageResource(osmica[position]);
            textView.setText(oOsmica[position]);
        } else if (vozel.equals("Bičev")) {
            imageView.setImageResource(bicev[position]);
            textView.setText(oBicev[position]);
        } else if (vozel.equals("Ambulantni")) {
            imageView.setImageResource(ambu[position]);
            textView.setText(oAmbu[position]);
        } else {
            imageView.setImageResource(prusik[position]);
            textView.setText(oPrusik[position]);
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
