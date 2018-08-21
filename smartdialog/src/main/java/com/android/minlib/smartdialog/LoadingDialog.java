package com.android.minlib.smartdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoadingDialog extends EmptyDialog {

    private LinearLayout llContent;
    private ImageView ivIcon;
    private TextView tvMessage;

    private static LoadingDialog loadingDialog;
    private static final int DEFAULT_STYLE = R.style.lib_dialog_loading_theme;

    private LoadingDialog(Context context, int theme) {
        super(context, theme);
        setContentView(R.layout.dialog_loading);
        llContent = findViewById(R.id.dialog_loading_content);
        ivIcon = findViewById(R.id.dialog_loading_icon);
        tvMessage = findViewById(R.id.dialog_loading_message);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        llContent.measure(widthMeasureSpec, heightMeasureSpec);
    }

    public static void showLoading(Context context, boolean isForceOpen, String message, Drawable drawable, int theme) {
        if (loadingDialog == null || theme != 0) {
            loadingDialog = new LoadingDialog(context, theme == 0 ? DEFAULT_STYLE : theme);
        }
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        loadingDialog.setForceOpen(isForceOpen);
        if (!TextUtils.isEmpty(message)) {
            loadingDialog.setMessage(message);
        }
        if (drawable != null) {
            loadingDialog.setDrawable(drawable);
        }
        loadingDialog.startAnimation();
        loadingDialog.show();
    }

    public static void showLoading(Context context, String message) {
        showLoading(context, true, message, null, 0);
    }

    public static void showLoading(Context context, boolean isForceOpen, String message) {
        showLoading(context, isForceOpen, message, null, 0);
    }

    public static void showLoading(Context context, String message, Drawable drawable) {
        showLoading(context, true, message, drawable, 0);
    }
    public static void showLoading(Context context, boolean isForceOpen, String message, Drawable drawable) {
        showLoading(context, isForceOpen, message, drawable, 0);
    }

    public void dismissLoading() {
        dismiss();
    }

    private void setDrawable(Drawable drawable) {
        ivIcon.setImageDrawable(drawable);
    }

    private void setMessage(String message) {
        tvMessage.setText(message);
    }

    private void startAnimation() {
        Drawable drawable = ivIcon.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

}
