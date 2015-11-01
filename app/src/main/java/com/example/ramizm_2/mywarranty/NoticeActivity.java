package com.example.ramizm_2.mywarranty;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class NoticeActivity extends Activity {
    ListView listView;
    NoticeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        ImageButton btnnoticeback = (ImageButton)findViewById(R.id.btn_notice_back);

        View.OnClickListener listner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼 눌렀을때 동작 설정
                //Intent intent=new Intent(MainActivity.this,SubActivity.class);startActivity(intent)

                switch (v.getId()) {
                    case R.id.btn_notice_back:
                        //btn_ruleback 눌렀을때의 처리
                        finish();
                        break;
                }
            }
        };

        btnnoticeback.setOnClickListener(listner);


        listView = (ListView)findViewById(R.id.list_notice);
        adapter = new NoticeAdapter();
        listView.setAdapter(adapter);
    }
    class NoticeAdapter extends BaseAdapter{
        String[] names = {"1","2","3","4","5","6","7"};
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(50.0f);

            return view;
        }
    }
    }
