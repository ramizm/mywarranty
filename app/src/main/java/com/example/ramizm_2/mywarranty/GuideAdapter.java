package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramizm_2 on 2015-06-02.
 */
public class GuideAdapter extends ArrayAdapter<GuideData> {

    Context context;
    List<GuideData> list;

    public GuideAdapter(Context context, int textViewResourceId, List<GuideData> list) {

        super(context, textViewResourceId, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.guide, parent, false);

        }

        Button button = (Button) view.findViewById(R.id.btn_guide);
        TextView name = (TextView) view.findViewById(R.id.txt_name);
        TextView num = (TextView) view.findViewById(R.id.txt_num);

        button.setText(list.get(position).getButton());
        name.setText(list.get(position).getName());
        num.setText(list.get(position).getNum());
        return view;
    }
}