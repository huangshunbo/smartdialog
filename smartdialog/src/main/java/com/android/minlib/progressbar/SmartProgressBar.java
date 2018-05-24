package com.android.minlib.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.android.minlib.smartdialog.R;

public class SmartProgressBar extends FrameLayout {

    private ProgressBarStyle progressBarStyle;
    private Drawable foreground, secondForeground, background;
    private Context mContext;
    private int circle_startangle, circle_width;

    private int style = 0;

    public SmartProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public SmartProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttr(attrs);
        initView();
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs,
                R.styleable.SmartProgressBar);
        style = a.getInt(R.styleable.SmartProgressBar_style, 0);
        background = a.getDrawable(R.styleable.SmartProgressBar_background);
        foreground = a.getDrawable(R.styleable.SmartProgressBar_foreground);
        secondForeground = a.getDrawable(R.styleable.SmartProgressBar_second_foreground);
        circle_startangle = a.getInteger(R.styleable.SmartProgressBar_circle_startangle, -90);
        circle_width = (int) a.getDimension(R.styleable.SmartProgressBar_circle_width, 20);
    }

    private void initView() {
        setStyle(style);
        setForeAndBackDrawable(foreground, secondForeground, background);
    }

    public void setStyle(int style) {
        if (style == 1) {
            progressBarStyle = new HorizontalProgressBar(mContext);
        } else if (style == 2) {
            progressBarStyle = new CircleProgressBar(mContext);
            ((CircleProgressBar) progressBarStyle).setStartAngle(circle_startangle);
            ((CircleProgressBar) progressBarStyle).setPaintWidth(circle_width);
        }
        removeAllViews();
        addView((View) progressBarStyle, new LayoutParams(-1, -1));
    }

    public void setStyle(ProgressBarStyle style) {
        progressBarStyle = style;
        removeAllViews();
        addView((View) progressBarStyle, new LayoutParams(-1, -1));
    }

    public void setForeAndBackDrawable(Drawable foreground, Drawable secondForeground, Drawable background) {
        if (progressBarStyle == null) {
            throw new IllegalArgumentException("setStyle first please");
        }
        progressBarStyle.setForeground(foreground);
        progressBarStyle.setSecondForeground(secondForeground);
        progressBarStyle.setBackground(background);
    }

    public void setProgress(int progress) {
        if (progress >= 0) {
            setProgress(progress, 100);
        }
    }

    public void setProgress(int progress, int total) {
        if (progressBarStyle == null) {
            throw new IllegalArgumentException("setStyle first please");
        }
        if (progress >= 0 && total >= progress) {
            progressBarStyle.setProgress(progress, total);
        }
    }

    public void setSecondProgress(int progress) {
        if (progress >= 0) {
            setSecondProgress(progress, 100);
        }
    }

    public void setSecondProgress(int progress, int total) {
        if (progressBarStyle == null) {
            throw new IllegalArgumentException("setStyle first please");
        }
        if (progress >= 0 && total >= progress) {
            progressBarStyle.setSecondProgress(progress, total);
        }
    }

    public void setProgress(int progress, int secondProgress, int total) {
        setProgress(progress, total);
        setSecondProgress(secondProgress, total);
    }
}
