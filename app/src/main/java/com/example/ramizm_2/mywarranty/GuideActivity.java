package com.example.ramizm_2.mywarranty;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class GuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        String num = "5/12";
        ArrayList<GuideData> list = new ArrayList<GuideData>();
        GuideData first_window = new GuideData(">"," Main Screen","  ["+num+"]");
        GuideData alert_push= new GuideData(">"," Push Message","  ["+num+"]");
        GuideData password = new GuideData(">"," Set Password","  ["+num+"]");
        GuideData version = new GuideData(">"," Version Info","  ["+num+"]");

        list.add(first_window);
        list.add(alert_push);
        list.add(password);
        list.add(version);

        ListView lv=(ListView)findViewById(R.id.list_guide);
        GuideAdapter adapter = new GuideAdapter(this, R.layout.guide, list);
        lv.setAdapter(adapter);
    }

}
