package com.example.ramizm_2.mywarranty;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  RuleActivity extends Activity {
    ExpandableListView mList;
    String[] arTitle = new String[]{"1.수집하는 개인정보의 항목","2.개인정보의 수집 및 이용목적","3.개인정보의 보유 및 이용기간",
    "4.개인정보의 파기절차 및 방법","5.수집한 개인정보의 위탁","6.고객의 개인정보에 대한 권리,의무 및 행사방법",
            "7.개인정보 자동수집 장치의 설치, 운영 및 그 거부에 관한 사항","8.개인 정보의 기술적, 관리적 보호대책"};

    String[][] arContent = new String[][]{{"(blank yet"},{"(blank yet"},{"(blank yet"},{"(blank yet"},
            {"(blank yet"},{"(blank yet"},{"(blank yet"},{"(blank yet"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        ImageButton btnruleback = (ImageButton)findViewById(R.id.btn_rule_back);

        View.OnClickListener listner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 눌렀을때 동작 설정
                //Intent intent=new Intent(MainActivity.this,SubActivity.class);startActivity(intent)

                switch (v.getId()) {
                    case R.id.btn_rule_back:
                        //btn_ruleback 눌렀을때의 처리
                        finish();
                        break;
                }
            }
        };


        btnruleback.setOnClickListener(listner);

        mList = (ExpandableListView) findViewById(R.id.list_rule);
        List<Map<String, String>> ruletitle = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> rulecontent = new ArrayList<List<Map<String, String>>>();

        for (int i = 0; i < arTitle.length; i++) {
            Map<String, String> RuleTitle = new HashMap<String, String>();
            RuleTitle.put("ruletitle", arTitle[i]);
            ruletitle.add(RuleTitle);

            List<Map<String, String>> subcontent = new ArrayList<Map<String, String>>();
            for (int j = 0; j < arContent[i].length; j++) {
                Map<String, String> RuleContent = new HashMap<String, String>();
                RuleContent.put("rulecontent", arContent[i][j]);
                subcontent.add(RuleContent);
            }
            rulecontent.add(subcontent);
        }

        ExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                ruletitle,

                android.R.layout.simple_expandable_list_item_1,
                new String[]{"ruletitle"},
                new int[]{android.R.id.text1},
                rulecontent,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"rulecontent"},
                new int[]{android.R.id.text2}
        );
        mList.setAdapter(adapter);
    }
}
