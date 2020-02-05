package com.example.testui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testui.MainActivity;
import com.example.testui.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button=(Button)findViewById(R.id.LoginConfirm);
        TextView SignUp=(TextView)findViewById(R.id.LoginSignIn);
        TextView RstPsw=(TextView)findViewById(R.id.LoginResetPwd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 此处需要对输入的账号和密码进行判断才可以登录
                *
                *
                *
                *
                *
                *
                * */

//                FragmentManager fragmentManager=getSupportFragmentManager();
//                FragmentTransaction transition=fragmentManager.beginTransaction();
//                transition.replace(R.id.blanklayout,new BlankFragment());
//                transition.commit();
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*进入注册界面进行用户注册*/
                Intent intent=new Intent(LoginActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });
        RstPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*进入重新设置密码的界面*/
            }
        });


    }
}
