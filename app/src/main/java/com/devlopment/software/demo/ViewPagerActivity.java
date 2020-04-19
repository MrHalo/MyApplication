package com.devlopment.software.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> mList = new ArrayList<Fragment>();
    FragmentManager mFragmentManager;
    private ViewpagerFragmentAdapter mViewpagerFragmentAdapter;
    TextView titleTextView;
    ViewPager viewPager;
    RadioButton chatTV;
    RadioButton friendTV;
    RadioButton discoverTV;
    String[] titleName = new String[] {"微信","朋友","发现"};
    public static final String TAG = "ViewPagerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //1.首先得有一个FragmentManager，用来管理这些Fragment；
        mFragmentManager = getSupportFragmentManager();
        // 2.初始化被管理的Fragment，添加到集合中；
        initFragmentList();
        //3.创建一个适配器，连接适配器,从而实现适配器的绑定；
        mViewpagerFragmentAdapter = new ViewpagerFragmentAdapter(mFragmentManager, mList);
        initView();
        // 4.初始化ViewPager
        initViewPager();
    }

    private void initViewPager() {
        viewPager.addOnPageChangeListener(new ViewPagerOnPageChangedLisenter());
        viewPager.setAdapter(mViewpagerFragmentAdapter);
        viewPager.setCurrentItem(0);
        titleTextView.setText(titleName[0]);
        updateBottomTextView(true,false,false);
    }

    private void initView() {
        titleTextView = findViewById(R.id.view_title);
        viewPager = findViewById(R.id.view_pager_show);
        chatTV = findViewById(R.id.firstTextView);
        friendTV = findViewById(R.id.secondTextView);
        discoverTV = findViewById(R.id.thirdTextView);
        chatTV.setOnClickListener(this);
        friendTV.setOnClickListener(this);
        discoverTV.setOnClickListener(this);
    }

    private void initFragmentList() {
        ChatFragment chatFragment = new ChatFragment();
        FriendFragment friendFragment = new FriendFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        mList.add(chatFragment);
        mList.add(friendFragment);
        mList.add(discoverFragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstTextView:
                viewPager.setCurrentItem(0);
//                updateBottomTextView(true,false,false);
                Log.i(TAG, "select chat fragment");
                break;
            case R.id.secondTextView:
                viewPager.setCurrentItem(1);
//                updateBottomTextView(false,true,false);
                Log.i(TAG, "select friend fragment");
                break;
            case R.id.thirdTextView:
                viewPager.setCurrentItem(2);
//                updateBottomTextView(false,false,true);
                Log.i(TAG, "select find fragment");
                break;
            default:
                break;
        }
    }

    private void updateBottomTextView(boolean f, boolean f1, boolean f2){
        chatTV.setSelected(f);
        friendTV.setSelected(f1);
        discoverTV.setSelected(f2);
    }

    class ViewPagerOnPageChangedLisenter implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int i, float v, int i1) {
            Log.i(TAG, "somebody scrolls me");
        }

        @Override
        public void onPageSelected(int i) {
            Log.i(TAG, "I was selected");
            boolean[] state = new boolean[titleName.length];
            state[i] = true;
            titleTextView.setText(titleName[i]);
            updateBottomTextView(state[0],state[1],state[2]);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
            Log.d(TAG,"onPageScrollStateChanged");
        }
    }
}
