package com.android.minlib.smartdialog;

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

    private static float WIDTH_SCALE = 0.8f;
    private Context mContext;
    int width = 0;

    public EmptyDialog(Context context){
        this(context,R.style.lib_empty_dialog_theme);
    }

    public EmptyDialog(Context context,int theme){
        super(context,theme);
        mContext = context;
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
    }

    public void setForceOpen(boolean isForceOpen){
        if(isForceOpen){
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
    }

    public void setWidthScale(float widthScale) {
        WIDTH_SCALE = widthScale;
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int)(width * WIDTH_SCALE); //设置宽度
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
    }

}
