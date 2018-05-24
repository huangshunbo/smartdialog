package com.android.minlib.samplesimplewidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.minlib.progressbar.SmartProgressBar;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener{

    SmartProgressBar smartProgressBar;
    Button btDel,btAdd;

    int progress = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        smartProgressBar = findViewById(R.id.progressbar);
        btDel = findViewById(R.id.del);
        btAdd = findViewById(R.id.add);

        btDel.setOnClickListener(this);
        btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.del){
            progress --;
            smartProgressBar.setProgress(progress, (int) (progress*0.8),100);
        }else if(id == R.id.add){
            progress ++;
            smartProgressBar.setProgress(progress, (int) (progress*0.8),100);
        }
    }
}
