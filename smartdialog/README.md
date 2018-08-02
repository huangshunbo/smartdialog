#### Summary
---
这是一个基础库，主要包含弹框功能、Toast吐司功能、简单的进度条功能

弹框Dialog功能说明：
弹框功能分为两个部分，一部分是外框即SmartDialog部分；一部分是主要内容View，基础库会提供一些常用模板，业务层可自定义。最后将两部分进行组合。
弹框功能不支持同时弹出多个弹框，如果同时弹出show多个，则显示最后show出来的弹框。

吐司功能说明：
提供屏幕上中下三个位置的吐司功能。

进度条功能说明：
提供纯色的水平进度条和圆形进度条，进度条可包含两种进度。

#### Getting Started
---
导入库
```Java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}


dependencies {
  implementation 'com.github.huangshunbo:smartdialog:lastest.release'
}
```

###### Dialog的简单使用

SmartDialog

1. 覆盖全局的style设置，覆盖lib_common_dialog_theme做全局的样式配置

```Java
<style name="lib_common_dialog_theme">

    <item name="lib_dialog_background">@drawable/common_frame_corner_white</item>
    <item name="lib_dialog_bottom_line">#999999</item>
    <item name="lib_dialog_line1">#999999</item>
    <item name="lib_dialog_line2">#999999</item>

    <item name="lib_dialog_bottom_heigh">45dp</item>

    <item name="lib_dialog_left_textsize">17dp</item>
    <item name="lib_dialog_left_textcolor">#999999</item>
    <item name="lib_dialog_left_background">#00000000</item>

    <item name="lib_dialog_middle_textsize">17dp</item>
    <item name="lib_dialog_middle_textcolor">#999999</item>
    <item name="lib_dialog_middle_background">#00000000</item>

    <item name="lib_dialog_right_textsize">17dp</item>
    <item name="lib_dialog_right_textcolor">#999999</item>
    <item name="lib_dialog_right_background">#00000000</item>
</style>
```

也可以继承lib_common_dialog_theme自定义一个theme，然后在使用时进行局部的样式设置
mDialog.setTheme(R.style.dialog_theme)

2. 示例代码
```Java
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
                .setLeftOnclickListener(null)
                .setMiddleOnclickListener(null)
                .setRightOnclickListener(null)
                .setContentView(content) // 设置主体内容View,泛型SimpleTextContent表示要设置进来的View类型
                .build();
```

3. SmartDialog暴露的方法
```Java
smartDialog.setForceOpen(true); //强制打开弹框，即点击弹框外区域不会关闭弹框
smartDialog.setWidthScale(0.8F); //设置弹框的宽度占屏幕比
smartDialog.getTvButtonLeft();
smartDialog.getTvButtonMiddle();
smartDialog.getTvButtonRight();
smartDialog.getContentView(); //获取内容主体View
smartDialog.getBottomLine(); //获取弹框底部分割线
smartDialog.getLine1(); //获取弹框按钮间的分割线
smartDialog.getLine2(); //获取弹框按钮间的分割线
```

4. 库提供的主体View模板-SimpleTextContent
这个View支持一个Title + 一个Message 或者 只有一个Message的表现形式
依然可全局覆盖style来做统一的样式配置
```Java
<style name="lib_dialog_simpletext_content">
    <item name="simpletext_title_textsize">12dp</item>
    <item name="simpletext_title_textcolor">@color/color_black</item>
    <item name="simpletext_title_margin_top">10dp</item>
    <item name="simpletext_title_margin_bottom">10dp</item>
    <item name="simpletext_title_margin_left">10dp</item>
    <item name="simpletext_title_margin_right">10dp</item>

    <item name="simpletext_message_textsize">22dp</item>
    <item name="simpletext_message_textcolor">@color/color_black</item>
    <item name="simpletext_message_margin_top">20dp</item>
    <item name="simpletext_message_margin_bottom">20dp</item>
    <item name="simpletext_message_margin_left">20dp</item>
    <item name="simpletext_message_margin_right">20dp</item>

    <item name="simpletext_line_background">@drawable/lib_dialog_simpletext_line</item>
    <item name="simpletext_line_margin">20dp</item>
</style>
```

同样支持在代码里进行局部的样式设置
```Java
content.defaultStyle(R.style.simpletext_theme)
```

