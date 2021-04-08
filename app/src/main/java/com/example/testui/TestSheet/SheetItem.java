package com.example.testui.TestSheet;

public class SheetItem {
    private String testitemname;
    private String input;
    private String unit;    //化验数值的单位

    public SheetItem(){}
    public SheetItem(String testitemname,String unit){
        this.testitemname=testitemname;
        this.unit=unit;
    }
    public String getTestitemname(){
        return this.testitemname;
    }
    public String getInput(){
        return this.input;
    }
    public String getUnit(){
        return this.unit;
    }
    public void setTestitemname(String testitemname){
        this.testitemname=testitemname;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
