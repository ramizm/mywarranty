package com.example.ramizm_2.mywarranty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class PromotionFragment extends Fragment {

    private TextView txtTitle;

    private PromotionData promotionData;
    private ArrayList<PromotionData> arrPromotionData;

    public PromotionFragment() {
        // Required empty public constructor
    }

    public PromotionFragment(TextView txtTitle){
        this.txtTitle = txtTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        txtTitle.setText(R.string.promotion_title);

        arrPromotionData = new ArrayList<>();

        for(int i=0; i<24; i++) {
            promotionData = new PromotionData("OST", R.drawable.jewelry1, "Clock and Necklace: " + i);
            arrPromotionData.add(promotionData);
        }

        //set promotion
        ListView listPromotion = (ListView) view.findViewById(R.id.list_promotion);
        PromotionAdapter promotionAdapter = new PromotionAdapter(getActivity(), R.layout.promotion, arrPromotionData);
        listPromotion.setAdapter(promotionAdapter);

        return view;
    }
}