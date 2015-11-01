package com.example.ramizm_2.mywarranty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2015-07-23.
 */
public class FaqItemView extends LinearLayout{
    TextView faqinfo;

    public FaqItemView(Context context) {
        super(context);

        init(context);
    }

    public FaqItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.faq_item, this, true);

        faqinfo = (TextView) findViewById(R.id.faqinfo);

    }

    public void setfaq(String faq){
        faqinfo.setText(faq);
    }
}
