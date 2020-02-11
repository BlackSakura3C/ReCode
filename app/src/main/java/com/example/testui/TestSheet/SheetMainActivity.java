package com.example.testui.TestSheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testui.R;

public class SheetMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testsheet);
        Button btn1=(Button)findViewById(R.id.testsheet_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SheetMainActivity.this,SheetSuggestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
