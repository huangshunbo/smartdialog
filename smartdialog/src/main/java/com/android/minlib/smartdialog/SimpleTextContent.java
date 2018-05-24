package com.android.minlib.smartdialog;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: SimpleTextContent
 * @Description: 自定义弹框内容样式：主标题+副标题
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/3/27 17:05
 */
public class SimpleTextContent extends LinearLayout{

    TextView tvTitle;
    TextView tvSubTitle;

    private Context mContext;
    public SimpleTextContent(String title,String subTitle,Context context){
        this(context);
        setTxt(title,subTitle);
    }
    public SimpleTextContent(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView(){
        inflate(mContext, R.layout.dialog_simple_text,this);
        tvTitle = findViewById(R.id.common_dialog_simple_txt_title);
        tvSubTitle = findViewById(R.id.common_dialog_simple_txt_sub_title);
    };

    public void setTvTitleSize(int size){
        tvTitle.setTextSize(size);
    }
    public void setTvTitleColor(int color){
        tvTitle.setTextColor(color);
    }
    public void setTvTitleAttr(int size,int color){
        tvTitle.setTextSize(size);
        tvTitle.setTextColor(color);
    }
    public void setTvSubTitleSize(int size){
        tvSubTitle.setTextSize(size);
    }
    public void setTvSubTitleColor(int color){
        tvSubTitle.setTextColor(color);
    }
    public void setTvSubTitleAttr(int size,int color){
        tvSubTitle.setTextSize(size);
        tvSubTitle.setTextColor(color);
    }
    public void setTxt(String title,String subTitle){
        if(TextUtils.isEmpty(title)){
            tvTitle.setVisibility(GONE);
        }else {
            tvTitle.setVisibility(VISIBLE);
            tvTitle.setText(title);
        }

        if(TextUtils.isEmpty(subTitle)){
            tvSubTitle.setVisibility(GONE);
        }else {
            tvSubTitle.setVisibility(VISIBLE);
            tvSubTitle.setText(subTitle);
        }


    }
}
