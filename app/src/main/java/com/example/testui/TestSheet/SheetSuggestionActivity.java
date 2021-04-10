package com.example.testui.TestSheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testui.Memory.ToDoList;
import com.example.testui.Memory.ToDoListAdapter;
import com.example.testui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SheetSuggestionActivity extends AppCompatActivity {
    private String[] inputcontents;
    private String[] testnames;
    private String[] testunit;
    private List<Suggestion> suggestions=new ArrayList<>();
    private List<ToDoList> toDoLists=new ArrayList<>();
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aftertestsuggest2);
        Intent intent=getIntent();
        inputcontents=intent.getStringArrayExtra("input_data");
        testnames=intent.getStringArrayExtra("test_name");
        testunit=intent.getStringArrayExtra("test_unit");
        sex=intent.getStringExtra("sex");
        InitUIWithInput();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.item_sheet_output);
        final LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final SuggestionAdapter suggestionAdapter=new SuggestionAdapter(suggestions);
        recyclerView.setAdapter(suggestionAdapter);
        RecyclerView recyclerView2=(RecyclerView)findViewById(R.id.suggest_agenda);
        final LinearLayoutManager layoutManager2=new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        final ToDoListAdapter toDoListAdapter=new ToDoListAdapter(toDoLists);
        recyclerView2.setAdapter(toDoListAdapter);

        TextView synthesize_suggestion=(TextView)findViewById(R.id.synthesize_suggestion);
        TextView suggestionnum=(TextView)findViewById(R.id.sheet_test_suggest_num);
        TextView todolistnum=(TextView)findViewById(R.id.sheet_test_suggest_todolist_num);
        if(suggestions.size()>0){
            synthesize_suggestion.setText("在"+testnames.length+"项化验检测项中，您有"+suggestions.size()+"项指标不完全在标准范围内，您的身体存在一些问题。");
        }else {
            synthesize_suggestion.setText("您的身体非常健康！");
        }
        suggestionnum.setText("结果详细说明(共"+suggestions.size()+"项):");
        todolistnum.setText("推荐增加备忘录项目(共"+suggestions.size()+"项):");

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        TextView toolbartext=(TextView)findViewById(R.id.toolbar_maintext);
        ImageView toolbarimg=(ImageView)findViewById(R.id.ToolBar_Icon);
        toolbarimg.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbartext.setText("化验结果分析");
        toolbarimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.after_sheet_suggest,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.after_sheet_suggest_share:
                Toast.makeText(SheetSuggestionActivity.this,"暂未编写分享功能",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void InitUIWithInput(){
        int len=testnames.length;
        int index=1;
        Double input;
        for (int i=0;i<len;i++){
            input=Double.valueOf(inputcontents[i]);
            Suggestion suggestion=new Suggestion();
            suggestion.setTestcasename(testnames[i]);
            suggestion.setTestcaseinput(input.toString());  //不直接用inputcontents[i]可以处理eg:05这种 直接转成5
            suggestion.setUnit(testunit[i]);
            switch (testnames[i]){
                case "叶酸":
                    if(input<10||input>25){
                        suggestion.setStandardnum("10～25");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_叶酸");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "糖化血红蛋白":
                    if(input>=5.6){
                        suggestion.setStandardnum("＜5.6");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_糖化血红蛋白");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "白蛋白":
                    if(input<4.5){
                        suggestion.setStandardnum("≥4.5");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_白蛋白");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "肿瘤坏死因子:α":
                    if(input>=6){
                        suggestion.setStandardnum("＜6.0");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_肿瘤坏死因子:α");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "甲状腺素分子FT3":
                    if(input<3.2||input>4.2){
                        suggestion.setStandardnum("3.2～4.2");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_甲状腺素分子FT3");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "总睾酮":
                    if(input<500||input>1000){
                        suggestion.setStandardnum("500～1000");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_总睾酮");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "皮质醇(早上)":
                    if(input<10||input>18){
                        suggestion.setStandardnum("500～1000");
                        suggestion.setSuggestioncontent("慢性压力会导致皮质醇的分泌，而高水平的皮质醇会损伤神经元，" +
                                "且皮质醇的迅速降低会导致海马体的损失持续的高压力状态会导致孕烯醇酮的大量消耗，" +
                                "而孕烯醇酮起着保护神经系统的作用，如果发现含量异常，可以通过取24h尿液作进一步测试，建议改变生活状态，减少压力");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_皮质醇(早上)");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "汞":
                    if(input>=5){
                        suggestion.setStandardnum("＜5");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "铅":
                    if(input>=2){
                        suggestion.setStandardnum("＜2");
                        suggestion.setSuggestioncontent("与汞类似的重金属都有神经毒性，甲基汞会摧毁谷胱甘肽清除自由基的能力，" +
                                "要及时清除，尿液检测比血液检测更精准，在服用螯合剂后6小时内收集尿液，" +
                                "进行检测，条件不足也可进行血液检测，使其含量由于同龄人。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_汞");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "砷":
                    if(input>=7){
                        suggestion.setStandardnum("＜7");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_砷");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "镉":
                    if(input>=2.5){
                        suggestion.setStandardnum("＜2.5");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_镉");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "总胆固醇":
                    if(input<=150){
                        suggestion.setStandardnum("＞150");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_总胆固醇");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "腰围":{
                    if(sex.equals("男")){
                        if(input>=101){
                            suggestion.setStandardnum("＜101");
                            suggestion.setSuggestioncontent("暂无建议");
                            suggestion.setIndex(index++);
                            suggestions.add(suggestion);
                            ToDoList toDoList=new ToDoList("TESTING_腰围");
                            toDoLists.add(toDoList);
                        }
                    }
                    else {
                        if(input>=89){
                            suggestion.setStandardnum("＜89");
                            suggestion.setSuggestioncontent("暂无建议");
                            suggestion.setIndex(index++);
                            suggestions.add(suggestion);
                            ToDoList toDoList=new ToDoList("TESTING_腰围");
                            toDoLists.add(toDoList);
                        }
                    }
                    break;
                }
                case "BMI":
                    if(input<18||input>25){
                        suggestion.setStandardnum("18～25");
                        suggestion.setSuggestioncontent("暂无建议");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_BMI");
                        toDoLists.add(toDoList);
                    }
                    break;
                default:
            }
        }


    }
}
