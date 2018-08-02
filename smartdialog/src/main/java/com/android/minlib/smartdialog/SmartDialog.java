package com.android.minlib.smartdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: SmartDialog
 * @Description: 自定义扩展弹框
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/3/22 18:14
 */
public class SmartDialog<T extends View> extends EmptyDialog {

    private FrameLayout flContent;
    private LinearLayout llBottom;
    private View vBottomLine;
    private TextView tvButtonLeft;
    private View vLine1;
    private TextView tvButtonMiddle;
    private View vLine2;
    private TextView tvButtonRight;

    private Builder mBuilder;

    private static int default_style = R.style.lib_common_dialog_theme;

    private SmartDialog(Context context) {
        super(context);
    }

    private SmartDialog(Builder builder) {
        super(builder.mContext,builder.mDialogTheme);
        mBuilder = builder;
        initView();
    }

    private void setBuilder(Builder builder){
        mBuilder = builder;
        initView();
    }


    @Override
    public void show() {
        initData(mBuilder);
        super.show();
    }

    private void initView(){
        setContentView(R.layout.dialog_custom);
        flContent = findViewById(R.id.common_dialog_cus_content);
        llBottom = findViewById(R.id.common_dialog_cus_bottom);
        vBottomLine = findViewById(R.id.common_dialog_cus_bottom_line);
        tvButtonLeft = findViewById(R.id.common_dialog_cus_btn_cancel);
        vLine1 = findViewById(R.id.common_dialog_cus_line1);
        tvButtonMiddle = findViewById(R.id.common_dialog_cus_btn_custom);
        vLine2 = findViewById(R.id.common_dialog_cus_line2);
        tvButtonRight = findViewById(R.id.common_dialog_cus_btn_submit);
    }

    private void initData(final Builder builder) {

        if(builder.contentView != null){
            flContent.removeAllViews();
            flContent.addView(builder.contentView);
        }

        boolean isLeftShow = false,isMiddleShow = false,isRightShow = false;

        if(!TextUtils.isEmpty(tvButtonLeft.getText())){
            mBuilder.buttonLeftTxt = tvButtonLeft.getText().toString();
        }
        if(!TextUtils.isEmpty(tvButtonMiddle.getText())){
            mBuilder.buttonMiddleTxt = tvButtonMiddle.getText().toString();
        }
        if(!TextUtils.isEmpty(tvButtonRight.getText())){
            mBuilder.buttonRightTxt = tvButtonRight.getText().toString();
        }

        if (TextUtils.isEmpty(builder.buttonLeftTxt)) {
            tvButtonLeft.setVisibility(View.GONE);
        } else {
            isLeftShow = true;
            setTextViewProperty(tvButtonLeft,builder.isButtonAutoDismiss,builder.buttonLeftTxt,builder.buttonLeftTextColor,builder.buttonLeftBackground,builder.leftOnclickListener);
        }

        if (TextUtils.isEmpty(builder.buttonMiddleTxt)) {
            tvButtonMiddle.setVisibility(View.GONE);
        } else {
            isMiddleShow = true;
            setTextViewProperty(tvButtonMiddle,builder.isButtonAutoDismiss,builder.buttonMiddleTxt,builder.buttonMiddleTextColor,builder.buttonMiddleBackground,builder.middleOnclickListener);
        }

        if (TextUtils.isEmpty(builder.buttonRightTxt)) {
            tvButtonRight.setVisibility(View.GONE);
        } else {
            isRightShow = true;
            setTextViewProperty(tvButtonRight,builder.isButtonAutoDismiss,builder.buttonRightTxt,builder.buttonRightTextColor,builder.buttonRightBackground,builder.rightOnclickListener);
        }

        llBottom.setVisibility(isLeftShow || isMiddleShow || isRightShow ? View.VISIBLE : View.GONE);
        vBottomLine.setVisibility(isLeftShow || isMiddleShow || isRightShow ? View.VISIBLE : View.GONE);
        vLine1.setVisibility((isLeftShow && isMiddleShow)||(isLeftShow && isRightShow) ? View.VISIBLE : View.GONE);
        vLine2.setVisibility(isMiddleShow && isRightShow ? View.VISIBLE : View.GONE);
    }

