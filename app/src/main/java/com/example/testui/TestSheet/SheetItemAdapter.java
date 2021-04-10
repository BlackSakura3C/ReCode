package com.example.testui.TestSheet;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SheetItemAdapter extends RecyclerView.Adapter<SheetItemAdapter.ViewHolder> {
    private List<SheetItem> msheetItems;
    private String[] inputcontents;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView testitemname;
        EditText input;
        TextView unit;

        public ViewHolder(View view) {
            super(view);
            testitemname = (TextView) view.findViewById(R.id.testsheet_item_text_1);
            input = (EditText) view.findViewById(R.id.testsheet_item_edittext);
            unit = (TextView) view.findViewById(R.id.testsheet_item_text_2);
        }
    }

    public SheetItemAdapter(List<SheetItem> sheetItems) {
        this.msheetItems = sheetItems;
        inputcontents=new String[sheetItems.size()];  //不初始化会造成inputcontents.add(position,s.toString());时越界
        Log.d("SIZE: ",String.valueOf(inputcontents.length));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testsheetitem, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        SheetItem sheetItem=msheetItems.get(position);
        holder.testitemname.setText(sheetItem.getTestitemname());
        holder.unit.setText(sheetItem.getUnit());
        /*
         * RecycleView 内部包含EditText可能触发的一些问题
         * 会在用软键盘填写第一个内容时最后一项也被填写
         * 或者莫名其妙消失
         * 这个应该是由于RecycleView的自动回收重用机制造成的
         *
         */
        //首先先把之前可能存在的TextWatcher解除掉
        if(holder.input.getTag()!=null&&holder.input.getTag() instanceof TextWatcher){
            holder.input.removeTextChangedListener((TextWatcher)holder.input.getTag());
        }
        //感觉上可以不赋值只在后面watcher保存以备遍历使用但是 如果不在bind时给值就有可能被滚动时回收刷掉
        holder.input.setText(inputcontents[position]);
        TextWatcher textWatcher=new TextWatcher() {
            /*
             * 尝试将recycleview中的edittext内容全部读出
             * 不能直接用findViewByPosition 因为有些内容不在当前显示中
             * 会被重新利用掉 所以那些内容将返回NULL
             * 这里看了StackOverflow 尝试用text change listener
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("INDEX NUM:",position+" "+s.toString());
                inputcontents[position]=s.toString();
            }
        };
        holder.input.addTextChangedListener(textWatcher);
        /*
         * 配合前面解决刷新造成的数据错乱
         */
        holder.input.setTag(textWatcher);
    }

    @Override
    public int getItemCount() {
        return msheetItems.size();
    }

    public String[] getInputcontents(){
        return this.inputcontents;
    }

}
