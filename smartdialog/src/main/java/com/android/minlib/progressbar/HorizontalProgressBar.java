package com.android.minlib.progressbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class HorizontalProgressBar extends ProgressBarStyle {


    private Bitmap foreBitmap, secondForeBitmap, backBitmap;
    private Paint mPaint;

    public HorizontalProgressBar(Context context) {
        super(context);
    }

    public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (backBitmap == null || foreBitmap == null) {
            return;
        }
        initBitmap();
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(backBitmap, paddingLeft, paddingTop, mPaint);
        double rate;
        if (foreground != null && progres > 0) {
            rate = (double) progres / (double) total;
            canvas.drawBitmap(drawableToBitmap(foreground, rate), paddingLeft, paddingTop, mPaint);
        }
        if (secondForeground != null && secondProgress > 0) {
            rate = (double) secondProgress / (double) secondTotal;
            canvas.drawBitmap(drawableToBitmap(secondForeground, rate), paddingLeft, paddingTop, mPaint);
        }
    }

    private void initBitmap() {
        if (foreground != null && foreBitmap == null) {
            foreBitmap = drawableToBitmap(foreground);
        }
        if (secondForeground != null && secondForeBitmap == null) {
            secondForeBitmap = drawableToBitmap(secondForeground);
        }
        if (background != null && backBitmap == null) {
            backBitmap = drawableToBitmap(background);
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        return drawableToBitmap(drawable, 1);
    }

    private Bitmap drawableToBitmap(Drawable drawable, double rateWidth) {
        // 取 drawable 的长宽
        int w = (int) ((width - paddingLeft - paddingRight) * rateWidth);
        int h = heigh - paddingTop - paddingBottom;
        // 取 drawable 的颜色格式
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }
}
