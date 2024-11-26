package com.example.lab11.ui.theme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    private final Context context;
    private final String[] colorNames;
    private final int[] colorValues;

    public ColorAdapter(Context context, String[] colorNames, int[] colorValues) {
        this.context = context;
        this.colorNames = colorNames;
        this.colorValues = colorValues;
    }

    @Override
    public int getCount() {
        return colorNames.length;
    }

    @Override
    public Object getItem(int position) {
        return colorValues[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(colorNames[position]);
        textView.setBackgroundColor(colorValues[position]);
        return convertView;
    }
}
