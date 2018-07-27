package com.android.minlib.smartdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author: huangshunbo
 * @Filename: SimpleTextContent
 * @Description: 自定义弹框内容样式：主标题+副标题
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2018/3/27 17:05
 */
public class SimpleTextContent extends LinearLayout{

    TextView tvTitle;
    TextView tvSubTitle;
    View mLine;

    private static int[] DEFAULT_STYLEABLE =  R.styleable.lib_dialog_simpletext_content;
    private static int DEFAULT_STYLE = R.style.lib_dialog_simpletext_content;
    Builder mBuilder;

    @SuppressLint("ResourceType")
    private SimpleTextContent(Builder builder) {
        super(builder.context);
        mBuilder = builder;
        initView();
        initAttrs();
    }

    public SimpleTextContent(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
        inflate(mBuilder.context, R.layout.dialog_simple_text,this);
        tvTitle = findViewById(R.id.lib_dialog_simple_txt_title);
        tvSubTitle = findViewById(R.id.lib_dialog_simple_txt_sub_title);
        mLine = findViewById(R.id.lib_dialog_simple_line);
    }

    private void initAttrs() {
        TypedArray typedArray = mBuilder.context.getTheme().obtainStyledAttributes(mBuilder.defaultStyle, DEFAULT_STYLEABLE);
        if(mBuilder.titleTextSize <= 0){
            mBuilder.titleTextSize = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_title_textsize,0);
        }
        if(mBuilder.titleTextColor <= 0){
            mBuilder.titleTextColor = typedArray.getColor(R.styleable.lib_dialog_simpletext_content_title_textcolor,0);
        }
        if(mBuilder.titleTextMarginTop <= 0){
            mBuilder.titleTextMarginTop = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_title_margin_top,0);
        }
        if(mBuilder.titleTextMarginBottom <= 0){
            mBuilder.titleTextMarginBottom = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_title_margin_bottom,0);
        }
        if(mBuilder.titleTextMarginLeft <= 0){
            mBuilder.titleTextMarginLeft = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_title_margin_left,0);
        }
        if(mBuilder.titleTextMarginRight <= 0){
            mBuilder.titleTextMarginRight = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_title_margin_right,0);
        }
        if(mBuilder.messageTextSize <= 0){
            mBuilder.messageTextSize = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_message_textsize,0);
        }
        if(mBuilder.messageTextColor <= 0){
            mBuilder.messageTextColor = typedArray.getColor(R.styleable.lib_dialog_simpletext_content_message_textcolor,0);
        }
        if(mBuilder.messageTextMarginTop <= 0){
            mBuilder.messageTextMarginTop = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_message_margin_top,0);
        }
        if(mBuilder.messageTextMarginBottom <= 0){
            mBuilder.messageTextMarginBottom = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_message_margin_bottom,0);
        }
        if(mBuilder.messageTextMarginLeft <= 0){
            mBuilder.messageTextMarginLeft = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_message_margin_left,0);
        }
        if(mBuilder.messageTextMarginRight <= 0){
            mBuilder.messageTextMarginRight = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_message_margin_right,0);
        }
        if(mBuilder.lineBackground == null){
            mBuilder.lineBackground = typedArray.getDrawable(R.styleable.lib_dialog_simpletext_content_line_background);
        }
        if(mBuilder.lineMargin <= 0){
            mBuilder.lineMargin = (int) typedArray.getDimension(R.styleable.lib_dialog_simpletext_content_line_margin,0);
        }
        typedArray.recycle();

        if(TextUtils.isEmpty(mBuilder.title)){
            mLine.setVisibility(GONE);
            tvTitle.setVisibility(GONE);
        }
        if(TextUtils.isEmpty(mBuilder.message)){
            mLine.setVisibility(GONE);
            tvSubTitle.setVisibility(GONE);
        }
        if(!TextUtils.isEmpty(mBuilder.title)){
            tvTitle.setText(mBuilder.title);
        }
        if(!TextUtils.isEmpty(mBuilder.message)){
            tvSubTitle.setText(mBuilder.message);
        }

        if(mBuilder.titleTextSize > 0){
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,mBuilder.titleTextSize);
        }
        if(mBuilder.titleTextColor >= 0){
            tvTitle.setTextColor(ContextCompat.getColor(getContext(),mBuilder.titleTextColor));
        }
        tvTitle.setPadding(mBuilder.titleTextMarginLeft>0 ? mBuilder.titleTextMarginLeft : 0,mBuilder.messageTextMarginTop>0 ? mBuilder.messageTextMarginTop : 0,mBuilder.messageTextMarginRight>0 ? mBuilder.messageTextMarginRight : 0,mBuilder.messageTextMarginBottom>0 ? mBuilder.messageTextMarginBottom : 0);
        if(mBuilder.messageTextSize > 0){
            tvSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,mBuilder.messageTextSize);
        }
        if(mBuilder.messageTextColor >= 0){
            tvSubTitle.setTextColor(ContextCompat.getColor(getContext(),mBuilder.messageTextColor));
        }
        tvSubTitle.setPadding(mBuilder.messageTextMarginLeft>0 ? mBuilder.messageTextMarginLeft : 0,mBuilder.messageTextMarginTop>0 ? mBuilder.messageTextMarginTop : 0,mBuilder.messageTextMarginRight>0 ? mBuilder.messageTextMarginRight : 0,mBuilder.messageTextMarginBottom>0 ? mBuilder.messageTextMarginBottom : 0);
        if(mBuilder.lineBackground != null){
            mLine.setBackground(mBuilder.lineBackground);
        }
        if(mBuilder.lineMargin > 0){
            LinearLayout.LayoutParams lp = (LayoutParams) mLine.getLayoutParams();
            lp.setMargins(mBuilder.lineMargin,0,mBuilder.lineMargin,0);
            mLine.setLayoutParams(lp);
        }

    }


    public static final class Builder {
        private int defaultStyle;
        private int titleTextSize;
        private int titleTextColor;
        private int titleTextMarginTop;
        private int titleTextMarginBottom;
        private int titleTextMarginLeft;
        private int titleTextMarginRight;
        private int messageTextSize;
        private int messageTextColor;
        private int messageTextMarginTop;
        private int messageTextMarginBottom;
        private int messageTextMarginLeft;
        private int messageTextMarginRight;
        private Drawable lineBackground;
        private int lineMargin;
        private Context context;
        private String title;
        private String message;

        public Builder(Context context) {
            this.context = context;
            defaultStyle = DEFAULT_STYLE;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder defaultStyle(int val) {
            defaultStyle = val;
            return this;
        }

        public Builder setLineBackground(Drawable lineBackground) {
            this.lineBackground = lineBackground;
            return this;
        }

        public Builder setLineMargin(int lineMargin) {
            this.lineMargin = lineMargin;
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

        public Builder messageTextSize(int val) {
            messageTextSize = val;
            return this;
        }

        public Builder messageTxtColor(int val) {
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

        public SimpleTextContent build() {
            return new SimpleTextContent(this);
        }
    }
}
