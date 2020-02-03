package com.example.testui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去掉标题栏
        setContentView(R.layout.activity_welcome);
        new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1000);
                    Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
