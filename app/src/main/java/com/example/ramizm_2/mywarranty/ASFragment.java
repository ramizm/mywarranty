package com.example.ramizm_2.mywarranty;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class ASFragment extends Fragment {

    private TextView txtTitle;

    public ASFragment(TextView txtTitle){
        this.txtTitle = txtTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_as, container, false);

        txtTitle.setText(R.string.as_title);

        // put the warranty list
        ArrayList<WarrantyData> arrWarranty = new ArrayList<>();
        for(int i=1; i<13; i++){
            arrWarranty.add(new WarrantyData(i, "[LLOYD]", "[Necklace]", "Deposited "+i));
        }

        //set my warranty list
        GridView warrantyGrid = (GridView) view.findViewById(R.id.grid_as);
        WarrantyAdapter warrantyAdapter = new WarrantyAdapter(getActivity(), R.layout.warranty, arrWarranty);
        warrantyGrid.setAdapter(warrantyAdapter);

        return view;

    }

}