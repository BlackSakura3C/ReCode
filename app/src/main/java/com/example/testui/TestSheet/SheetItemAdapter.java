package com.example.testui.TestSheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.R;

import java.util.List;

public class SheetItemAdapter extends RecyclerView.Adapter<SheetItemAdapter.ViewHolder> {
    private List<SheetItem> msheetItems;

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
        msheetItems = sheetItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testsheetitem, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SheetItem sheetItem=msheetItems.get(position);
        holder.testitemname.setText(sheetItem.getTestitemname());
        holder.unit.setText(sheetItem.getUnit());
    }

    @Override
    public int getItemCount() {
        return msheetItems.size();
    }
}
