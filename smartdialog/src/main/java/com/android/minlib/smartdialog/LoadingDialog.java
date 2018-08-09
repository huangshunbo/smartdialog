package com.android.minlib.smartdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoadingDialog extends EmptyDialog {

    private LinearLayout llContent;
    private ImageView ivIcon;
    private TextView tvMessage;

    public LoadingDialog(Context context) {
        this(context, R.style.lib_dialog_loading_theme);

    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        setContentView(R.layout.dialog_loading);
        llContent = findViewById(R.id.dialog_loading_content);
        ivIcon = findViewById(R.id.dialog_loading_icon);
        tvMessage = findViewById(R.id.dialog_loading_message);
        setForceOpen(true);
    }

    @SuppressLint("NewApi")
    public void showLoading() {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        llContent.measure(widthMeasureSpec, heightMeasureSpec);

        setWidthScale((float) llContent.getMeasuredWidth() / (float) width);
        show();
        Drawable drawable = ivIcon.getDrawable();
        if(drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

    }

    public void showLoading(String message) {
        tvMessage.setText(message);
        showLoading();
    }

    public void dissLoading() {
        dismiss();
    }

    public ImageView getIvIcon() {
        return ivIcon;
    }
}
