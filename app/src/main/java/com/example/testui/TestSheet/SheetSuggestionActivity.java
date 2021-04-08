package com.example.testui.TestSheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.testui.R;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SheetSuggestionActivity extends AppCompatActivity {
    private String[] inputcontents;
    private String[] testnames;
    private String[] testunit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        inputcontents=intent.getStringArrayExtra("input_data");
        testnames=intent.getStringArrayExtra("test_name");
        testunit=intent.getStringArrayExtra("test_unit");
        InitUIWithInput();
        setContentView(R.layout.aftertestsuggest);

    }
    private void InitUIWithInput(){
//        Map<Integer,String> suggestion=new HashMap<>();
//        int len=testnames.length;
//        Double input;
//        for (int i=0;i<len;i++){
//            input=Double.valueOf(inputcontents[i]);
//            switch (testnames[i]){
//                case "叶酸":
//                    if(input<10||input>25){
//                        suggestion.put(i,null);
//                    }
//                    break;
//                case "糖化血红蛋白":
//                    if(input>=5.6){
//                        suggestion.put(i,null);
//                    }
//                    break;
//                case "白蛋白":
//                    if(input<4.5){
//                        suggestion.put(i,null);
//                    }
//                    break;
//                case "肿瘤坏死因子:α":
//                    if(input>=6){
//                        suggestion.put(i,null);
//                    }
//                    break;
//                case "甲状腺素分子FT3":
//                    if(input<3.2||input>4.2){
//                        suggestion.put(i,null);
//                    }
//            }
//        }
    }
}
