package com.example.ramizm_2.mywarranty;

import android.graphics.drawable.Drawable;

/**
 * Created by ramizm_2 on 2015-08-03.
 */
public class PromotionData {

    private String txtCompanyName;
    private int imgItem;
    private String txtContent;

    public PromotionData(String txtCompanyName, int imgItem, String txtContent) {
        this.txtCompanyName = txtCompanyName;
        this.imgItem = imgItem;
        this.txtContent = txtContent;
    }


    public String getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    public int getImgItem() {
        return imgItem;
    }

    public void setImgItem(int imgItem) {
        this.imgItem = imgItem;
    }

    public String getTxtCompanyName() {
        return txtCompanyName;
    }

    public void setTxtCompanyName(String txtCompanyName) {
        this.txtCompanyName = txtCompanyName;
    }
}
