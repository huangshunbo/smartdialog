package com.android.minlib.smartdialog;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.nfc.tech.NfcB;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: InputContent
 * @Description: 自定义弹框样式：标题+消息+副消息+输入框(显隐)+忘记密码
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/7/31 17:26
 */
public class InputContent extends FrameLayout {

    private TextView mDialogInputContentTitle;
    private View mDialogInputContentLine;
    private TextView mDialogInputContentMessage;
    private TextView mDialogInputContentSubMessage;
    private LinearLayout mDialogInputContentInput;
    private EditText mDialogInputContentEt;
    private ImageView mDialogInputContentStatu;
    private TextView mDialogInputContentFunc;
    private View mDialogInputContentBottomSpace;


    private Builder mBuilder;

    private static int[] DEFAULT_STYLEABLE =  R.styleable.lib_dialog_input_content;
    private static int DEFAULT_STYLE = R.style.lib_dialog_input_content;

    private InputContent(Builder builder) {
        super(builder.context);
        inflate(builder.context,R.layout.dialog_input_content,this);
        this.mBuilder = builder;
        initView();
        initAttrs();
    }



    private void initView() {
        mDialogInputContentTitle = (TextView) findViewById(R.id.dialog_input_content_title);
        mDialogInputContentLine = (View) findViewById(R.id.dialog_input_content_line);
        mDialogInputContentMessage = (TextView) findViewById(R.id.dialog_input_content_message);
        mDialogInputContentSubMessage = (TextView) findViewById(R.id.dialog_input_content_sub_message);
        mDialogInputContentInput = (LinearLayout) findViewById(R.id.dialog_input_content_input);
        mDialogInputContentEt = (EditText) findViewById(R.id.dialog_input_content_et);
        mDialogInputContentStatu = (ImageView) findViewById(R.id.dialog_input_content_statu);
        mDialogInputContentFunc = (TextView) findViewById(R.id.dialog_input_content_func);
        mDialogInputContentBottomSpace = findViewById(R.id.dialog_input_content_bottomspace);
    }

