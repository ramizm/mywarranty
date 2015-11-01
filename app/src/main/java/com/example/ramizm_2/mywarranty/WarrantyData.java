package com.example.ramizm_2.mywarranty;

/**
 * Created by ramizm_2 on 2015-05-15.
 */
public class WarrantyData {

    private int imgItem;
    private int imgCompanyLogo;
    private String txtCompanyName;
    private String txtItemName;
    private String txtType;
    private String txtDate;

    public WarrantyData(int imgItem, String txtCompanyName, String txtItemName, String txtDate){
        this.imgItem = imgItem;
        this.txtCompanyName = txtCompanyName;
        this.txtItemName = txtItemName;
        this.txtDate = txtDate;
    }

    public void setImgItem(){

    }

    public void setTxtCompanyName(){}

    public void setTxtItemName(){

    }

    public void setTxtDate(){

    }

    public int getImgItem(){
        return imgItem;
    }

    public String getTxtCompanyName(){
        return txtCompanyName;
    }

    public String getTxtItemName(){
        return txtItemName;
    }

    public String getTxtDate(){
        return txtDate;
    }
}
