package com.android.minlib.samplesimplewidget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.android.minlib.smartdialog.SimpleTextContent;
import com.android.minlib.smartdialog.SmartDialog;

public class SmartDialogFactory {

    public static SmartDialog createEmptyDialog(Context context){
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setButtonAutoDismiss(true)
                .setButtonRight("右边")
                .build();
        return smartDialog;
    }

    public static SmartDialog createSimpleDialog(Context context){
        SimpleTextContent content = new SimpleTextContent("标题","这并不是一个简短的副标题",context);
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setButtonAutoDismiss(true)
                .setButtonLeft("取消")
                .setButtonRight("确认")
                .setContent(content)
                .build();
        return smartDialog;
    }

    public static SmartDialog createThemeDialog(Context context){
        SimpleTextContent content = new SimpleTextContent("标题","这并不是一个简短的副标题",context);
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setButtonAutoDismiss(true)
                .setButtonLeft("左边")
                .setButtonMiddle("中间")
                .setButtonRight("右边")
                .setContent(content)
                .setTheme(R.style.dialog_theme)
                .build();
        return smartDialog;
    }
}
