package com.example.ramizm_2.mywarranty;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;


public class PresentFragment extends Fragment {

    private TextView txtTitle;

    public PresentFragment() {
        // Required empty public constructor
    }

    public PresentFragment(TextView txtTitle){
        this.txtTitle = txtTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_present, container, false);

        txtTitle.setText(R.string.present_title);

        // put the warranty list
        ArrayList<WarrantyData> arrGivenWarranty = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrGivenWarranty.add(new WarrantyData(i,  "[ELAND]", "[Ring]", "Received "+i));
        }

        //set my warranty list
        GridView givenWarrantyGrid = (GridView) view.findViewById(R.id.grid_given_present);
        WarrantyAdapter givenWarrantyAdapter = new WarrantyAdapter(getActivity(), R.layout.warranty, arrGivenWarranty);
        givenWarrantyGrid.setAdapter(givenWarrantyAdapter);

        // put the warranty list
        ArrayList<WarrantyData> arrTakenWarranty = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrTakenWarranty.add(new WarrantyData(i, "[ELAND]", "[Ring]", "Sent "+i));
        }

        //set my warranty list
        GridView takenWarrantyGrid = (GridView) view.findViewById(R.id.grid_taken_present);
        WarrantyAdapter takenWarrantyAdapter = new WarrantyAdapter(getActivity(), R.layout.warranty, arrTakenWarranty);
        takenWarrantyGrid.setAdapter(takenWarrantyAdapter);

        // TAB MENU
        TabHost tabHost = (TabHost)view.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tb1 = tabHost.newTabSpec("받은 선물");
        tb1.setIndicator("받은 선물("+ arrGivenWarranty.size() +")");
        tb1.setContent(R.id.tab_given_present);
        tabHost.addTab(tb1);

        TabHost.TabSpec tb2 = tabHost.newTabSpec("보낸 선물");
        tb2.setIndicator("보낸 선물("+ arrTakenWarranty.size() +")");
        tb2.setContent(R.id.tab_taken_present);
        tabHost.addTab(tb2);

        return view;

    }
}
