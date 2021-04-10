package com.example.testui.TestSheet;

public class Suggestion {
    private int index;
    private String testcasename;
    private String testcaseinput;
    private String unit;
    private String standardnum;
    private String suggestioncontent;

    public Suggestion(){

    }
    public Suggestion(int index, String testcasename, String testcaseinput, String unit, String standardnum, String suggestioncontent) {
        this.index = index;
        this.testcasename = testcasename;
        this.testcaseinput = testcaseinput;
        this.unit = unit;
        this.standardnum = standardnum;
        this.suggestioncontent = suggestioncontent;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTestcasename(String testcasename) {
        this.testcasename = testcasename;
    }

    public void setTestcaseinput(String testcaseinput) {
        this.testcaseinput = testcaseinput;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStandardnum(String standardnum) {
        this.standardnum = standardnum;
    }

    public void setSuggestioncontent(String suggestioncontent) {
        this.suggestioncontent = suggestioncontent;
    }

    public int getIndex() {
        return index;
    }

    public String getTestcasename() {
        return testcasename;
    }

    public String getTestcaseinput() {
        return testcaseinput;
    }

    public String getUnit() {
        return unit;
    }

    public String getStandardnum() {
        return standardnum;
    }

    public String getSuggestioncontent() {
        return suggestioncontent;
    }
}
