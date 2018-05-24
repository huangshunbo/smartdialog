package com.android.minlib.samplesimplewidget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.android.minlib.smartdialog.SimpleTextContent;
import com.android.minlib.smartdialog.SmartDialog;

public class SmartDialogFactory {

    public static SmartDialog createDialog(Context context){
        SimpleTextContent simpleTextContent = new SimpleTextContent("标题","这是一句提示语！",context);
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setLineColor(ContextCompat.getColor(context,R.color.color_orange))
                .setContent(simpleTextContent)
                .setBtnCancel("cancel")
                .setBtnCancelBackground(ContextCompat.getColor(context,R.color.color_shadow))
                .setBtnCancelTextColor(ContextCompat.getColor(context,R.color.color_gray))
                .setBtnCancelTextSize(12)
                .setBtnCancelListener(new SmartDialog.ClickListener() {
                    @Override
                    public void onClick(SmartDialog dialog, View view) {

                    }
                })
                .setBtnCustom("custom")
                .setBtnCustomBackground(ContextCompat.getColor(context,R.color.colorAccent))
                .setBtnCustomTextColor(ContextCompat.getColor(context,R.color.color_black))
                .setBtnCustomTextSize(22)
                .setBtnCustomListener(new SmartDialog.ClickListener() {
                    @Override
                    public void onClick(SmartDialog dialog, View view) {

                    }
                })
                .setBtnSubmit("submit")
                .setBtnSubmitBackground(ContextCompat.getColor(context,R.color.color_orange))
                .setBtnSubmitTextColor(ContextCompat.getColor(context,R.color.color_white))
                .setBtnSubmitTextSize(12)
                .setBtnSubmitListener(new SmartDialog.ClickListener() {
                    @Override
                    public void onClick(SmartDialog dialog, View view) {

                    }
                })
                .build();
            return smartDialog;

    }
}
