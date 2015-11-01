package com.example.ramizm_2.mywarranty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;


public class SettingsActivity extends Activity {

    private Intent mIntent;
    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        c = this;

        ImageButton btnBack = (ImageButton) findViewById(R.id.btn_setting_back);
        Button btnVersion = (Button) findViewById(R.id.btn_versioninform);
        Button btnPW = (Button) findViewById(R.id.btn_passwordsettings);
        Switch sw = (Switch) findViewById(R.id.switch_pushalarm);
        ImageButton btnQuestion = (ImageButton) findViewById(R.id.btn_fre_question);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(SettingsActivity.this, "푸쉬알람 " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        View.OnClickListener listner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 눌렀을때 동작 설정
                //Intent intent=new Intent(MainActivity.this,SubActivity.class);startActivity(intent)

                switch (v.getId()) {
                    case R.id.btn_setting_back:
                        //btn_noticeback 눌렀을때의 처리
                        finish();
                        break;
                    case R.id.btn_versioninform:
                        //btn_versioninform 눌렀을때의 처리
                        mIntent = new Intent(c, VersionActivity.class);
                        c.startActivity(mIntent);
                        break;
                    case R.id.btn_passwordsettings:
                        //btn_passwordssettings눌렀을때의 처리
                        mIntent = new Intent(c, SafeActivity.class);
                        c.startActivity(mIntent);
                        break;
                    case R.id.btn_fre_question:
                        //btn_fre_question 눌렀을때의 처리
                        mIntent = new Intent(c, FaqActivity.class);
                        c.startActivity(mIntent);
                        break;
                }
            }
        };


        btnBack.setOnClickListener(listner);
        btnVersion.setOnClickListener(listner);
        btnVersion.setBackgroundColor(Color.TRANSPARENT);
        btnPW.setOnClickListener(listner);
        btnPW.setBackgroundColor(Color.TRANSPARENT);
        btnQuestion.setOnClickListener(listner);
        btnQuestion.setOnClickListener(listner);
    }

}