与SmartDialog的组合使用如下
```Java
SimpleTextContent content = new SimpleTextContent.Builder(context)
    .setTitle("标题")
    .defaultStyle(R.style.content_theme)
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
    .setLineBackground(new ColorDrawable(Color.BLUE)) //设置分割线
    .setLineMargin(20) //设置分割线的margin，注意这里的margin只有左右的margin而已
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
    .setLeftOnclickListener(null)
    .setMiddleOnclickListener(null)
    .setRightOnclickListener(null)
    .setContentView(content) // 设置主体内容View
    .build();
```

SimpleTextContent暴露的方法
```Java
content.getTitle();
content.getSubTitle();
content.getLine();//获取分割线
```

5. 库提供的主体View模板-InputContent
包含输入框的主体View
依然可全局覆盖style来做统一的样式配置
```Java
<style name="lib_dialog_input_content">
    <item name="input_title_textsize">22dp</item>
    <item name="input_title_textcolor">@color/color_black</item>
    <item name="input_title_margin_top">10dp</item>
    <item name="input_title_margin_bottom">10dp</item>
    <item name="input_title_margin_left">10dp</item>
    <item name="input_title_margin_right">10dp</item>

    <item name="input_message_textsize">22dp</item>
    <item name="input_message_textcolor">@color/color_black</item>
    <item name="input_message_margin_top">10dp</item>
    <item name="input_message_margin_bottom">10dp</item>
    <item name="input_message_margin_left">10dp</item>
    <item name="input_message_margin_right">10dp</item>

    <item name="input_sub_message_textsize">40dp</item>
    <item name="input_sub_message_textcolor">@color/color_black</item>
    <item name="input_sub_message_margin_top">10dp</item>
    <item name="input_sub_message_margin_bottom">10dp</item>
    <item name="input_sub_message_margin_left">10dp</item>
    <item name="input_sub_message_margin_right">10dp</item>

    <item name="input_line_background">@drawable/lib_dialog_simpletext_line</item>
    <item name="input_line_margin">10dp</item>

    <item name="input_input_background">@null</item>
    <item name="input_input_margin">10dp</item>

    <item name="input_status_open">@null</item>
    <item name="input_status_close">@null</item>

    <item name="input_func_text">忘记密码</item>
    <item name="input_func_text_color">@color/color_gray</item>

    <item name="input_bottom_space">30dp</item>
</style>
```
同样支持在代码里进行局部的样式设置
```Java
content.defaultStyle(R.style.input_theme)
```
与SmartDialog的组合使用如下
```Java
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
    .defaultStyle(R.style.input_theme)
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
```
InputContent暴露的方法
```Java
content.getmDialogInputContentTitle();//标题
content.getmDialogInputContentMessage();//消息
content.getmDialogInputContentSubMessage();//副消息
content.getmDialogInputContentLine();//分割线
content.getmDialogInputContentEt();//输入框
content.getmDialogInputContentStatu();//输入框右侧按钮
content.getmDialogInputContentFunc();//输入框下面功能按钮
content.getmDialogInputContentInput();//输入框包裹体
```

6. 建议将主体View+Dialog放到一个工厂类中进行创建

期待的姿势
```Java
public class SmartDialogFactory {

    public static SmartDialog createMessageDialog(Context context,String message){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
            .setMessage(message)
            .build();
        SmartDialog smartDialog = new SmartDialog.Builder(context)
            .setButtonAutoDismiss(true)
            .setContentView(content)
            .setButtonRight("确认")
            .build();
        return smartDialog;
    }

    public static SmartDialog createSimpleDialog(Context context,String title,String message,View.OnClickListener listener){
        SimpleTextContent content = new SimpleTextContent.Builder(context)
            .setTitle(title)
            .messageTxtColor(R.color.color_orange)
            .setMessage(message)
            .build();
        SmartDialog<SimpleTextContent> smartDialog = new SmartDialog.Builder<SimpleTextContent>(context)
            .setButtonAutoDismiss(true)
            .setButtonLeft("取消")
            .setButtonRight("确认")
            .setRightOnclickListener(listener)
            .setContentView(content)
            .build();
        return smartDialog;
    }
}
```


##### Feature
1. 将主体View和Dialog结合，可完全使用一个链式调用完成Dialog的创建
2. 加入更多的统一模板
3. 新模板使用kotlin

##### Sample
##### Known Issues
暂时没有收到任何反馈，有任何疑问或需求，可提issue。
##### Support
黄顺波




