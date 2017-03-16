package com.yubing.market;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;


import com.yubing.market.bean.Tab;
import com.yubing.market.fragment.HomeFragment;
import com.yubing.market.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mFragmentTabHost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        // mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec("home").setIndicator());
        initTab();
    }

    private void initTab() {
        Tab tab_home = new Tab(R.drawable.selector_icon_home, R.string.home, HomeFragment.class);
        Tab tab_categroy = new Tab(R.drawable.selector_icon_category, R.string.catagory, HomeFragment.class);
        Tab tab_find = new Tab(R.drawable.selector_icon_find, R.string.find, HomeFragment.class);
        Tab tab_cart = new Tab(R.drawable.selector_icon_cart, R.string.cart, HomeFragment.class);
        Tab tab_mine = new Tab(R.drawable.selector_icon_mine, R.string.mine, HomeFragment.class);

        mTabs.add(tab_home);
        mTabs.add(tab_categroy);
        mTabs.add(tab_find);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);

        //读view用到
        mInflater = LayoutInflater.from(this);
        mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //一定要调用这个方法来初始化
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);


        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            //往TabHOST中添加数据
            mFragmentTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        mFragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mFragmentTabHost.setCurrentTab(0);

    }

    /**
     *
     * @param tab
     * @return
     */
    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        img.setBackgroundResource(tab.getIcon());

        return view;
    }

}
