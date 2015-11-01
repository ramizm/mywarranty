package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramizm_2 on 2015-06-02.
 */
public class InfoContentAdapter extends ArrayAdapter<InfoContentData> {

    Context context;
    List<InfoContentData> list;

    public InfoContentAdapter(Context context, int textViewResourceId, List<InfoContentData> list) {

        super(context, textViewResourceId, list);
        this.context = context;
        this.list = list;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.infocontent, parent, false);

        }
        InfoContentData f = getItem(position);

        TextView name = (TextView) view.findViewById(R.id.txt_infocontent_name);
        TextView date = (TextView) view.findViewById(R.id.txt_infocontent_date);
        TextView time = (TextView) view.findViewById(R.id.txt_infocontent_time);
        name.setText(f.getName());
        date.setText(f.getDate());
        time.setText(f.getTime());
        return view;

    }
}
