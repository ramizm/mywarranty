package com.example.ramizm_2.mywarranty;

/**
 * Created by ramizm_2 on 2015-06-02.
 */
public class InfoContentData {
    String time;
    String name;
    String date;

    public InfoContentData(String _name,String _date,String _time){
        this.name =_name;
        this.date = _date;
        this.time = _time;
    }

    public String getTime(){ return time; }
    public String getName(){  return name; }
    public String getDate(){  return date; }
}

