package com.android.minlib.samplesimplewidget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.minlib.progressbar.SmartProgressBar;

public class ProgressBarDialog extends FrameLayout {

    private SmartProgressBar mViewProgressDialogProgress;
    private TextView mViewProgressDialogTip;
    private int progress = 0;
    private Thread thread;

    public ProgressBarDialog(@NonNull Context context) {
        super(context);
        inflate(context,R.layout.view_progress_dialog,this);
        mViewProgressDialogProgress = (SmartProgressBar) findViewById(R.id.view_progress_dialog_progress);
        mViewProgressDialogTip = (TextView) findViewById(R.id.view_progress_dialog_tip);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(200);
                        progress += 10;
                        mViewProgressDialogProgress.post(new Runnable() {
                            @Override
                            public void run() {
                                mViewProgressDialogProgress.setProgress(progress, (int) (progress*0.8),100);
                            }
                        });
                        if(progress > 100){
                            progress = 0;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
        mViewProgressDialogTip.setText("加载中...");
    }

    public void start(){
        mViewProgressDialogProgress.setProgress(progress, (int) (progress*0.8),100);
        thread.start();
    }

    public void stop(){
        if(!thread.isInterrupted()){
            thread.interrupt();
        }
    }
}
