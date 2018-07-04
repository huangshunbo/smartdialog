package com.android.minlib.smartdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.WindowManager;
/**
 * @author: huangshunbo
 * @Filename: EmptyDialog
 * @Description: 空弹框
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/5/17 17:54
 */
class EmptyDialog extends Dialog {

    private static float WIDTH_SCALE = 0.8f;
    private Context mContext;

    public EmptyDialog(Context context){
        super(context,R.style.lib_empty_dialog_theme);
        mContext = context;
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

    public static void setWidthScale(float widthScale) {
        WIDTH_SCALE = widthScale;
    }

    @Override
    public void show() {
        super.show();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int)(width * WIDTH_SCALE); //设置宽度
        getWindow().setAttributes(lp);
    }
}
