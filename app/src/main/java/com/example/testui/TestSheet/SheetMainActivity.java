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
import android.widget.TextView;

import com.example.testui.R;

import java.util.ArrayList;
import java.util.List;

public class SheetMainActivity extends AppCompatActivity {
    private List<SheetItem> sheetItems = new ArrayList<>();
    private String[] sheettestnamelist = {"叶酸","糖化血红蛋白","白蛋白","肿瘤坏死因子:α","甲状腺素分子FT3"
    ,"总睾酮","皮质醇(早上)","汞","铅","砷","镉","总胆固醇","腰围","BMI(体重指数)"};
    private String[] sheettestunitlist={"ng/mL","%","g/dL","pg/mL","pg/mL","ng/dL","μg/dL","μg/L","μg/dL"
    ,"μg/L","μg/L","mg/dL","cm","标准是18.5～23.9"};
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
        toolbarimg.setImageResource(R.drawable.ic_backspace_black_24dp);
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

        Button btn1 = (Button) findViewById(R.id.testsheet_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetInputData(adapter,layoutManager);
                Intent intent = new Intent(SheetMainActivity.this, SheetSuggestionActivity.class);
                startActivity(intent);
                finish();
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
    private void GetInputData(SheetItemAdapter adapter,LinearLayoutManager layoutManager){
        int len=adapter.getItemCount();
        EditText[] editTexts;
        Log.d("DATASHEET1",layoutManager.findViewByPosition(0).toString());
        Log.d("DATASHEET2",layoutManager.findViewByPosition(1).toString());
        for(int i=0;i<len;i++){

        }
    }
}
