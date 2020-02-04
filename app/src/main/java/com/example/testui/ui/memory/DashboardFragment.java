package com.example.testui.ui.memory;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.MainActivity;
import com.example.testui.Memory.MemoryMainActivity;
import com.example.testui.Memory.ToDoList;
import com.example.testui.Memory.ToDoListAdapter;
import com.example.testui.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private List<ToDoList> toDoLists=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_memory, container, false);


//        Button btn=(Button)root.findViewById(R.id.recycle_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getContext(),MemoryMainActivity.class);
//                startActivity(intent);
//            }
//        });
        initToDoList();
        RecyclerView recyclerView=(RecyclerView)root.findViewById(R.id.todo_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ToDoListAdapter adapter=new ToDoListAdapter(toDoLists);

        recyclerView.setAdapter(adapter);
        Log.d("Adpter","SetOk!!!!!!!!!!!!!!");
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





    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.memory_helper, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(getContext(),"You have clickesAASDDDDDDDD",Toast.LENGTH_SHORT);
//        switch (item.getItemId()) {
//            case R.id.MyAnlysis:
//                Intent intent=new Intent(getContext(), MemoryMainActivity.class);
//                startActivity(intent);
//                return true;
//            case R.id.LastSuggestion:
//                return true;
//            case R.id.ConnectUs:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }




//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        Log.d("Msg","hhhhhhh");
//    }

}