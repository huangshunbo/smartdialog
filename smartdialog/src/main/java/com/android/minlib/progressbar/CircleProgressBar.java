package com.android.minlib.progressbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CircleProgressBar extends ProgressBarStyle{

    private int paintWidth = 20;
    private int startAngle = -90;
    private Paint mPaint;

    public CircleProgressBar(@NonNull Context context) {
        super(context);
    }

    public CircleProgressBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(paintWidth);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path;
        Shader shader;
        canvas.drawColor(Color.TRANSPARENT);
        if (background != null) {
            path = buildCirclePath(1);
            shader = new BitmapShader(drawableToBitmap(background), Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
            mPaint.setShader(shader);
            canvas.drawPath(path, mPaint);
        }
        if (foreground != null && progres > 0) {
            double rate;
            if (foreground != null && progres > 0) {
                rate = (double) progres / (double) total;
                path = buildCirclePath(rate);
                shader = new BitmapShader(drawableToBitmap(foreground), Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
                mPaint.setShader(shader);
                canvas.drawPath(path, mPaint);
            }
        }
        if (secondForeground != null && secondProgress > 0) {
            double rate;
            if (foreground != null && progres > 0) {
                rate = (double) secondProgress / (double) secondTotal;
                path = buildCirclePath(rate);
                shader = new BitmapShader(drawableToBitmap(secondForeground), Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
                mPaint.setShader(shader);
                canvas.drawPath(path, mPaint);
            }
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int w = (int) (width - paddingLeft - paddingRight);
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

    private Path buildCirclePath(double rate) {
        Path path = new Path();
        int w = width - paddingLeft - paddingRight -paintWidth*2;
        int h = heigh - paddingTop - paddingBottom - paintWidth*2;
        int radius = Math.min(w, h);
        int left = w > h ? paddingLeft + paintWidth + (w - h) / 2 : paddingLeft + paintWidth;
        int top = w > h ? paddingTop + paintWidth : paddingTop + paintWidth + (h - w) / 2;
        float sweepAngle = (float) (360 * rate);
        path.addArc(new RectF(left, top, left+radius, top+radius), startAngle, sweepAngle);
        return path;
    }

    public void setStartAngle(int startAngle){
        this.startAngle = startAngle;
    }
    public void setPaintWidth(int paintWidth){
        this.paintWidth = paintWidth;
        if(mPaint != null){
            mPaint.setStrokeWidth(paintWidth);
        }
    }
}
