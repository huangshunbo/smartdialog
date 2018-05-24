package com.android.minlib.progressbar;

import android.graphics.drawable.Drawable;

public interface ISmartProgressBarStyle {
    public void setProgress(int progress,int total);
    public void setSecondProgress(int progress,int total);
    public void setForeground(Drawable drawable);
    public void setSecondForeground(Drawable drawable);
    public void setBackground(Drawable drawable);
}
