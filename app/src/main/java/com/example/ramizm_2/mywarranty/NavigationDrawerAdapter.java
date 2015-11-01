package com.example.ramizm_2.mywarranty;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ramizm_2 on 2015-05-15.
 */
public class NavigationDrawerAdapter extends BaseAdapter{
    private Context c;
    private int layout;
    private LayoutInflater mInflater;

    private LinearLayout linearNotice;
    private LinearLayout linearRule;
    private LinearLayout linearSetting;
    private LinearLayout linearLogout;

    private ImageButton btnBack;
    private ImageView imgProfile;

    private Intent mIntent;

    public NavigationDrawerAdapter(Context c, int layout){
        this.c = c;
        this.layout = layout;
        mInflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = mInflater.inflate(layout, parent, false);
        }

        btnBack = (ImageButton) convertView.findViewById(R.id.btn_navigation_drawer_back);
        imgProfile = (ImageView) convertView.findViewById(R.id.img_profile_photo);
        linearNotice = (LinearLayout) convertView.findViewById(R.id.linear_profile_notice);
        linearRule = (LinearLayout) convertView.findViewById(R.id.linear_profile_rule);
        linearSetting = (LinearLayout) convertView.findViewById(R.id.linear_profile_setting);
        linearLogout = (LinearLayout) convertView.findViewById(R.id.linear_profile_logout);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ListView navigationDrawer = (ListView) findViewById(R.id.left_drawer);
//                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//                drawer.closeDrawer(navigationDrawer);
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linearNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(c, NoticeActivity.class);
                c.startActivity(mIntent);
            }
        });

        linearSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(c, SettingsActivity.class);
                c.startActivity(mIntent);
            }
        });

        linearRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(c, RuleActivity.class);
                c.startActivity(mIntent);
            }
        });

        linearLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(c);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_logout);

                Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button btnLogout = (Button) dialog.findViewById(R.id.btn_logout);
                btnLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(c, "Logout", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

        return convertView;
    }
}
