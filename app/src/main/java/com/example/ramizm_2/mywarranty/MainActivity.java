package com.example.ramizm_2.mywarranty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {

    private MyWarrantyFragment myWarrantyFragment;
    private ASFragment asFragment;
    private PresentFragment presentFragment;
    private MapsFragment mapsFragment;
    private PromotionFragment promotionFragment;

    private ListView navigationDrawer;
    private TextView txtTitle;

    private int[][] arrBtnTab = {
            {R.id.btn_my_warranty, R.drawable.mywarranty_w2, R.drawable.mywarranty_b2, R.id.frame_tab_my_warranty},
            {R.id.btn_AS, R.drawable.as_w2, R.drawable.as_b2, R.id.frame_tab_as},
            {R.id.btn_present, R.drawable.present_w2, R.drawable.present_b2, R.id.frame_tab_present},
            {R.id.btn_map, R.drawable.store_w2, R.drawable.store_b2, R.id.frame_tab_store},
            {R.id.btn_news, R.drawable.news_w2, R.drawable.news_b2, R.id.frame_tab_news}
    };
    private int outFlag = 0;

    private static final int NUM_PAGES = 5;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = (TextView) findViewById(R.id.txt_title);

        myWarrantyFragment = new MyWarrantyFragment(txtTitle);
        asFragment = new ASFragment(txtTitle);
        presentFragment = new PresentFragment(txtTitle);
        mapsFragment = new MapsFragment(txtTitle);
        promotionFragment = new PromotionFragment(txtTitle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.layout_linear_fragment, myWarrantyFragment).commit();
        }

//        call the SplashActivity
        startActivity(new Intent(this, SplashActivity.class));

        //set navigation drawer
        navigationDrawer = (ListView) findViewById(R.id.left_drawer);
        NavigationDrawerAdapter navigationDrawerAdapter = new NavigationDrawerAdapter(this, R.layout.navigation_drawer);
        navigationDrawer.setAdapter(navigationDrawerAdapter);

        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }

    public void onClickLeftDrawer(View view) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(navigationDrawer);
    }

    public void onClickMyWarranty(View view) {
        onClickedTab(arrBtnTab[0][0]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_linear_fragment, myWarrantyFragment).commit();
    }

    public void onClickAS(View view) {
        onClickedTab(arrBtnTab[1][0]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_linear_fragment, asFragment).commit();
    }

    public void onClickPresent(View view) {
        onClickedTab(arrBtnTab[2][0]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_linear_fragment, presentFragment).commit();
    }

//    public void onClickMap(View view) {
//        onClickedTab(arrBtnTab[3][0]);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.layout_linear_fragment, mapsFragment).commit();
//    }

    public void onClickPromotion(View view) {
        onClickedTab(arrBtnTab[4][0]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_linear_fragment, promotionFragment).commit();
    }

    // 상단 탭 색 변화
    public void onClickedTab(int btnId) {
        for (int i = 0; i < 5; i++) {
            ImageButton btnTab = null;
            FrameLayout frameLayout = null;
            if (btnId == arrBtnTab[i][0]) {
                btnTab = (ImageButton) findViewById(btnId);
                frameLayout = (FrameLayout) findViewById(arrBtnTab[i][3]);
                btnTab.setBackgroundResource(arrBtnTab[i][1]);
                frameLayout.setBackgroundResource(R.color.main_theme);

            } else {
                btnTab = (ImageButton) findViewById(arrBtnTab[i][0]);
                frameLayout = (FrameLayout) findViewById(arrBtnTab[i][3]);
                btnTab.setBackgroundResource(arrBtnTab[i][2]);
                frameLayout.setBackground(null);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(navigationDrawer)) {
            drawer.closeDrawer(navigationDrawer);
        } else if (outFlag != 1) {
            Toast.makeText(this, R.string.finish, Toast.LENGTH_SHORT).show();
            outFlag = 1;
        } else
            finish();
    }

    private class ScreenPagerAdapter extends FragmentStatePagerAdapter{
        public ScreenPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    onClickedTab(arrBtnTab[0][0]);
                    fragment = new MyWarrantyFragment(txtTitle);
                    break;
                case 1:
                    onClickedTab(arrBtnTab[1][0]);
                    fragment = new ASFragment(txtTitle);
                    break;
                case 2:
                    onClickedTab(arrBtnTab[2][0]);
                    fragment = new PresentFragment(txtTitle);
                    break;
                case 3:
                onClickedTab(arrBtnTab[3][0]);
                    fragment = new MapsFragment(txtTitle);
                    break;
                case 4:
                    onClickedTab(arrBtnTab[4][0]);
                    fragment = new PromotionFragment(txtTitle);
                    break;
            }
            return fragment;
        }


        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}