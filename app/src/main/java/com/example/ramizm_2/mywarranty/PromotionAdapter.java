package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramizm_2 on 2015-08-03.
 */
public class PromotionAdapter extends BaseAdapter {

    private Context c;
    private int layout;
    private ArrayList<PromotionData> arrPromotionData;
    private LayoutInflater mInflater;

    private TextView txtCompanyName;
    private TextView txtContent;
    private ImageView imgItem;

    public PromotionAdapter(Context c, int layout, ArrayList<PromotionData> arrPromotionData){
        this.c = c;
        this.layout = layout;
        this.arrPromotionData = arrPromotionData;
        mInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrPromotionData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrPromotionData.get(position);
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

        txtCompanyName = (TextView) convertView.findViewById(R.id.txt_promotion_company_name);
        txtContent = (TextView) convertView.findViewById(R.id.txt_promotion_content);
        imgItem = (ImageView) convertView.findViewById(R.id.img_promotion_item);

        txtCompanyName.setText(arrPromotionData.get(position).getTxtCompanyName());
        txtContent.setText(arrPromotionData.get(position).getTxtContent());
//        imgItem.setBackgroundResource(arrPromotionData.get(position).getImgItem());
        imgItem.setImageResource(arrPromotionData.get(position).getImgItem());

        return convertView;
    }
}
