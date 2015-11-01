package com.example.ramizm_2.mywarranty;

/**
 * Created by ramizm_2 on 2015-06-02.
 */
public class GuideData {

    String button;
    String name;
    String num;

    public GuideData(String _button,String _name,String _num){
        this.button =_button;
        this.name = _name;
        this.num = _num;
    }

    public String getButton(){ return button; }
    public String getName(){  return name; }
    public String getNum(){  return num; }

}
