package com.android.minlib.smartdialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
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
    private Context mContext;
    private FrameLayout flContent;
    private View vBottomLine;
    private TextView tvButtonCancel;
    private View vLine1;
    private TextView tvButtonCus;
    private View vLine2;
    private TextView tvButtonSumbmit;

    private Builder mBuilder;
    private static SmartDialog smartDialog = null;


    public SmartDialog(Context context) {
        super(context);
    }

    public void setBuilder(Builder builder){
        mBuilder = builder;
        initView(mContext);
    }

    private void initView(Context context) {
        mContext = context;
        setContentView(R.layout.dialog_custom);
        llRoot = findViewById(R.id.common_dialog_cus_root);
        flContent = findViewById(R.id.common_dialog_cus_content);
        vBottomLine = findViewById(R.id.common_dialog_cus_bottom_line);
        tvButtonCancel = findViewById(R.id.common_dialog_cus_btn_cancel);
        vLine1 = findViewById(R.id.common_dialog_cus_line1);
        tvButtonCus = findViewById(R.id.common_dialog_cus_btn_custom);
        vLine2 = findViewById(R.id.common_dialog_cus_line2);
        tvButtonSumbmit = findViewById(R.id.common_dialog_cus_btn_submit);

        if (mBuilder.rootView != null) {
            llRoot.removeAllViews();
            llRoot.addView(mBuilder.rootView);
            return;
        }

        if (mBuilder.content != null) {
            flContent.addView(mBuilder.content);
        }

        if(mBuilder.lineColor != 0){
            vBottomLine.setBackgroundColor(mBuilder.lineColor);
            vLine1.setBackgroundColor(mBuilder.lineColor);
            vLine2.setBackgroundColor(mBuilder.lineColor);
        }

        if (TextUtils.isEmpty(mBuilder.btnCancel)) {
            tvButtonCancel.setVisibility(View.GONE);
            vLine1.setVisibility(View.GONE);
        } else {
            tvButtonCancel.setVisibility(View.VISIBLE);
            vLine1.setVisibility(View.VISIBLE);
            tvButtonCancel.setText(mBuilder.btnCancel);
            tvButtonCancel.setTextSize(mBuilder.btnCancelTextSize);
            if (mBuilder.btnCancelColor != 0) {
                tvButtonCancel.setTextColor(mBuilder.btnCancelColor);
            }
            if (mBuilder.btnCancelBackground != null) {
                tvButtonCancel.setBackground(mBuilder.btnCancelBackground);
            }
            tvButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (mBuilder.btnCancelListener != null) {
                        mBuilder.btnCancelListener.onClick(SmartDialog.this, v);
                    }
                }
            });
        }

        if (TextUtils.isEmpty(mBuilder.btnCustom)) {
            tvButtonCus.setVisibility(View.GONE);
            vLine2.setVisibility(View.GONE);
        } else {
            tvButtonCus.setVisibility(View.VISIBLE);
            vLine2.setVisibility(View.VISIBLE);
            tvButtonCus.setText(mBuilder.btnCustom);
            tvButtonCus.setTextSize(mBuilder.btnCustomTextSize);
            if (mBuilder.btnCustomColor != 0) {
                tvButtonCus.setTextColor(mBuilder.btnCustomColor);
            }
            if (mBuilder.btnCustomBackground != null) {
                tvButtonCus.setBackground(mBuilder.btnCustomBackground);
            }
            tvButtonCus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    if (mBuilder.btnCustomListener != null) {
                        mBuilder.btnCustomListener.onClick(SmartDialog.this, v);
                    }
                }
            });
        }

        if (TextUtils.isEmpty(mBuilder.btnSubmit)) {
            tvButtonSumbmit.setVisibility(View.GONE);
        } else {
            tvButtonSumbmit.setVisibility(View.VISIBLE);
            tvButtonSumbmit.setText(mBuilder.btnSubmit);
            tvButtonSumbmit.setTextSize(mBuilder.btnSubmitTextSize);
            if (mBuilder.btnSubmitColor != 0) {
                tvButtonSumbmit.setTextColor(mBuilder.btnSubmitColor);
            }
            if (mBuilder.btnSubmitBackground != null) {
                tvButtonSumbmit.setBackground(mBuilder.btnSubmitBackground);
            }
            tvButtonSumbmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBuilder.btnSubmitListener != null) {
                        mBuilder.btnSubmitListener.onClick(SmartDialog.this, v);
                    }
                }
            });
        }
    }

    public TextView getTvButtonCancel() {
        return tvButtonCancel;
    }

    public TextView getTvButtonCus() {
        return tvButtonCus;
    }

    public TextView getTvButtonSumbmit() {
        return tvButtonSumbmit;
    }

    public static class Builder {
        private View rootView;
        private View content;
        private Context context;
        private int lineColor;
        private String btnCancel;
        private int btnCancelColor;
        private Drawable btnCancelBackground;
        private int btnCancelTextSize;
        private String btnCustom;
        private int btnCustomColor;
        private Drawable btnCustomBackground;
        private int btnCustomTextSize;
        private String btnSubmit;
        private int btnSubmitColor;
        private Drawable btnSubmitBackground;
        private int btnSubmitTextSize;
        private ClickListener btnCancelListener;
        private ClickListener btnCustomListener;
        private ClickListener btnSubmitListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setLineColor(int lineColor){
            this.lineColor = lineColor;
            return this;
        }

        public Builder setBtnCancelTextColor(int btnCancelColor) {
            this.btnCancelColor = btnCancelColor;
            return this;
        }

        public Builder setBtnCancelBackground(int btnCancelBackground) {
            this.btnCancelBackground = new ColorDrawable(btnCancelBackground);
            return this;
        }

        public Builder setBtnCancelTextSize(int textSize){
            this.btnCancelTextSize = textSize;
            return this;
        }

        public Builder setBtnCustomTextColor(int btnCustomColor) {
            this.btnCustomColor = btnCustomColor;
            return this;
        }

        public Builder setBtnCustomBackground(int btnCustomBackground) {
            this.btnCustomBackground = new ColorDrawable(btnCustomBackground);
            return this;
        }

        public Builder setBtnCustomTextSize(int textSize){
            this.btnCustomTextSize = textSize;
            return this;
        }

        public Builder setBtnSubmitTextColor(int btnSubmitColor) {
            this.btnSubmitColor = btnSubmitColor;
            return this;
        }

        public Builder setBtnSubmitBackground(int btnSubmitBackground) {
            this.btnSubmitBackground = new ColorDrawable(btnSubmitBackground);
            return this;
        }

        public Builder setBtnSubmitTextSize(int textSize){
            this.btnSubmitTextSize = textSize;
            return this;
        }

        public Builder setRootView(View rootView) {
            this.rootView = rootView;
            return this;
        }

        public Builder setContent(View content) {
            this.content = content;
            return this;
        }

        public Builder setContent(@LayoutRes int layoutId) {
            this.content = View.inflate(context, layoutId, null);
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setBtnCancel(String btnCancel) {
            this.btnCancel = btnCancel;
            return this;
        }

        public Builder setBtnCustom(String btnCustom) {
            this.btnCustom = btnCustom;
            return this;
        }

        public Builder setBtnSubmit(String btnSubmit) {
            this.btnSubmit = btnSubmit;
            return this;
        }

        public Builder setBtnCancelListener(ClickListener btnCancelListener) {
            this.btnCancelListener = btnCancelListener;
            return this;
        }

        public Builder setBtnCustomListener(ClickListener btnCustomListener) {
            this.btnCustomListener = btnCustomListener;
            return this;
        }

        public Builder setBtnSubmitListener(ClickListener btnSubmitListener) {
            this.btnSubmitListener = btnSubmitListener;
            return this;
        }

        public SmartDialog build(){
            if(smartDialog == null){
                smartDialog = new SmartDialog(context);
            }
            smartDialog.setBuilder(this);
            return smartDialog;
        }

    }

    public interface ClickListener {
        void onClick(SmartDialog dialog, View view);
    }
}
