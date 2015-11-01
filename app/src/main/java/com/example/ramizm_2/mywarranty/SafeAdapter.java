package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ramizm_2 on 2015-07-15.
 */
public class SafeAdapter extends BaseAdapter {

    private Context c;
    private int layout;
    private int[] arrSafeNumber;
    private int[] arrSafeDiamond;
    private LayoutInflater mInflater;

    private int numCount = 0;
    private int flag = 0;
    private ImageView[] arrImgDiamond = new ImageView[4];

    ViewHolder holder = new ViewHolder();
    TextView txtSafe;

//    private Button btnSafeNumber;

    public SafeAdapter(Context c, int layout, int[] arrSafeNumber, int[] arrSafeDiamond) {
        this.c = c;
        this.layout = layout;
        this.arrSafeNumber = arrSafeNumber;
        this.arrSafeDiamond = arrSafeDiamond;
        mInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrSafeNumber.length;
    }

    @Override
    public Object getItem(int position) {
        return arrSafeNumber[position];
    }

    @Override
    public long getItemId(int position) {
        return arrSafeNumber[position];
    }

    static class ViewHolder {
        ImageButton btnSafeNumber;
        ImageView imgDiamond1;
        ImageView imgDiamond2;
        ImageView imgDiamond3;
        ImageView imgDiamond4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(layout, parent, false);

            txtSafe = (TextView) convertView.findViewById(R.id.txt_safe);
            holder.btnSafeNumber = (ImageButton) convertView.findViewById(R.id.btn_safe_number);
            holder.btnSafeNumber.setFocusable(false);
            if(position == 9) {
                holder.btnSafeNumber.setVisibility(View.INVISIBLE);
                holder.btnSafeNumber.setClickable(false);
            }

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.btnSafeNumber.setBackgroundResource(arrSafeNumber[position]);
        holder.btnSafeNumber.setTag(position);


//        holder.btnSafeNumber.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(c, holder.btnSafeNumber.getTag()+"", Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }

    public int txtChange(int flag){
        switch (flag){
            case 1:
                txtSafe.setText(R.string.safe_new);
                notifyDataSetChanged();
                break;
            case 2:
                txtSafe.setText(R.string.safe_re);
                notifyDataSetChanged();
                break;
        }
        return flag;
    }
}
