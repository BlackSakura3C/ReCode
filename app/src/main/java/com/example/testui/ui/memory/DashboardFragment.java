package com.example.testui.ui.memory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.LoginActivity;
import com.example.testui.MainActivity;
import com.example.testui.Memory.MemoryMainActivity;
import com.example.testui.Memory.ToDoList;
import com.example.testui.Memory.ToDoListAdapter;
import com.example.testui.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private List<ToDoList> toDoLists=new ArrayList<>();
    private NestedScrollView nestedScrollView;
    private BottomSheetBehavior bottomSheetBehavior;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_memory, container, false);

        Toolbar toolbar=(Toolbar)((AppCompatActivity) getActivity()).findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        /*不显示toolbar自带的项目名*/
        ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        /*
        * toolbar_maintext是toolbar的控件之一
        * 存在于MainActivity之中，root是指当前fragment的布局
        * 所以需要使用fragemnt的父活动ID查找控件*/
        TextView textView=(TextView)((AppCompatActivity) getActivity()).findViewById(R.id.toolbar_maintext);
        textView.setText("备忘录");
        setHasOptionsMenu(true);
        /*
        *
        * Drawerview是MainActivity中的控件
        * 现在不想将每个fragment中都重复编写
        * 想在fragment之中直接控制MainActivity的控件
        * 所以才有了下面的写法
        * 这样可以在MainActivity之中直接编写Drawer的响应事件
        * 而在各个fragment之中就可以直接使用
        * */
        Activity activity=((AppCompatActivity) getActivity());
        final DrawerLayout mDrawerLayout=(DrawerLayout)activity.findViewById(R.id.drawer_layout);
        ImageView imageView=(ImageView)((AppCompatActivity) getActivity()).findViewById(R.id.ToolBar_Icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        initToDoList();
        RecyclerView recyclerView=(RecyclerView)root.findViewById(R.id.todo_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ToDoListAdapter adapter=new ToDoListAdapter(toDoLists);

        recyclerView.setAdapter(adapter);
        Log.d("Adpter","SetOk!!!!!!!!!!!!!!");


        /*编写悬浮按钮的点击事件*/
        nestedScrollView=(NestedScrollView)root.findViewById(R.id.bottom_sheet) ;
        bottomSheetBehavior=BottomSheetBehavior.from(nestedScrollView);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        FloatingActionButton fltbtn=(FloatingActionButton)root.findViewById(R.id.floatbtn);
        fltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        return root;

    }


    private void initToDoList(){
        Log.d("MSFFFFFFFFFFF","initok");
        for(int i=0;i<5;i++){
            ToDoList item1=new ToDoList("又要吃药了哎！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！");
            toDoLists.add(item1);
            ToDoList item2=new ToDoList("又要睡觉了哎！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！");
            toDoLists.add(item2);
            ToDoList item3=new ToDoList("又要起床了哎！");
            toDoLists.add(item3);
        }

    }
    public void showBottomSheet(){
        Log.d("BottomSheet","OKKKKKKKKKK");
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("FragmentMenu","okkkkkkkkkkkkkkkkk");
        inflater.inflate(R.menu.memory_helper, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case android.R.id.home:
//                Log.d("msg","Testok");
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                break;
            case R.id.AddMemory:
                Intent intent2=new Intent(getActivity(), LoginActivity.class);
                Toast.makeText(getActivity(),"You have clickes too",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                break;
//            case R.id.DelMemory:
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                break;

            default:
                break;
        }
        return true;
    }

}