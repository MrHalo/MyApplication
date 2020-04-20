package com.devlopment.software.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devlopment.software.demo.CustomView.CustomActivity;
import com.devlopment.software.demo.CustomView.ForegroundActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button viewPagerButton;
    private Button customViewButton;
    private Button foregroundViewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        viewPagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }
        });
//
//        customViewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CustomActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    private void initView() {
        viewPagerButton = findViewById(R.id.view_pager);
        customViewButton = findViewById(R.id.custom_view_show);
        foregroundViewButton = findViewById(R.id.foreground_view_show);
    }

    @Override
    public void onClick(View v) {
        Log.i("MainActivity", "onClick(View v)");
        Intent intent;
        switch (v.getId()){
            case R.id.view_pager:
                intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_view_show:
                intent = new Intent(MainActivity.this, CustomActivity.class);
                startActivity(intent);
                break;
            case R.id.foreground_view_show:
                intent = new Intent(MainActivity.this, ForegroundActivity.class);
                startActivity(intent);
                break;
             default:
                 break;
        }
    }
}