    @SuppressLint("ResourceType")
    private void setTextViewProperty(final TextView textView, final boolean isButtonAutoDismiss, String buttonText, @ColorRes int buttonTextColor, Drawable buttonBackground, final View.OnClickListener clickListener){
        textView.setVisibility(View.VISIBLE);
        textView.setText(buttonText);
        if(buttonTextColor < 0){
            textView.setTextColor(buttonTextColor);
        }else if(buttonTextColor > 0){
            textView.setTextColor(ContextCompat.getColor(mBuilder.mContext,buttonTextColor));
        }
        if(buttonBackground != null){
            textView.setBackground(buttonBackground);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isButtonAutoDismiss){
                    dismiss();
                }
                if (clickListener != null) {
                    clickListener.onClick(textView);
                }
            }
        });
    }

    public T getContentView(){
        return (T) mBuilder.contentView;
    }

    public TextView getTvButtonLeft() {
        return tvButtonLeft;
    }

    public TextView getTvButtonMiddle() {
        return tvButtonMiddle;
    }

    public TextView getTvButtonRight() {
        return tvButtonRight;
    }

    public View getBottomLine() {
        return vBottomLine;
    }

    public View getLine1() {
        return vLine1;
    }

    public View getLine2() {
        return vLine2;
    }

    public static final class Builder<E extends View> {
        private String buttonLeftTxt;
        private String buttonMiddleTxt;
        private String buttonRightTxt;
        private @ColorRes int buttonLeftTextColor;
        private @ColorRes int buttonMiddleTextColor;
        private @ColorRes int buttonRightTextColor;
        private Drawable buttonLeftBackground;
        private Drawable buttonMiddleBackground;
        private Drawable buttonRightBackground;
        private View.OnClickListener leftOnclickListener;
        private View.OnClickListener middleOnclickListener;
        private View.OnClickListener rightOnclickListener;
        private boolean isButtonAutoDismiss = false;
        private Context mContext;
        private @StyleRes int mDialogTheme;
        private E contentView;

        public Builder(Context context) {
            mContext = context;
            mDialogTheme = default_style;
        }

        public Builder setContentView(E view) {
            contentView = view;
            return this;
        }

        public Builder setButtonAutoDismiss(boolean buttonAutoDismiss) {
            isButtonAutoDismiss = buttonAutoDismiss;
            return this;
        }

        public Builder setTheme(@StyleRes int theme){
            mDialogTheme = theme;
            return this;
        }

        public Builder setButtonLeft(String val) {
            buttonLeftTxt = val;
            return this;
        }

        public Builder setButtonMiddle(String val) {
            buttonMiddleTxt = val;
            return this;
        }

        public Builder setButtonRight(String val) {
            buttonRightTxt = val;
            return this;
        }

        public Builder buttonLeftTextColor(int val) {
            buttonLeftTextColor = val;
            return this;
        }

        public Builder buttonMiddleTextColor(int val) {
            buttonMiddleTextColor = val;
            return this;
        }

        public Builder buttonRightTextColor(int val) {
            buttonRightTextColor = val;
            return this;
        }

        public Builder buttonLeftBackground(Drawable val) {
            buttonLeftBackground = val;
            return this;
        }

        public Builder buttonMiddleBackground(Drawable val) {
            buttonMiddleBackground = val;
            return this;
        }

        public Builder buttonRightBackground(Drawable val) {
            buttonRightBackground = val;
            return this;
        }

        public Builder setLeftOnclickListener(View.OnClickListener leftOnclickListener) {
            this.leftOnclickListener = leftOnclickListener;
            return this;
        }

        public Builder setMiddleOnclickListener(View.OnClickListener middleOnclickListener) {
            this.middleOnclickListener = middleOnclickListener;
            return this;
        }

        public Builder setRightOnclickListener(View.OnClickListener rightOnclickListener) {
            this.rightOnclickListener = rightOnclickListener;
            return this;
        }

        public SmartDialog build() {
            if(smartDialog == null){
                smartDialog = new SmartDialog<E>(this);
            }else {
                smartDialog.setBuilder(this);
                if(smartDialog.isShowing()){
                    smartDialog.dismiss();
                }
            }

            return smartDialog;
        }

    }

    private static SmartDialog smartDialog;
}
