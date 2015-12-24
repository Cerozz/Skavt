package com.example.zoki.skavt.Experiences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.zoki.skavt.R;
import java.util.ArrayList;

public class ExperienceAdapter extends ArrayAdapter<Experience> {
    public ExperienceAdapter(Context context, ArrayList<Experience> experiences) {
        super(context, 0, experiences);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Experience experience = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list, parent, false);
        }
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvExperienceTitle);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvExperienceAuthor);

        tvTitle.setText(experience.Title);
        tvAuthor.setText(experience.Author);

        return convertView;
    }
}