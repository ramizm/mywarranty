package com.example.ramizm_2.mywarranty;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyWarrantyFragment extends Fragment {

    private TextView txtTitle;

    public MyWarrantyFragment() {
        // Required empty public constructor
    }

    public MyWarrantyFragment(TextView txtTitle){
        this.txtTitle = txtTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_my_warranty, container, false);

        txtTitle.setText(R.string.my_warranty_title);

        // put the warranty list
        ArrayList<WarrantyData> arrWarranty = new ArrayList<>();
        for(int i=0; i<10; i++){
            arrWarranty.add(new WarrantyData(i, "[OST]", "[Clock]", "Bought "+i));
        }

        //set my warranty list
        GridView warrantyGrid = (GridView) view.findViewById(R.id.grid_my_warranty);
        WarrantyAdapter warrantyAdapter = new WarrantyAdapter(getActivity(), R.layout.warranty, arrWarranty);
        warrantyGrid.setAdapter(warrantyAdapter);

        return view;

    }

}
