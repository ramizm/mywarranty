package com.example.ramizm_2.mywarranty;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class InfoContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_content);

        int num = 1;
        ArrayList<InfoContentData> list = new ArrayList<InfoContentData>();
        InfoContentData first = new InfoContentData(" "+num+". "+"Personal Info","  20150516",  "14:39");
        list.add(first);  num=num+1;

        ListView lv=(ListView)findViewById(R.id.listView);
        InfoContentAdapter adapter = new InfoContentAdapter(this,R.layout.infocontent,list);
        lv.setAdapter(adapter);

    }
}
