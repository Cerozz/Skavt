package com.example.zoki.skavt;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class AdapterSwipe extends PagerAdapter {

    private int[] image_resource = {R.drawable.osmica1, R.drawable.osmica2, R.drawable.osmica3, R.drawable.osmica4, R.drawable.osmica5};
    private Context cot;
    private LayoutInflater layinf;

    public AdapterSwipe(Context cot) {
        this.cot = cot;
    }

    @Override
    public int getCount() {
        return image_resource.length;
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
        imageView.setImageResource(image_resource[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
