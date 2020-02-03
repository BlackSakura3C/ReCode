package com.example.testui;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//
////        View icon=(View) findViewById(R.id.AddMemory);
////        icon.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(getBaseContext(),"You have clickes AAAAAAAAAAAAAAAA",Toast.LENGTH_SHORT);
////            }
////        });
//
//
//        //Log.d("MDDDDDDDDDDDDDDDD",toolbar.toString());
        if(actionBar!=null){
            Log.d("MSSSSSSSSSSSSSSSSSSS",actionBar.toString());
            Log.d("MFFFFFFFFFFFFFFFFFFF","ssssssssssss");
            //actionBar.setTitle("LALAALAL");
            actionBar.setHomeButtonEnabled(true);
            //actionBar.setLogo(R.drawable.ic_dashboard_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_dashboard_black_24dp);
        }

        ImageView imageView=(ImageView)findViewById(R.id.ToolBar_Icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = findViewById(R.id.container);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
//                .setDrawerLayout(drawer)
//                .build();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_subscription, R.id.navigation_memory, R.id.navigation_test)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        Log.d("Msg","OKKKKKKKKKK");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memory_helper,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"You have clickes AAAAAAAAAAAAAAAA",Toast.LENGTH_SHORT);
        switch (item.getItemId()){
            case android.R.id.home:
                Log.d("meeeeeeeeeeeeeee","sssssssssssssss");
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.AddMemory:
                Intent intent2=new Intent(this,LoginActivity.class);
                Toast.makeText(this,"You have clickes too",Toast.LENGTH_SHORT);
                startActivity(intent2);
                Toast.makeText(this,"You have clickes",Toast.LENGTH_SHORT);
                break;
            case R.id.DelMemory:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
//            case  R.id.ConnectUs:
//                Intent intent=new Intent(this,LoginActivity.class);
//                Toast.makeText(this,"You have clickes too",Toast.LENGTH_SHORT);
//                startActivity(intent);
//                break;
            default:
                break;
        }
        return true;
    }

}
