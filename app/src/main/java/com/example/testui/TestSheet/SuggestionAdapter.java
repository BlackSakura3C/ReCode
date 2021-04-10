package com.example.testui.TestSheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testui.R;

import java.util.List;

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.ViewHolder> {
    private List<Suggestion> msuggestions;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView index;
        TextView testcasename;
        TextView testcaseinput;
        TextView conststring;   //统一填为"建议范围:"
        TextView standardnum;
        TextView suggestion;

        public ViewHolder(View view) {
            super(view);
            index=(TextView)view.findViewById(R.id.suggestion_index);
            testcasename=(TextView)view.findViewById(R.id.suggestion_testcasename);
            testcaseinput=(TextView)view.findViewById(R.id.suggestion_testinput);
            conststring=(TextView)view.findViewById(R.id.suggestion_conststring);
            suggestion=(TextView)view.findViewById(R.id.suggestion_content);
            standardnum=(TextView)view.findViewById(R.id.suggestion_standard);
        }
    }


    public SuggestionAdapter(List<Suggestion> suggestions){
        this.msuggestions=suggestions;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestion_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Suggestion suggestion=msuggestions.get(position);
        holder.index.setText(String.valueOf(suggestion.getIndex()));
        holder.testcasename.setText("您的"+suggestion.getTestcasename()+":");
        holder.testcaseinput.setText(suggestion.getTestcaseinput()+suggestion.getUnit());
        holder.conststring.setText("建议范围:");
        holder.standardnum.setText(suggestion.getStandardnum()+suggestion.getUnit());
        holder.suggestion.setText(suggestion.getSuggestioncontent());
    }

    @Override
    public int getItemCount() {
        return msuggestions.size();
    }

}
