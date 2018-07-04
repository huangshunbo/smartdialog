package com.android.minlib.smartdialog;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: SmartDialog
 * @Description: 自定义扩展弹框
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/3/22 18:14
 */
public class SmartDialog extends EmptyDialog{

    private FrameLayout llRoot;
    private FrameLayout flContent;
    private View vBottomLine;
    private TextView tvButtonLeft;
    private View vLine1;
    private TextView tvButtonMiddle;
    private View vLine2;
    private TextView tvButtonRight;

    private static int default_style = R.style.lib_common_dialog_theme;

    private SmartDialog(Context context) {
        super(context);
    }

    private SmartDialog(Builder builder) {
        super(builder.mContext,builder.mDialogTheme);
        initView(builder);
    }

    private void initView(final Builder builder) {
        setContentView(R.layout.dialog_custom);
        llRoot = findViewById(R.id.common_dialog_cus_root);
        flContent = findViewById(R.id.common_dialog_cus_content);
        vBottomLine = findViewById(R.id.common_dialog_cus_bottom_line);
        tvButtonLeft = findViewById(R.id.common_dialog_cus_btn_cancel);
        vLine1 = findViewById(R.id.common_dialog_cus_line1);
        tvButtonMiddle = findViewById(R.id.common_dialog_cus_btn_custom);
        vLine2 = findViewById(R.id.common_dialog_cus_line2);
        tvButtonRight = findViewById(R.id.common_dialog_cus_btn_submit);

        boolean isLeftShow = false,isMiddleShow = false,isRightShow = false;

        if(builder.content != null){
            flContent.removeAllViews();
            flContent.addView(builder.content);
        }

        if (TextUtils.isEmpty(builder.buttonLeftTxt)) {
            tvButtonLeft.setVisibility(View.GONE);
        } else {
            isLeftShow = true;
            tvButtonLeft.setVisibility(View.VISIBLE);
            tvButtonLeft.setText(builder.buttonLeftTxt);
            tvButtonLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(builder.isButtonAutoDismiss){
                        dismiss();
                    }
                    if (builder.leftOnclickListener != null) {
                        builder.leftOnclickListener.onClick(tvButtonLeft);
                    }
                }
            });
        }

        if (TextUtils.isEmpty(builder.buttonMiddleTxt)) {
            tvButtonMiddle.setVisibility(View.GONE);
        } else {
            isMiddleShow = true;
            tvButtonMiddle.setVisibility(View.VISIBLE);
            tvButtonMiddle.setText(builder.buttonMiddleTxt);
            tvButtonMiddle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(builder.isButtonAutoDismiss){
                        dismiss();
                    }
                    if (builder.middleOnclickListener != null) {
                        builder.middleOnclickListener.onClick(tvButtonMiddle);
                    }
                }
            });
        }

        if (TextUtils.isEmpty(builder.buttonRightTxt)) {
            tvButtonRight.setVisibility(View.GONE);
        } else {
            isRightShow = true;
            tvButtonRight.setVisibility(View.VISIBLE);
            tvButtonRight.setText(builder.buttonRightTxt);
            tvButtonRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(builder.isButtonAutoDismiss){
                        dismiss();
                    }
                    if (builder.rightOnclickListener != null) {
                        builder.rightOnclickListener.onClick(tvButtonRight);
                    }
                }
            });
        }

        vBottomLine.setVisibility(isLeftShow || isMiddleShow || isRightShow ? View.VISIBLE : View.GONE);
        vLine1.setVisibility((isLeftShow && isMiddleShow)||(isLeftShow && isRightShow) ? View.VISIBLE : View.GONE);
        vLine2.setVisibility(isMiddleShow && isRightShow ? View.VISIBLE : View.GONE);
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

    public static final class Builder {
        private View content;
        private String buttonLeftTxt;
        private String buttonMiddleTxt;
        private String buttonRightTxt;
        private View.OnClickListener leftOnclickListener;
        private View.OnClickListener middleOnclickListener;
        private View.OnClickListener rightOnclickListener;
        private boolean isButtonAutoDismiss = false;
        private Context mContext;
        private @StyleRes int mDialogTheme;

        public Builder(Context context) {
            mContext = context;
            mDialogTheme = default_style;
        }

        public Builder setContent(View content) {
            this.content = content;
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
            return new SmartDialog(this);
        }
    }
}
