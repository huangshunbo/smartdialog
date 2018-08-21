package com.android.minlib.smartdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @author: huangshunbo
 * @Filename: EmptyDialog
 * @Description: 空弹框
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/5/17 17:54
 */
public class EmptyDialog extends Dialog {

    private float WIDTH_SCALE = 0.8f;
    private Context mContext;

    public EmptyDialog(Context context){
        this(context,R.style.lib_empty_dialog_theme);
    }

    public EmptyDialog(Context context,int theme){
        super(context,theme);
        mContext = context;
    }

    public void setForceOpen(boolean isForceOpen){
        if(isForceOpen){
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void show() {
        if(!((Activity) mContext).isFinishing()) {
            super.show();
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.dimAmount = 0.2f;
            getWindow().setAttributes(lp);
        }
    }

}
