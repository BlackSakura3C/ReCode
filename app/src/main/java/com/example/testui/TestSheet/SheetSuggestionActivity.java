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
            synthesize_suggestion.setText("\u3000\u3000"+"在"+testnames.length+"项化验检测项中，您有"+suggestions.size()+"项指标不完全在标准范围内，您的身体存在一些问题。");
        }else {
            synthesize_suggestion.setText("\u3000\u3000"+"您的身体非常健康！");
        }
        suggestionnum.setText("结果详细说明(共"+suggestions.size()+"项):");
        todolistnum.setText("推荐增加备忘录项目(共"+toDoLists.size()+"项):");

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
                        suggestion.setSuggestioncontent("同型半胱氨酸的高水平状态是阿尔茨海默病的重要促进因素与同型半胱氨酸相关" +
                                "的疾病还有心血管疾病、中风甚至一些癌症等。保持良好的、低水平的同型半胱氨酸，" +
                                "需要有足够的维生素B6、维生素 B9（叶酸）和维生素B12，而且，都必须是活性成分");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("补充维生素B6、维生素 B9（叶酸）和维生素B12");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "糖化血红蛋白":
                    if(input>=5.6){
                        suggestion.setStandardnum("＜5.6");
                        suggestion.setSuggestioncontent("人体本身每天能处理的糖低于15g远低于一份饮料中的糖含量（40-100g)高水平葡萄糖会毒害细胞，" +
                                "增加β淀粉样蛋白，导致阿尔兹海默症，建议控制每天的糖摄入量");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("控制每天的糖摄入量");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "白蛋白":
                    if(input<4.5){
                        suggestion.setStandardnum("≥4.5");
                        suggestion.setSuggestioncontent("炎症和阿尔茨海默病之间有着机制上的直接联系。它可能是源于对高糖的反应，" +
                                "或其他简单糖类摄入过多，或摄入了不良脂肪（如反式脂肪），或由“肠漏”诱发了炎症，" +
                                "还包括麸质过敏、口腔卫生状态差、一 些特定毒素的刺激等。此外，有许多其他因素也可以“招致”。" +
                                "当我们找到了这些因素的来源和性质后，就要有针对性的努力将其清除。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_白蛋白");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "肿瘤坏死因子:α":
                    if(input>=6){
                        suggestion.setStandardnum("＜6.0");
                        suggestion.setSuggestioncontent("炎症和阿尔茨海默病之间有着机制上的直接联系。它可能是源于对高糖的反应，" +
                                "或其他简单糖类摄入过多，或摄入了不良脂肪（如反式脂肪），或由“肠漏”诱发了炎症，还包括麸质过敏、" +
                                "口腔卫生状态差、一 些特定毒素的刺激等。此外，有许多其他因素也可以“招致”。当我们找 到了这些因素的来源和性质后，" +
                                "就要有针对性的努力将其清除。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_肿瘤坏死因子:α");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "甲状腺素分子FT3":
                    if(input<3.2||input>4.2){
                        suggestion.setStandardnum("3.2～4.2");
                        suggestion.setSuggestioncontent("良好的甲状腺功能状态对于维持最佳的认知功能水平举足轻重。" +
                                "甲状腺功能欠佳（往往是低下）在阿尔茨海默病患者中十分常见。甲状腺激素 的作用就像是汽车的油门、加速器：" +
                                "从总体代谢而言，甲状腺素“发 力”“使劲”（分泌量增多）时，体内的细胞通常也就代谢加速且更快捷。" +
                                "建议用户及时就医进一步检查甲状腺功能。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("及时就医进一步检查甲状腺功能");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "总睾酮":
                    if(input<500||input>1000){
                        suggestion.setStandardnum("500～1000");
                        suggestion.setSuggestioncontent("睾酮是在女性和男性中都存在的类固醇激素，但在男性中浓度明显较高，" +
                                "它的作用是支持神经元的生存。在睾酮最低的五分之一男性中，阿 尔茨海默病的风险有所增加。" +
                                "建议寻求专业医生建议病并适量补充睾酮以提高此项指标水平。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("建议寻求专业医生建议病并适量补充睾酮以提高此项指标水平");
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
                        ToDoList toDoList=new ToDoList("改变生活状态，减少压力");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "汞":
                    if(input>=5){
                        suggestion.setStandardnum("＜5");
                        suggestion.setSuggestioncontent("汞，可以促进阿尔茨海默病的标志性病理产物β—淀粉样蛋白斑块和tau 蛋白（神经原纤维缠结）产生。" +
                                "但问题还远不止这些，甲基汞也会摧毁 谷胱甘肽清除自由基的能力。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_汞");
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
                        suggestion.setSuggestioncontent("汞、砷、铅和镉等重金属会影响大脑功能。建议用户检查生活中的重金属来源，减少暴露，" +
                                "并可以在饮食中多补充维他命A、B、C、胡萝卜素等，可强化免疫、选择有机农作物，与此同时，" +
                                "多食用豆类、洋葱、蒜头、甘蓝以补充硫化物，可以帮助排除体内的金属汞。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_砷");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "镉":
                    if(input>=2.5){
                        suggestion.setStandardnum("＜2.5");
                        suggestion.setSuggestioncontent("汞、砷、铅和镉等重金属会影响大脑功能。建议用户检查生活中的重金属来源，" +
                                "减少暴露，并可以在饮食中多补充维他命A、B、C、胡萝卜素等，可强化免疫、选择有机农作物，" +
                                "与此同时，多食用豆类、洋葱、蒜头、甘蓝以补充硫化物，可以帮助排除体内的金属汞。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("TESTING_镉");
                        toDoLists.add(toDoList);
                    }
                    break;
                case "总胆固醇":
                    if(input<=150){
                        suggestion.setStandardnum("＞150");
                        suggestion.setSuggestioncontent("胆固醇过低与任职衰退有关当胆固醇低于150mg/dL时，容易罹患脑萎缩，但与此同时" +
                                "，胆固醇过高 也会引起其他心血管疾病，建议用户及时就医，进一步检测胆固醇相关指标，" +
                                "建议胆固醇过高的用户清淡饮食，忌过量食用油腻及辛辣刺激性食物以及动物内脏类食物，" +
                                "应定期复查血脂动态观察其变化，可食用大豆磷脂调节血脂，降低胆固醇。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("生活规律，适当运动，肥胖者适当减轻体重");
                        ToDoList toDoList2=new ToDoList("清淡饮食，忌过量食用油腻及辛辣刺激性食物以及动物内脏类食物，应定期复查血脂动态观察其变化");
                        ToDoList toDoList3=new ToDoList("可食用大豆磷脂调节血脂，降低胆固醇");
                        toDoLists.add(toDoList);
                        toDoLists.add(toDoList2);
                        toDoLists.add(toDoList3);
                    }
                    break;
                case "腰围":{
                    if(sex.equals("男")){
                        if(input>=101){
                            suggestion.setStandardnum("＜101");
                            suggestion.setSuggestioncontent("评价代谢状态的另一个较好的指标就是腰围：男性小于101cm。目标：BMI（体重指数）18～25（WHO的标准是18.5～ 23.9）。建议用户加强运动，配合健康饮食以改善体型。");
                            suggestion.setIndex(index++);
                            suggestions.add(suggestion);
                            ToDoList toDoList=new ToDoList("增加体育运动，注重身材管理");
                            toDoLists.add(toDoList);
                        }
                    }
                    else {
                        if(input>=89){
                            suggestion.setStandardnum("＜89");
                            suggestion.setSuggestioncontent("评价代谢状态的另一个较好的指标就是腰围：女性应该小于89cm。目标：BMI（体重指数）18～25（WHO的标准是18.5～ 23.9）。建议用户加强运动，配合健康饮食以改善体型。");
                            suggestion.setIndex(index++);
                            suggestions.add(suggestion);
                            ToDoList toDoList=new ToDoList("增加体育运动，注重身材管理");
                            toDoLists.add(toDoList);
                        }
                    }
                    break;
                }
                case "BMI":
                    if(input<18||input>25){
                        suggestion.setStandardnum("18～25");
                        suggestion.setSuggestioncontent("不健康的体重指数（BMI）会提高你认知衰退的风险。BMI的最佳指标为18～25。BMI在26以上的，" +
                                "特别是高于30时，会增加 Ⅱ型糖尿病的风险。后者发展下去的话，会增加阿尔茨海默病的风险。" +
                                " 我们对关于体重指数低于18的危险，知之不多。但偏低可能与营养和激 素状态不良有关。" +
                                "所以，BMI的理想指标应该保持在18～25。 建议用户加强运动，配合健康饮食以改善体型。");
                        suggestion.setIndex(index++);
                        suggestions.add(suggestion);
                        ToDoList toDoList=new ToDoList("加强运动，配合健康饮食以改善体型");
                        toDoLists.add(toDoList);
                    }
                    break;
                default:
            }
        }


    }
}
