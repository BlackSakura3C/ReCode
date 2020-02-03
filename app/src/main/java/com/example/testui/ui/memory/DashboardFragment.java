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

import com.example.testui.Memory.MemoryMainActivity;
import com.example.testui.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_memory, container, false);
        Log.d("CHECKKKKKKKK","OKKKKKKKKKKKKKKK");
//        Toolbar toolbar=(Toolbar)root.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //setHasOptionsMenu(true);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;

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