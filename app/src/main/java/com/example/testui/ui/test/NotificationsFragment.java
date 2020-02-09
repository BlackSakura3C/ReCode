package com.example.testui.ui.test;

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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testui.Login.LoginActivity;
import com.example.testui.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_test, container, false);
//        Toolbar toolbar=(Toolbar)root.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        TextView textView=(TextView)((AppCompatActivity) getActivity()).findViewById(R.id.toolbar_maintext);
        textView.setText("自我测试");
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("FragmentMenu","okkkkkkkkkkkkkkkkk");
        inflater.inflate(R.menu.test_helper, menu);
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