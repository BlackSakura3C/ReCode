package com.example.testui.TestSheet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testui.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SheetMainActivity extends AppCompatActivity {
    private List<SheetItem> sheetItems = new ArrayList<>();
    private String[] inputcontents;
    private String[] sheettestnamelist = {"叶酸","糖化血红蛋白","白蛋白","肿瘤坏死因子:α","甲状腺素分子FT3"
    ,"总睾酮","皮质醇(早上)","汞","铅","砷","镉","总胆固醇","腰围","BMI(体重指数)"};
    private String[] sheettestunitlist={"ng/mL","%","g/dL","pg/mL","pg/mL","ng/dL","μg/dL","μg/L","μg/dL"
    ,"μg/L","μg/L","mg/dL","cm"," "};
    private String sex;
    private RadioGroup radioGroup;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testsheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
         * 隐藏掉系统自带的Action Bar 避免上方文字显示冲突
         */
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        /*
         * 设置Tool Bar功能
         */
        TextView toolbartext = (TextView) findViewById(R.id.toolbar_maintext);
        toolbartext.setText("化验单");
        ImageView toolbarimg = (ImageView) findViewById(R.id.ToolBar_Icon);
        toolbarimg.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbarimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        InitSheetTest();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sheet_recycle_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final SheetItemAdapter adapter = new SheetItemAdapter(sheetItems);
        recyclerView.setAdapter(adapter);

        radioGroup=(RadioGroup)findViewById(R.id.sheet_test_sex);

        Button btn1 = (Button) findViewById(R.id.testsheet_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputcontents= adapter.getInputcontents();
                if(CheckCompleteness(inputcontents)){
                    Intent intent = new Intent(SheetMainActivity.this, SheetSuggestionActivity.class);
                    intent.putExtra("input_data",inputcontents);
                    intent.putExtra("test_name",sheettestnamelist);
                    intent.putExtra("test_unit",sheettestunitlist);
                    intent.putExtra("sex",sex);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void InitSheetTest() {
        int len=sheettestnamelist.length;
        for(int i=0;i<len;i++){
            SheetItem sheetItem = new SheetItem();
            sheetItem.setTestitemname(sheettestnamelist[i]);
            sheetItem.setUnit(sheettestunitlist[i]);
            sheetItems.add(sheetItem);
        }
    }
    private boolean CheckCompleteness(String[] input){
        if(radioGroup.getCheckedRadioButtonId()==R.id.sheet_test_sex_male)
            sex="男";
        else if(radioGroup.getCheckedRadioButtonId()==R.id.sheet_test_sex_female)
            sex="女";
        else{
            Toast.makeText(SheetMainActivity.this,"您的性别没有填写！",Toast.LENGTH_SHORT).show();
            return false;
        }
        int len=input.length;
        Pattern pattern=Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher matcher;
        for(int i=0;i<len;i++){
            if(input[i]==null){
                Toast.makeText(SheetMainActivity.this,"您有化验项没有填写！",Toast.LENGTH_SHORT).show();
                return false;
            }
            matcher=pattern.matcher(input[i].trim());
            if(!matcher.matches()){
                Toast.makeText(SheetMainActivity.this,"填写内容格式有误请检查！",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}
