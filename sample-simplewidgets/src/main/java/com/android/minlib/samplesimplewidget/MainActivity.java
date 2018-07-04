package com.android.minlib.samplesimplewidget;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.minlib.smartdialog.SmartDialog;
import com.android.minlib.smartdialog.SmartToast;
import com.android.minlib.smartdialog.ToastUtils;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public static Application application;

    ListView mListView;
    private static final String[] strs =
            {
                    "showEmptyDialog","showSimpleDialog","showThemeDialog","Toast","ProgressBar"

            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = getApplication();
        mListView = new ListView(this);
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
        mListView.setOnItemClickListener(this);
        setContentView(mListView);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0:
                SmartDialog smartDialog1 = SmartDialogFactory.createEmptyDialog(this);
                smartDialog1.show();
                break;
            case 1:
                SmartDialog smartDialog2 = SmartDialogFactory.createSimpleDialog(this);
                smartDialog2.show();
                break;
            case 2:
                SmartDialog smartDialog3 = SmartDialogFactory.createThemeDialog(this);
                smartDialog3.show();
                break;
            case 3:
                showToast();
                break;
            case 4:
                startActivity(new Intent(this,ProgressBarActivity.class));
                break;

        }
    }

    int status = 0;
    private void showToast(){
        ToastUtils.showBottomToast(this,"Hello");
        if(status == 0){
            status = 1;
            ToastUtils.showTopToast(this,"Hello");
        }else if(status == 1){
            status = 2;
            ToastUtils.showCenterToast(this,"Hello");
        }else if(status == 2){
            status = 0;
            ToastUtils.showBottomToast(this,"Hello");
        }
    }

}
