package com.yubing.market.widget;

import android.content.Context;
import android.support.annotation.Nullable;

import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.yubing.market.R;

/**
 * Created by yu on 2017/3/15.
 */

public class MarketToolBar extends Toolbar {
    private LayoutInflater mInflater;
    private View mView;
    private ImageButton mBtnImgleft;
    private EditText mEditText;
    private ImageButton mBtnImgright;

    public MarketToolBar(Context context) {
        this(context,null);
    }

    public MarketToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mInflater = LayoutInflater.from(getContext());
        mView = mInflater.inflate(R.layout.toolbar_home,null);

        mBtnImgleft = (ImageButton) mView.findViewById(R.id.toolbar_left_btn);
        mEditText = (EditText) mView.findViewById(R.id.toolbar_searchview);
        mBtnImgright = (ImageButton) mView.findViewById(R.id.toolbar_right_btn);
        LayoutParams lp=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        addView(mView,lp);
    }
}
