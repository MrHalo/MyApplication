package com.devlopment.software.demo.CustomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.devlopment.software.demo.R;

public class CustomActivity extends AppCompatActivity {
    public static final String TAG = "MenuItemLayout";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Log.i(TAG, "onCreate");
    }

    public void onClick(View view) {
        Log.i(TAG, "onClick(View view)");
        Toast toast;
        switch (view.getId()){
            case R.id.firstMenuItemLayout:
                MenuItemLayout menuItemLayout = (MenuItemLayout)view;
                toast = Toast.makeText(CustomActivity.this, menuItemLayout.getTitleText() + "被点击了", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
             default:
                 toast =Toast.makeText(CustomActivity.this, "我被点击了", Toast.LENGTH_SHORT);
                 toast.setGravity(Gravity.CENTER, 0, 0);
                 toast.show();
                 break;

        }
    }
}
