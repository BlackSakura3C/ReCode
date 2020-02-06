package com.example.testui.Memory;

public class ToDoList {
    private String event;
    private String remark;
    private String Date;
    private Integer Year=2000,Month=1,Day=1,Hour=12,Minute=12;
    private boolean checked;
    public ToDoList(String event){
        this.event=event;
        this.checked=false;
        this.Date=String.valueOf(getYear()+"-"+getMonth()+"-"+getDay()+"   "+getHour()+":"+getMinute());
    }

    public String getYear() {
        return Year.toString();
    }

    public String getMonth() {
        return Month.toString();
    }

    public String getDay() {
        return Day.toString();
    }

    public String getHour() {
        return Hour.toString();
    }

    public String getMinute() {
        return Minute.toString();
    }

    public String getEvent() {
        return event;
    }

    public String getRemark() {
        return remark;
    }

    public String getDate() {
        return Date;
    }
    public boolean getChecked(){
        return checked;
    }
    public boolean setYear(Integer Year){
        if(Year>=2020&&Year.longValue()==4){
            this.Year=Year;
            return true;
        }
        else
            return false;
    }
    public boolean setMonth(Integer Month){
        if(Month>=1&&Month<=12){
            this.Month=Month;
            return true;
        }
        else
            return false;
    }
    /*
    * 其实上面设置年月的函数
    * 也不需要设置检测函数
    * 后面我会用手机软件进行设置
    * 时间都是确定的不会出现意料之外的情况*/
    public void setDay(Integer Day){
        this.Day=Day;
    }
    public void setHour(Integer Hour){
        this.Hour=Hour;
    }
    public void setMinute(Integer Minute){
        this.Minute=Minute;
    }
    public void setRemark(String remark){
        this.remark=remark;
    }
    public void resetChecked(){
        this.checked=!(this.checked);
    }
}
