package com.example.testui.ui.subscription;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testui.LoginActivity;
import com.example.testui.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_subscrption, container, false);

        Toolbar toolbar=(Toolbar)((AppCompatActivity) getActivity()).findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView textView=(TextView)((AppCompatActivity) getActivity()).findViewById(R.id.toolbar_maintext);
        textView.setText("推送");
        setHasOptionsMenu(true);
        /*上方也是和下述一样的道理
         *这样的好处还有可以不在fragment的xml中加入toolbar总的就只要一个toolbar文件且只由MainActivity引用就好
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
        ImageView imageView=(ImageView)activity.findViewById(R.id.ToolBar_Icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("FragmentMenu","okkkkkkkkkkkkkkkkk");
        inflater.inflate(R.menu.subscrption_helper, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case android.R.id.home:
//                Log.d("msg","Testok");
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                break;
            case R.id.CollectNews:
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