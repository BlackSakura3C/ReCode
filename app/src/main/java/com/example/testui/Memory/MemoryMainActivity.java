package com.example.testui.Memory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testui.R;

import java.util.ArrayList;
import java.util.List;

public class MemoryMainActivity extends AppCompatActivity {
    private List<ToDoList> toDoLists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_memory);
        initToDoList();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.todo_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ToDoListAdapter adapter=new ToDoListAdapter(toDoLists);
        recyclerView.setAdapter(adapter);
        Log.d("Adpter","SetOk!!!!!!!!!!!!!!");
    }
    private void initToDoList(){
        Log.d("MSFFFFFFFFFFF","initok");
        for(int i=0;i<2;i++){
            ToDoList item1=new ToDoList("又要吃药了哎！");
            toDoLists.add(item1);
            ToDoList item2=new ToDoList("又要睡觉了哎！");
            toDoLists.add(item2);
            ToDoList item3=new ToDoList("又要起床了哎！");
            toDoLists.add(item3);
        }

    }

}
