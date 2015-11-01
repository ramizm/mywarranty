package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramizm_2 on 2015-05-15.
 */
public class WarrantyAdapter extends BaseAdapter {

    private Context c;
    private int layout;
    private ArrayList<WarrantyData> arrWarranty;
    private LayoutInflater mInflater;

    private LinearLayout linearWarranty;
    private ImageView imgItem;
    private ImageView imgCompanyLogo;
    private TextView txtCompany;
    private TextView txtName;
    private TextView txtDate;

    public WarrantyAdapter(Context c, int layout, ArrayList<WarrantyData> arrWarranty) {
        this.c = c;
        this.layout = layout;
        this.arrWarranty = arrWarranty;
        mInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrWarranty.size();
    }

    @Override
    public Object getItem(int position) {
        return arrWarranty.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(layout, parent, false);

        }

        linearWarranty = (LinearLayout) convertView.findViewById(R.id.linear_warranty);
        imgItem = (ImageView) convertView.findViewById(R.id.img_warranty_item);
        imgCompanyLogo = (ImageView) convertView.findViewById(R.id.img_warranty_company_logo);
        txtCompany = (TextView) convertView.findViewById(R.id.txt_warranty_company_name);
        txtName = (TextView) convertView.findViewById(R.id.txt_warranty_item_name);
        txtDate = (TextView) convertView.findViewById(R.id.txt_warranty_date);

        imgItem.setImageResource(R.drawable.jewelry1);
        imgCompanyLogo.setImageResource(R.drawable.jewelry_bk2);
        txtCompany.setText(arrWarranty.get(position).getTxtCompanyName());
        txtName.setText(arrWarranty.get(position).getTxtItemName());
        txtDate.setText(arrWarranty.get(position).getTxtDate());

        linearWarranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c, WarrantyDetailsActivity.class);
                c.startActivity(intent);
            }
        });

        return convertView;
    }
}