    private void initAttrs() {
        TypedArray typedArray = mBuilder.context.getTheme().obtainStyledAttributes(mBuilder.defaultStyle, DEFAULT_STYLEABLE);
        if(mBuilder.titleTextSize <= 0){
            mBuilder.titleTextSize = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_title_textsize,0);
        };
        if(mBuilder.titleTextColor  == 0){
            mBuilder.titleTextColor = (int) typedArray.getColor(R.styleable.lib_dialog_input_content_input_title_textcolor,0);
        };
        if(mBuilder.titleTextMarginTop <= 0){
            mBuilder.titleTextMarginTop = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_title_margin_top,0);
        };
        if(mBuilder.titleTextMarginBottom <= 0){
            mBuilder.titleTextMarginBottom = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_title_margin_bottom,0);
        };
        if(mBuilder.titleTextMarginLeft <= 0){
            mBuilder.titleTextMarginLeft = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_title_margin_left,0);
        };
        if(mBuilder.titleTextMarginRight <= 0){
            mBuilder.titleTextMarginRight = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_title_margin_right,0);
        };
        if(mBuilder.messageTextSize <= 0){
            mBuilder.messageTextSize = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_message_textsize,0);
        };
        if(mBuilder.messageTextColor == 0){
            mBuilder.messageTextColor = (int) typedArray.getColor(R.styleable.lib_dialog_input_content_input_message_textcolor,0);
        };
        if(mBuilder.messageTextMarginTop <= 0){
            mBuilder.messageTextMarginTop = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_message_margin_top,0);
        };
        if(mBuilder.messageTextMarginBottom <= 0){
            mBuilder.messageTextMarginBottom = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_message_margin_bottom,0);
        };
        if(mBuilder.messageTextMarginLeft <= 0){
            mBuilder.messageTextMarginLeft = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_message_margin_left,0);
        };
        if(mBuilder.messageTextMarginRight <= 0){
            mBuilder.messageTextMarginRight = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_message_margin_right,0);
        };
        if(mBuilder.subMessageTextSize <= 0){
            mBuilder.subMessageTextSize = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_sub_message_textsize,0);

        };
        if(mBuilder.subMessageTextColor == 0){
            mBuilder.subMessageTextColor = (int) typedArray.getColor(R.styleable.lib_dialog_input_content_input_sub_message_textcolor,0);

        };
        if(mBuilder.subMessageTextMarginTop <= 0){
            mBuilder.subMessageTextMarginTop = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_sub_message_margin_top,0);

        };
        if(mBuilder.subMessageTextMarginBottom <= 0){
            mBuilder.subMessageTextMarginBottom = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_sub_message_margin_bottom,0);
        };
        if(mBuilder.subMessageTextMarginLeft <= 0){
            mBuilder.subMessageTextMarginLeft = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_sub_message_margin_left,0);
        };
        if(mBuilder.subMessageTextMarginRight <= 0){
            mBuilder.subMessageTextMarginRight = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_sub_message_margin_right,0);
        };
        if(mBuilder.lineBackground == null){
            mBuilder.lineBackground = typedArray.getDrawable(R.styleable.lib_dialog_input_content_input_line_background);
        };
        if(mBuilder.lineMargin <= 0){
            mBuilder.lineMargin = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_line_margin,0);
        };
        if(mBuilder.inputMargin <= 0){
            mBuilder.inputMargin = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_input_margin,0);
        };
        if(mBuilder.inputBackground == null){
            mBuilder.inputBackground = typedArray.getDrawable(R.styleable.lib_dialog_input_content_input_input_background);
        };
        if(mBuilder.statusOpen == null){
            mBuilder.statusOpen = typedArray.getDrawable(R.styleable.lib_dialog_input_content_input_status_open);
        };
        if(mBuilder.statusClose == null){
            mBuilder.statusClose = typedArray.getDrawable(R.styleable.lib_dialog_input_content_input_status_close);
        };
        if(mBuilder.funcTextColor  <= 0){
            mBuilder.funcTextColor = typedArray.getColor(R.styleable.lib_dialog_input_content_input_func_text_color,0);
        };
        if(mBuilder.bottomSpace < 0){
            mBuilder.bottomSpace = (int) typedArray.getDimension(R.styleable.lib_dialog_input_content_input_bottom_space,0);
        }
        typedArray.recycle();

        if(TextUtils.isEmpty(mBuilder.title)){
            mDialogInputContentTitle.setVisibility(GONE);
            mDialogInputContentLine.setVisibility(GONE);
        }else {
            mDialogInputContentTitle.setText(mBuilder.title);
        };
        if(TextUtils.isEmpty(mBuilder.message)){
            mDialogInputContentMessage.setVisibility(GONE);
        }else {
            mDialogInputContentMessage.setText(mBuilder.message);
        }
        if(TextUtils.isEmpty(mBuilder.subMessage)){
            mDialogInputContentSubMessage.setVisibility(GONE);
        }else {
            mDialogInputContentSubMessage.setText(mBuilder.subMessage);
        }
        if(TextUtils.isEmpty(mBuilder.funcText)){
            mDialogInputContentFunc.setVisibility(GONE);
        }else {
            mDialogInputContentFunc.setText(mBuilder.funcText);
            if(mBuilder.onFuncClickListener != null){
                mDialogInputContentFunc.setOnClickListener(mBuilder.onFuncClickListener);
            }
        }


        if(mBuilder.titleTextSize > 0){
            mDialogInputContentTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,mBuilder.titleTextSize);
        };
        if(mBuilder.titleTextColor > 0){
            mDialogInputContentTitle.setTextColor(ContextCompat.getColor(getContext(),mBuilder.titleTextColor));
        }else if(mBuilder.titleTextColor < 0){
            mDialogInputContentTitle.setTextColor(mBuilder.titleTextColor);
        }
        mDialogInputContentTitle.setPadding(mBuilder.titleTextMarginLeft >0 ? mBuilder.titleTextMarginLeft : 0,mBuilder.titleTextMarginTop >0 ? mBuilder.titleTextMarginTop : 0,mBuilder.titleTextMarginRight >0 ? mBuilder.titleTextMarginRight : 0,mBuilder.titleTextMarginBottom >0 ? mBuilder.titleTextMarginBottom : 0);
        if(mBuilder.messageTextSize > 0){
            mDialogInputContentMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX,mBuilder.messageTextSize);
        }
        if(mBuilder.messageTextColor > 0){
            mDialogInputContentMessage.setTextColor(ContextCompat.getColor(getContext(),mBuilder.messageTextColor));
        }else if(mBuilder.messageTextColor < 0){
            mDialogInputContentMessage.setTextColor(mBuilder.messageTextColor);
        }
        mDialogInputContentMessage.setPadding(mBuilder.messageTextMarginLeft >0 ? mBuilder.messageTextMarginLeft : 0,mBuilder.messageTextMarginTop >0 ? mBuilder.messageTextMarginTop : 0,mBuilder.messageTextMarginRight >0 ? mBuilder.messageTextMarginRight : 0,mBuilder.messageTextMarginBottom >0 ? mBuilder.messageTextMarginBottom : 0);
        if(mBuilder.subMessageTextSize > 0){
            mDialogInputContentSubMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX,mBuilder.subMessageTextSize);
        }
        if(mBuilder.subMessageTextColor > 0){
            mDialogInputContentSubMessage.setTextColor(ContextCompat.getColor(getContext(),mBuilder.subMessageTextColor));
        }else if(mBuilder.subMessageTextColor < 0){
            mDialogInputContentMessage.setTextColor(mBuilder.subMessageTextColor);
        }
        mDialogInputContentSubMessage.setPadding(mBuilder.subMessageTextMarginLeft >0 ? mBuilder.subMessageTextMarginLeft : 0,mBuilder.subMessageTextMarginTop >0 ? mBuilder.subMessageTextMarginTop : 0,mBuilder.subMessageTextMarginRight >0 ? mBuilder.subMessageTextMarginRight : 0,mBuilder.subMessageTextMarginBottom >0 ? mBuilder.subMessageTextMarginBottom : 0);
        if(mBuilder.lineBackground != null){
            mDialogInputContentLine.setBackground(mBuilder.lineBackground);
        }
        if(mBuilder.lineMargin > 0){
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mDialogInputContentLine.getLayoutParams();
            lp.setMargins(mBuilder.lineMargin,0,mBuilder.lineMargin,0);
            mDialogInputContentLine.setLayoutParams(lp);
        }
        if(mBuilder.inputMargin > 0){
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mDialogInputContentInput.getLayoutParams();
            lp.setMargins(mBuilder.inputMargin,0,mBuilder.inputMargin,0);
            mDialogInputContentInput.setLayoutParams(lp);
            mDialogInputContentFunc.setPadding(0,0,mBuilder.inputMargin,0);
        }
        if(mBuilder.bottomSpace > 0){
            mDialogInputContentBottomSpace.setVisibility(VISIBLE);
            mDialogInputContentBottomSpace.setPadding(0,mBuilder.bottomSpace,0,0);
        }else {
            mDialogInputContentBottomSpace.setVisibility(GONE);
        }
        if(mBuilder.inputBackground != null){
            mDialogInputContentInput.setBackground(mBuilder.inputBackground);
        }
        if(mBuilder.statusOpen == null || mBuilder.statusClose == null){
            mDialogInputContentStatu.setVisibility(GONE);
        }else {
            mDialogInputContentStatu.setImageDrawable(mBuilder.statusClose);
            mDialogInputContentStatu.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mDialogInputContentStatu.getDrawable().equals(mBuilder.statusOpen)){
                        mDialogInputContentStatu.setImageDrawable(mBuilder.statusClose);
                        if(mBuilder.onStatuListener != null){
                            mBuilder.onStatuListener.onStatuChange(mDialogInputContentEt,false);
                        }
                    }else{
                        mDialogInputContentStatu.setImageDrawable(mBuilder.statusOpen);
                        if(mBuilder.onStatuListener != null){
                            mBuilder.onStatuListener.onStatuChange(mDialogInputContentEt,true);
                        }
                    }
                }
            });
        }
        if(!TextUtils.isEmpty(mBuilder.inputHint)){
            mDialogInputContentEt.setHint(mBuilder.inputHint);
        }
        if(mBuilder.inputType != 0){
            mDialogInputContentEt.setInputType(mBuilder.inputType);
        }
        if(mBuilder.inputTransformationMethod != null){
            mDialogInputContentEt.setTransformationMethod(mBuilder.inputTransformationMethod);
        }
        if(mBuilder.funcTextColor > 0){
            mDialogInputContentFunc.setTextColor(ContextCompat.getColor(getContext(),mBuilder.funcTextColor));
        }else if(mBuilder.funcTextColor < 0){
            mDialogInputContentFunc.setTextColor(mBuilder.funcTextColor);
        }

    }

    public TextView getmDialogInputContentTitle() {
        return mDialogInputContentTitle;
    }

    public View getmDialogInputContentLine() {
        return mDialogInputContentLine;
    }

    public TextView getmDialogInputContentMessage() {
        return mDialogInputContentMessage;
    }

    public TextView getmDialogInputContentSubMessage() {
        return mDialogInputContentSubMessage;
    }

    public LinearLayout getmDialogInputContentInput() {
        return mDialogInputContentInput;
    }

    public EditText getmDialogInputContentEt() {
        return mDialogInputContentEt;
    }

    public ImageView getmDialogInputContentStatu() {
        return mDialogInputContentStatu;
    }

    public TextView getmDialogInputContentFunc() {
        return mDialogInputContentFunc;
    }

    public static final class Builder {
        private int defaultStyle;
        private String title;
        private int titleTextSize;
        private int titleTextColor;
        private int titleTextMarginTop;
        private int titleTextMarginBottom;
        private int titleTextMarginLeft;
        private int titleTextMarginRight;
        private String message;
        private int messageTextSize;
        private int messageTextColor;
        private int messageTextMarginTop;
        private int messageTextMarginBottom;
        private int messageTextMarginLeft;
        private int messageTextMarginRight;
        private String subMessage;
        private int subMessageTextSize;
        private int subMessageTextColor;
        private int subMessageTextMarginTop;
        private int subMessageTextMarginBottom;
        private int subMessageTextMarginLeft;
        private int subMessageTextMarginRight;
        private Drawable lineBackground;
        private int lineMargin;
        private Context context;
        private int inputMargin;
        private Drawable inputBackground;
        private Drawable statusOpen;
        private Drawable statusClose;
        private String inputHint;
        private int inputType;
        private TransformationMethod inputTransformationMethod;
        private String funcText;
        private int funcTextColor;
        private int bottomSpace;

        private OnStatuListener onStatuListener;
        private OnClickListener onFuncClickListener;

        public Builder(Context context) {
            this.context = context;
            defaultStyle = DEFAULT_STYLE;
        }

        public Builder setOnStatuListener(OnStatuListener onStatuListener) {
            this.onStatuListener = onStatuListener;
            return this;
        }

        public Builder setOnFuncClickListener(OnClickListener onFuncClickListener) {
            this.onFuncClickListener = onFuncClickListener;
            return this;
        }

        public Builder defaultStyle(int val) {
            defaultStyle = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder titleTextSize(int val) {
            titleTextSize = val;
            return this;
        }

        public Builder titleTextColor(int val) {
            titleTextColor = val;
            return this;
        }

        public Builder titleTextMarginTop(int val) {
            titleTextMarginTop = val;
            return this;
        }

        public Builder titleTextMarginBottom(int val) {
            titleTextMarginBottom = val;
            return this;
        }

        public Builder titleTextMarginLeft(int val) {
            titleTextMarginLeft = val;
            return this;
        }

        public Builder titleTextMarginRight(int val) {
            titleTextMarginRight = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder messageTextSize(int val) {
            messageTextSize = val;
            return this;
        }

        public Builder messageTextColor(int val) {
            messageTextColor = val;
            return this;
        }

        public Builder messageTextMarginTop(int val) {
            messageTextMarginTop = val;
            return this;
        }

        public Builder messageTextMarginBottom(int val) {
            messageTextMarginBottom = val;
            return this;
        }

        public Builder messageTextMarginLeft(int val) {
            messageTextMarginLeft = val;
            return this;
        }

        public Builder messageTextMarginRight(int val) {
            messageTextMarginRight = val;
            return this;
        }

        public Builder subMessage(String val) {
            subMessage = val;
            return this;
        }

        public Builder subMessageTextSize(int val) {
            subMessageTextSize = val;
            return this;
        }

        public Builder subMessageTextColor(int val) {
            subMessageTextColor = val;
            return this;
        }

        public Builder subMessageTextMarginTop(int val) {
            subMessageTextMarginTop = val;
            return this;
        }

        public Builder subMessageTextMarginBottom(int val) {
            subMessageTextMarginBottom = val;
            return this;
        }

        public Builder subMessageTextMarginLeft(int val) {
            subMessageTextMarginLeft = val;
            return this;
        }

        public Builder subMessageTextMarginRight(int val) {
            subMessageTextMarginRight = val;
            return this;
        }

        public Builder lineBackground(Drawable val) {
            lineBackground = val;
            return this;
        }

        public Builder lineMargin(int val) {
            lineMargin = val;
            return this;
        }

        public Builder inputMargin(int val) {
            inputMargin = val;
            return this;
        }

        public Builder inputBackground(Drawable val) {
            inputBackground = val;
            return this;
        }

        public Builder statusOpen(Drawable val) {
            statusOpen = val;
            return this;
        }

        public Builder statusClose(Drawable val) {
            statusClose = val;
            return this;
        }

        public Builder inputHint(String val) {
            inputHint = val;
            return this;
        }

        public Builder inputType(int val) {
            inputType = val;
            return this;
        }

        public Builder setInputTransformationMethod(TransformationMethod inputTransformationMethod) {
            this.inputTransformationMethod = inputTransformationMethod;
            return this;
        }

        public Builder funcText(String val){
            funcText = val;
            return this;
        }

        public Builder funcTextColor(int val) {
            funcTextColor = val;
            return this;
        }

        public Builder setBottomSpace(int bottomSpace) {
            this.bottomSpace = bottomSpace;
            return this;
        }

        public InputContent build() {
            return new InputContent(this);
        }
    }

    public interface OnStatuListener
    {
        void onStatuChange(EditText et,boolean isOpen);
    }
}
