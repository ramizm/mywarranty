package com.example.ramizm_2.mywarranty;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class SafeActivity extends Activity implements OnClickListener{

//    private int[] arrSafeNumberId = {R.id.btn_safe_one, R.id.btn_safe_two, R.id.btn_safe_three, R.id.btn_safe_four,
//            R.id.btn_safe_five, R.id.btn_safe_six, R.id.btn_safe_seven, R.id.btn_safe_eight,
//            R.id.btn_safe_nine, R.id.btn_safe_empty, R.id.btn_safe_zero, R.id.btn_safe_back};

    private int[] arrSafeNumberImage = {R.drawable.safe_one2, R.drawable.safe_two2, R.drawable.safe_three2, R.drawable.safe_four2,
            R.drawable.safe_five2, R.drawable.safe_six2, R.drawable.safe_seven2, R.drawable.safe_eight2,
            R.drawable.safe_nine2, R.drawable.safe_zero2, R.drawable.safe_back2};

    private int[] arrSafeDiamondId = {R.id.img_safe_jewelry_1, R.id.img_safe_jewelry_2, R.id.img_safe_jewelry_3, R.id.img_safe_jewelry_4};
    private int[] arrSafeNumberId = {R.id.btn_safe_one, R.id.btn_safe_two, R.id.btn_safe_three, R.id.btn_safe_four,
            R.id.btn_safe_five, R.id.btn_safe_six, R.id.btn_safe_seven, R.id.btn_safe_eight,
            R.id.btn_safe_nine, R.id.btn_safe_zero, R.id.btn_safe_back};

    private ImageButton btnSafeNumber;

    private SafeAdapter safeAdapter;
    private GridView gridView;

    int numCount = 0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);

//        safeAdapter = new SafeAdapter(this, R.layout.safe_number, arrSafeNumberImage, arrSafeDiamondId);
//        gridView = (GridView) findViewById(R.id.grid_safe);
//        gridView.setAdapter(safeAdapter);

        for(int i=0; i<arrSafeDiamondId.length; i++){
            findViewById(arrSafeDiamondId[i]).setBackgroundResource(R.drawable.jewelry_bk2);
        }

        for(int i=0; i<arrSafeNumberId.length; i++){
            findViewById(arrSafeNumberId[i]).setBackgroundResource(arrSafeNumberImage[i]);
        }


//        for (int i = 0; i < arrSafeNumberId.length; i++) {
//            btnSafeNumber = (ImageButton) findViewById(arrSafeNumberId[i]);
//            btnSafeNumber.setBackground(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), arrSafeNumberImage[i])));
//        }

//        gridView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position != 9) {
//                    if (position == 11 && numCount > 0) {
//                        numCount--;
//                        findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry_bk2);
//                    } else if (position != 11 && numCount < 4) {
//                        findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
//                        numCount++;
//                    }
//
//                    if(numCount == 4){
//                        Toast.makeText(SafeActivity.this, "numCount: "+numCount, Toast.LENGTH_SHORT).show();
//                        flag += 1;
//                        flag = safeAdapter.txtChange(flag);
//                    }
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if(numCount==4){
            Toast.makeText(SafeActivity.this, "numCount: "+numCount, Toast.LENGTH_SHORT).show();
        }
        switch (view.getId()){
            case R.id.btn_safe_one:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_two:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_three:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_four:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_five:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_six:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_seven:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_eight:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_nine:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_zero:
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry2);
                numCount++;
                break;
            case R.id.btn_safe_back:
                numCount--;
                findViewById(arrSafeDiamondId[numCount]).setBackgroundResource(R.drawable.jewelry_bk2);
                break;
        }
    }

//    @Override
//    public void onDestroy(){
//        for(int i=0; i<arrSafeDiamondId.length; i++)
//            recycleView(findViewById(arrSafeDiamondId[i]));
//        for(int i=0; i<12; i++)
//            recycleView(findViewById((int) gridView.getItemIdAtPosition(i)));
//    }
//
//    private void recycleView(View view) {
//        if (view != null) {
//            Drawable bg = view.getBackground();
//            if (bg != null) {
//                bg.setCallback(null);
//                ((BitmapDrawable)bg).getBitmap().recycle();
//                view.setBackgroundDrawable(null);
//            }
//        }
//    }
}
