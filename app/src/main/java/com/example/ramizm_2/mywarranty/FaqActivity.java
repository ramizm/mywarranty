package com.example.ramizm_2.mywarranty;


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015-07-22.
 */
public class FaqActivity extends Activity {

    ListView faqList;
    FaqAdapter adapter;

    String[] names = {"1","2","3","FAQ"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

         faqList = (ListView) findViewById(R.id.faqList);
        adapter = new FaqAdapter();

        adapter.addItem(new FaqItem(names[0]));
        adapter.addItem(new FaqItem(names[1]));
        adapter.addItem(new FaqItem(names[2]));
        adapter.addItem(new FaqItem(names[3]));

        faqList.setAdapter(adapter);

    }

    class FaqAdapter extends BaseAdapter{
        ArrayList<FaqItem> items = new ArrayList<FaqItem>();

        @Override
        public int getCount() {

            return items.size();
        }

        public void addItem(FaqItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {

            return items.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

          /*  TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(50.0f);

            */
            FaqItemView view = null;
            if(convertView ==  null){
                view = new FaqItemView(getApplicationContext());
            }else{
                view = (FaqItemView) convertView;
            }

            FaqItem curItem = items.get(position);


            view.setfaq(curItem.getInfo());

            return view;
        }
    }




}

