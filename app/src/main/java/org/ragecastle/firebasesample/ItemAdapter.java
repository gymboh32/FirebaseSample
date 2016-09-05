package org.ragecastle.firebasesample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jahall on 9/5/16.
 *
 */
public class ItemAdapter extends ArrayAdapter<String> {

    private int lastPosition;
    private TextView textView;

    public ItemAdapter(Activity context, List<String> item) {
        super(context, 0, item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        lastPosition = position;
        String item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.listview_main, parent, false);
        }

        textView = (TextView) convertView.findViewById(R.id.item);
        textView.setText(item);
        return convertView;
    }

    @Override
    public void add(String item) {
        textView.setText(item);
    }
}
