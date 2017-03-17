package com.austin.view.subactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.austin.view.R;

public class OnMeasureAnalyseActivity extends AppCompatActivity {
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_measure_analyse);

        mTv = (TextView) findViewById(R.id.tv);

        String text = "" +
                "main.xml\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "MeasureView\n" +
                "\n" +
                "public class MeasureVive extends View {\n" +
                "    private final String TAG = getClass().getSimpleName();\n" +
                "    public MeasureVive(Context context) {\n" +
                "        this(context, null);\n" +
                "    }\n" +
                "    public MeasureVive(Context context, AttributeSet attrs) {\n" +
                "        super(context, attrs);\n" +
                "    }\n" +
                "    @Override\n" +
                "    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {\n" +
                "        super.onMeasure(widthMeasureSpec, heightMeasureSpec);\n" +
                "        int widthMode = MeasureSpec.getMode(widthMeasureSpec);\n" +
                "        int heightMode = MeasureSpec.getMode(heightMeasureSpec);\n" +
                "        int widthSize = MeasureSpec.getSize(widthMeasureSpec);\n" +
                "        int heightSize = MeasureSpec.getSize(heightMeasureSpec);\n" +
                "        Log.e(TAG, \"widthMode:\" + getModeName(widthMode));\n" +
                "        Log.e(TAG, \"widthSize:\" + widthSize);\n" +
                "        Log.e(TAG, \"heightMode:\" + getModeName(heightMode));\n" +
                "        Log.e(TAG, \"heightSize:\" + heightSize);\n" +
                "    }\n" +
                "    @Override\n" +
                "    protected void onSizeChanged(int w, int h, int oldw, int oldh) {\n" +
                "        super.onSizeChanged(w, h, oldw, oldh);\n" +
                "        Log.e(TAG, \"onSizeChanged: w:\" + w + \" h:\" + h);\n" +
                "    }\n" +
                "\n" +
                "    private String getModeName(int widthMode) {\n" +
                "        String name = \"\";\n" +
                "        switch (widthMode) {\n" +
                "            case MeasureSpec.AT_MOST:\n" +
                "                name = \"AT_MOST\";\n" +
                "                break;\n" +
                "            case MeasureSpec.EXACTLY:\n" +
                "                name = \"EXACTLY\";\n" +
                "                break;\n" +
                "            case MeasureSpec.UNSPECIFIED:\n" +
                "                name = \"UNSPECIFIED\";\n" +
                "                break;\n" +
                "        }\n" +
                "        return name;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "结果：\n" +
                "onMeasrue()方法调用了4次\n" +
                "前两次的heightSize不知道是如何计算出来的\n" +
                "最后两次的heightSize正好是DrawingZone（减去StatusBar, ActionBar, NavigationBar的高度）\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:1080 h:1536\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "MeasureView改为 100dp* 100dp\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:layout_width=\"100dp\"\n" +
                "        android:layout_height=\"100dp\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:300 h:300\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "将MeasureView设置为wrap_content\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:1080 h:1536\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "将父布局设置为100dp* 100dp\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"100dp\"\n" +
                "    android:layout_height=\"100dp\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:300 h:300\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"100dp\"\n" +
                "    android:layout_height=\"100dp\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"100dp\"\n" +
                "        android:layout_height=\"100dp\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:300 h:300\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"100dp\"\n" +
                "    android:layout_height=\"100dp\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:300 h:300\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "将父布局设置为wrap_content\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"wrap_content\"\n" +
                "    android:layout_height=\"wrap_content\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:1080 h:1536\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"wrap_content\"\n" +
                "    android:layout_height=\"wrap_content\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"100dp\"\n" +
                "        android:layout_height=\"100dp\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:300\n" +
                "E/MeasureVive: heightMode:EXACTLY\n" +
                "E/MeasureVive: heightSize:300\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:300 h:300\n" +
                "\n" +
                "main.xml\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:id=\"@+id/activity_on_measure_analyse\"\n" +
                "    android:layout_width=\"wrap_content\"\n" +
                "    android:layout_height=\"wrap_content\">\n" +
                "    <com.austin.view.custom.MeasureVive\n" +
                "        android:id=\"@+id/myView\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:background=\"@color/colorAccent\" />\n" +
                "</RelativeLayout>\n" +
                "\n" +
                "结果：\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1320\n" +
                "\n" +
                "E/MeasureVive: widthMode:AT_MOST\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: widthMode:EXACTLY\n" +
                "E/MeasureVive: widthSize:1080\n" +
                "E/MeasureVive: heightMode:AT_MOST\n" +
                "E/MeasureVive: heightSize:1536\n" +
                "\n" +
                "E/MeasureVive: onSizeChanged: w:1080 h:1536";

        mTv.setText(text);
    }
}
