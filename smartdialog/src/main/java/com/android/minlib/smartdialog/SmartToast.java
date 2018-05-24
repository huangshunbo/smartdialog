package com.android.minlib.smartdialog;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: SmartToast
 * @Description: 添加window到APP中 Test
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/5/17 17:53
 */
@Deprecated
public class SmartToast {

    private Context mContext;
    private WindowManager mWindowManager;
    private View mToastView;
    private TextView mTextView;
    private WindowManager.LayoutParams mParams;
    private Handler mHandler;

    public SmartToast(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //通过inflate获取自定义的Toast布局文件
        mToastView = LayoutInflater.from(context).inflate(R.layout.toast_layout_content,null);
        mTextView = (TextView) mToastView.findViewById(R.id.common_toast_message);
        //设置布局参数
        setParams();
    }

    public void setText(String message){
        mTextView.setText(message);
    }

    private void setParams() {
        mParams = new WindowManager.LayoutParams();
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.format = PixelFormat.TRANSLUCENT;
        mParams.windowAnimations = R.style.anim_view;//设置进入退出动画效果
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        mParams.alpha = 1.0f;
        mParams.setTitle("Toast");
        mParams.packageName = mContext.getPackageName();
        mParams.gravity = Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM;//设置显示的位置
        mParams.y = 50;//设置偏移量
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        mParams.gravity = gravity;
        mParams.x = xOffset;
        mParams.y = yOffset;
    }

    public void show(long showtime) {
            mWindowManager.addView(mToastView, mParams);
            if (mHandler == null) {
                mHandler = new Handler();
            }
            mHandler.postDelayed(timerRunnable, showtime);
    }

    private final Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (mToastView != null && mToastView.getParent() != null) {
                mWindowManager.removeView(mToastView);
                mHandler.removeCallbacks(timerRunnable);
            }
        }
    };

    public void cancel() {
        mHandler.post(timerRunnable);
    }
}
