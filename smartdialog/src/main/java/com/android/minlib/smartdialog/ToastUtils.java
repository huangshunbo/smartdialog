package com.android.minlib.smartdialog;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author: huangshunbo
 * @Filename: ToastUtils
 * @Description: 吐司
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/5/17 17:54
 */
public class ToastUtils {

    private static Toast mToast = null;

    private static Toast getToast(Context context,String content){
        mToast = new Toast(context);
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.toast_layout_content, null);
        TextView tv = (TextView) v.findViewById(R.id.common_toast_message);
        tv.setText(content);
        mToast.setView(v);
        return mToast;
    }

    /**
     *<br> Description: 居中显示Toast
     *<br> Author:      huangshunbo
     *<br> Date:        2018/5/17 16:51
     */
    public static void showCenterToast(Context context,String content, int duration) {
        showToast(context,content,duration,Gravity.CENTER);
    }
    public static void showCenterToast(Context context, @StringRes int resId, int duration) {
        showToast(context, context.getString(resId),duration,Gravity.CENTER);
    }
    public static void showCenterToast(Context context,String content) {
        showToast(context,content,Toast.LENGTH_SHORT,Gravity.CENTER);
    }
    public static void showCenterToast(Context context, @StringRes int resId) {
        showToast(context, context.getString(resId),Toast.LENGTH_SHORT,Gravity.CENTER);
    }

    /**
     *<br> Description: 底部显示Toast
     *<br> Author:      huangshunbo
     *<br> Date:        2018/5/17 16:51
     */
    public static void showBottomToast(Context context,String content, int duration) {
        showToast(context,content,duration,Gravity.BOTTOM);
    }
    public static void showBottomToast(Context context, @StringRes int resId, int duration) {
        showToast(context, context.getString(resId),duration,Gravity.BOTTOM);
    }
    public static void showBottomToast(Context context,String content) {
        showToast(context,content,Toast.LENGTH_SHORT,Gravity.BOTTOM);
    }
    public static void showBottomToast(Context context, @StringRes int resId) {
        showToast(context, context.getString(resId),Toast.LENGTH_SHORT,Gravity.BOTTOM);
    }

    /**
     *<br> Description: 顶部显示Toast
     *<br> Author:      huangshunbo
     *<br> Date:        2018/5/17 16:51
     */
    public static void showTopToast(Context context,String content, int duration) {
        showToast(context,content,duration,Gravity.TOP);
    }
    public static void showTopToast(Context context, @StringRes int resId, int duration) {
        showToast(context, context.getString(resId),duration,Gravity.TOP);
    }
    public static void showTopToast(Context context,String content) {
        showToast(context,content,Toast.LENGTH_SHORT,Gravity.TOP);
    }
    public static void showTopToast(Context context, @StringRes int resId) {
        showToast(context, context.getString(resId),Toast.LENGTH_SHORT,Gravity.TOP);
    }

    public static void cancel(){
        if(mToast != null){
            mToast.cancel();
        }
    }

    private static void showToast(Context context,String content, int duration,int gravity) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = getToast(context, content);
        mToast.setGravity(gravity, 0, 0);
        mToast.setDuration(duration);
        mToast.show();
    }

}
