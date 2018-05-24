package com.android.minlib.progressbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class ProgressBarStyle extends View implements ISmartProgressBarStyle {

    protected Drawable foreground, secondForeground, background;
    protected int progres, secondProgress, total, secondTotal;
    protected int width, heigh;
    protected int paddingLeft, paddingRight, paddingTop, paddingBottom;

    public ProgressBarStyle(Context context) {
        this(context,null);
    }
    public ProgressBarStyle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public ProgressBarStyle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProgressBarStyle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        heigh = getMeasuredHeight();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
    }

    @Override
    public void setForeground(Drawable drawable) {
        foreground = drawable;
    }

    @Override
    public void setSecondForeground(Drawable drawable) {
        secondForeground = drawable;
    }

    @Override
    public void setBackground(Drawable drawable) {
        background = drawable;
    }

    @Override
    public void setProgress(int progress, int total) {
        if (progress < 0) {
            progress = 0;
        }
        if (total < 0 || total < progress) {
            total = progress;
        }
        if (progress > total) {
            progress = total;
        }
        this.progres = progress;
        this.total = total;
        invalidate();
    }

    @Override
    public void setSecondProgress(int progress, int total) {
        if (progress < 0) {
            progress = 0;
        }
        if (total <= 0 || total < progress) {
            total = progress;
        }
        if (progress > total) {
            progress = total;
        }
        this.secondProgress = progress;
        this.secondTotal = total;
        invalidate();
    }

    public abstract void init(AttributeSet attrs, int defStyleAttr,int defStyleRes);

}
