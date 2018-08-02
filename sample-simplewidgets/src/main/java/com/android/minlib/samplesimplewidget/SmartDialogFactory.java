package com.android.minlib.samplesimplewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.minlib.progressbar.ProgressBarStyle;
import com.android.minlib.smartdialog.EmptyDialog;
import com.android.minlib.smartdialog.InputContent;
import com.android.minlib.smartdialog.SimpleTextContent;
import com.android.minlib.smartdialog.SmartDialog;

public class SmartDialogFactory {

    public static SmartDialog createMessageDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .build();
        SmartDialog smartDialog = new SmartDialog.Builder(context)
                .setButtonAutoDismiss(true)
                .setContentView(content)
                .setButtonRight("确认")
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
                .setButtonAutoDismiss(true)
                .setButtonLeft("取消")
                .setButtonRight("确认")

                .setContentView(content)
                .build();


        return smartDialog;
    }

    public static SmartDialog createThemeDialog(Context context){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
                .setLineBackground(new ColorDrawable(Color.BLUE))
                .setTitle("标题")
                .defaultStyle(R.style.dialog_theme)
                .titleTextColor(R.color.color_orange)
                .titleTextSize(40)
                .titleTextMarginTop(40)
                .titleTextMarginBottom(40)
                .titleTextMarginLeft(20)
                .titleTextMarginRight(20)
                .setMessage("这是一句一句一句话这是一句一句一句话这是一句一句一句话")
                .messageTxtColor(R.color.colorPrimary)
                .messageTextSize(80)
                .messageTextMarginTop(20)
                .messageTextMarginBottom(20)
                .messageTextMarginLeft(40)
                .messageTextMarginRight(20)
                .setLineMargin(20)
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonAutoDismiss(true) //点击按钮自动将Dialog dismiss掉
                .setTheme(R.style.dialog_theme)
                .setButtonLeft("左边")
                .buttonLeftTextColor(Color.WHITE)
                .buttonLeftBackground(new ColorDrawable(Color.RED))
                .setButtonMiddle("中间")
                .buttonMiddleTextColor(R.color.colorPrimary)
                .buttonMiddleBackground(ContextCompat.getDrawable(context,R.drawable.line_left_margin))
                .setButtonRight("右边")
                .buttonRightTextColor(Color.RED)
                .buttonRightBackground(new ColorDrawable(Color.WHITE))
                .setLeftOnclickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setMiddleOnclickListener(null)
                .setRightOnclickListener(null)
                .setContentView(content) // 设置主体内容View
                .build();


        return smartDialog;
    }

    public static SmartDialog createInputDialog(final Context context){
        InputContent content = new InputContent.Builder(context)
                .title("标题")
                .titleTextColor(Color.RED)
                .titleTextSize(40)
                .message("这是一条消息")
                .messageTextColor(Color.BLUE)
                .messageTextSize(40)
                .messageTextMarginLeft(20)
                .messageTextMarginRight(20)
                .messageTextMarginTop(40)
                .messageTextMarginBottom(40)
                .subMessage("这个真的真的真的真的真的真的只是一条一条一条消息")
                .subMessageTextSize(80)
                .subMessageTextColor(Color.GRAY)
                .subMessageTextMarginLeft(20)
                .subMessageTextMarginRight(20)
                .messageTextMarginTop(40)
                .messageTextMarginBottom(40)
                .inputHint("请输入...")
                .statusOpen(ContextCompat.getDrawable(context,R.drawable.ic_lock_open_black_24dp))
                .statusClose(ContextCompat.getDrawable(context,R.drawable.ic_lock_outline_black_24dp))
                .inputBackground(ContextCompat.getDrawable(context,R.drawable.input_outline_background))
                .inputMargin(50)
                .inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                .setInputTransformationMethod(PasswordTransformationMethod.getInstance())
                .funcText("忘记吧")
                .setOnFuncClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setOnStatuListener(new InputContent.OnStatuListener() {
                    @Override
                    public void onStatuChange(EditText et, boolean isOpen) {
                        if(isOpen){
                            et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            et.setSelection(et.getText().toString().length());
                        }else {
                            et.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            et.setSelection(et.getText().toString().length());
                        }
                    }
                })
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonAutoDismiss(true)
                .setButtonLeft("左边")
                .buttonLeftTextColor(Color.RED)
                .setButtonMiddle("中间")
                .setButtonRight("右边")
                .setContentView(content)
                .build();
        return smartDialog;
    }

    public static SmartDialog createSimpleInputDialog(final Context context){
        InputContent content = new InputContent.Builder(context)
                .title("标题")
                .titleTextColor(Color.RED)
                .titleTextSize(40)
                .message("一个简单的消息")
                .messageTextSize(40)
                .messageTextColor(Color.RED)
                .subMessage("这个真的真的真的真的真的真的只是一条一条一条消息")
                .subMessageTextSize(80)
                .subMessageTextColor(Color.GRAY)
                .subMessageTextMarginLeft(20)
                .subMessageTextMarginRight(20)
                .messageTextMarginTop(40)
                .messageTextMarginBottom(40)
                .setOnStatuListener(null)
                .setOnFuncClickListener(null)
                .setBottomSpace(30)
                .inputHint("请输入...")
                .inputBackground(ContextCompat.getDrawable(context,R.drawable.input_outline_background))
                .inputMargin(50)
                .inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                .setInputTransformationMethod(PasswordTransformationMethod.getInstance())
                .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
                .setButtonAutoDismiss(true)
                .setButtonLeft("左边")
                .buttonLeftTextColor(Color.RED)
                .setButtonMiddle("中间")
                .setButtonRight("右边")
                .setContentView(content)
                .build();

        return smartDialog;
    }

    public static EmptyDialog createProgressDialog(Context context){
        ProgressBarDialog progress = new ProgressBarDialog(context);
        EmptyDialog dialog = new EmptyDialog(context);
        dialog.addContentView(progress,new ViewGroup.LayoutParams(-1,-1));
        dialog.show();
        progress.start();
        return dialog;
    }
}
