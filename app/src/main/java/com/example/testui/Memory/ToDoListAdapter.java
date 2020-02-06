package com.example.testui.Memory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.R;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {
    private List<ToDoList> mToDoList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        TextView textView;
        TextView textView_time;
        public ViewHolder(View view){
            super(view);
            checkBox=(CheckBox)view.findViewById(R.id.checkstatus);
            textView=(TextView) view.findViewById(R.id.todo_event);
            textView_time=(TextView)view.findViewById(R.id.todo_time);


        }
    }
    public ToDoListAdapter(List<ToDoList> ToDoList_List){
        mToDoList=ToDoList_List;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("InitialCreate","Initial ok!!!!!!!!!!");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("InitialBind","Initial ok!!!!!!!!!!");
        ToDoList toDoList=mToDoList.get(position);
        holder.textView_time.setText(toDoList.getDate());
        holder.textView.setText(toDoList.getEvent());
        Log.d("ADPTER",toDoList.getEvent());
        holder.checkBox.setChecked(toDoList.getChecked());

    }
    public int getItemCount(){
        Log.d("NUMMMMMM",String.valueOf(mToDoList.size()));
        return mToDoList.size();
    }
}

