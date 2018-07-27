package com.android.minlib.samplesimplewidget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.android.minlib.smartdialog.SimpleTextContent;
import com.android.minlib.smartdialog.SmartDialog;

public class SmartDialogFactory {

    public static SmartDialog createEmptyDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .build();
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setButtonAutoDismiss(true)
                .setContentView(content)
                .setButtonRight("右边")
                .build();
        return smartDialog;
    }

    public static SmartDialog createSimpleDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setTitle("标题")
                .messageTxtColor(R.color.color_orange)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonRight("submit")
                .setContentView(content)
                .build();
        return smartDialog;
    }

    public static SmartDialog createThemeDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setTitle("标题")
                .titleTextColor(R.color.color_orange)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonRight("submit")
                .setContentView(content)
                .build();
        return smartDialog;
    }

    public static SmartDialog createJustContentDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setTitle("标题")
                .titleTextColor(R.color.color_orange)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonRight("submit")
                .setContentView(content)
                .build();
        return smartDialog;
    }
}
