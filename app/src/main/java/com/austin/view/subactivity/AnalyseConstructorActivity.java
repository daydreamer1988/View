package com.austin.view.subactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.austin.view.R;
import com.austin.view.custom.AnalyseAttributeView;

public class AnalyseConstructorActivity extends AppCompatActivity {
    private TextView mDescription;
    private AnalyseAttributeView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse_constructor);

        mDescription = (TextView) findViewById(R.id.description);

        mMyView = (AnalyseAttributeView) findViewById(R.id.myView);

        String description = "" +
                "attrs.xm;\n\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<resources>\n" +
                "    <declare-styleable name=\"AnylyseAttributeView_Styleable\">\n" +
                "        <attr name=\"attr_one\" format=\"string\" />\n" +
                "        <attr name=\"attr_two\" format=\"string\" />\n" +
                "        <attr name=\"attr_three\" format=\"string\" />\n" +
                "        <attr name=\"attr_four\" format=\"string\" />\n" +
                "        <attr name=\"attr_five\" format=\"string\" />\n" +
                "    </declare-styleable>\n" +
                "\n" +
                "    <attr name=\"AnylyseAttributeView_defStyleAttr\" format=\"reference\" />\n" +
                "</resources>" +
                "\n\n" +
                "styles.xml\n\n" +
                "<resources>\n" +
                "    <!-- Base application theme. -->\n" +
                "    <style name=\"AppTheme\" parent=\"Theme.AppCompat.Light\">\n" +
                "        <!-- Customize your theme here. -->\n" +
                "        <item name=\"colorPrimary\">@color/colorPrimary</item>\n" +
                "        <item name=\"colorPrimaryDark\">@color/colorPrimaryDark</item>\n" +
                "        <item name=\"colorAccent\">@color/colorAccent</item>\n" +
                "\n" +
                "        <item name=\"attr_one\">attr one from AppTheme</item>\n" +
                "        <item name=\"attr_two\">attr two from AppTheme</item>\n" +
                "        <item name=\"attr_three\">attr three from AppTheme</item>\n" +
                "        <item name=\"attr_four\">attr four from AppTheme</item>\n" +
                "        <item name=\"attr_five\">attr five from AppTheme</item>\n" +
                "\n" +
                "\n" +
                "        <item name=\"AnylyseAttributeView_defStyleAttr\">\n" +
                "            @style/AnyliseAttributeView_FromThemeReference</item>\n" +
                "    </style>\n" +
                "\n" +
                "    <style name=\"AnalyseAttributeView_FromStyle\">\n" +
                "        <item name=\"attr_one\">attr one from style</item>\n" +
                "        <item name=\"attr_two\">attr two from style</item>\n" +
                "    </style>\n" +
                "\n" +
                "    <style name=\"AnyliseAttributeView_FromThemeReference\">\n" +
                "        <item name=\"attr_one\">attr one from theme reference</item>\n" +
                "        <item name=\"attr_two\">attr two from theme reference</item>\n" +
                "        <item name=\"attr_three\">attr three from theme reference</item>\n" +
                "    </style>\n" +
                "\n" +
                "    <style name=\"DefaultStyle\">\n" +
                "        <item name=\"attr_one\">attr one from default</item>\n" +
                "        <item name=\"attr_two\">attr two from default</item>\n" +
                "        <item name=\"attr_three\">attr three from default</item>\n" +
                "        <item name=\"attr_four\">attr four from default</item>\n" +
                "    </style>\n" +
                "\n" +
                "</resources>" +
                "\n\n" +
                "main.xml\n\n" +
                "<com.austin.view.custom.AnalyseAttributeView\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"100dp\"\n" +
                "                android:background=\"@color/colorAccent\"\n" +
                "                minicup:attr_one=\"attr one from xml\"\n" +
                "                style=\"@style/AnalyseAttributeView_FromStyle\"\n" +
                "                />" +
                "\n\n" +
                "AnalyseAttributeVeiw\n\n" +
                "public class AnalyseAttributeView extends View {\n" +
                "\n" +
                "    public static final String TAG = \"AnylyseAttributeView\";\n" +
                "    public AnalyseAttributeView(Context context) {\n" +
                "        super(context);\n" +
                "    }\n" +
                "    public AnalyseAttributeView(Context context, AttributeSet attrs) {\n" +
                "        this(context, attrs, R.attr.AnylyseAttributeView_defStyleAttr);\n" +
                "    }\n" +
                "    public AnalyseAttributeView(Context context, AttributeSet attrs, int defStyleAttr) {\n" +
                "        super(context, attrs, defStyleAttr);\n" +
                "        TypedArray a = context.obtainStyledAttributes(\n" +
                "                attrs,\n" +
                "                R.styleable.AnylyseAttributeView_Styleable,\n" +
                "                defStyleAttr,\n" +
                "                R.style.DefaultStyle);\n" +
                "\n" +
                "        String one = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_one);\n" +
                "        String two = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_two);\n" +
                "        String three = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_three);\n" +
                "        String four = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_four);\n" +
                "        String five = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_five);\n" +
                "        Log.e(TAG, \"one:\" + one);\n" +
                "        Log.e(TAG, \"two:\" + two);\n" +
                "        Log.e(TAG, \"three:\" + three);\n" +
                "        Log.e(TAG, \"four:\" + four);\n" +
                "        Log.e(TAG, \"five:\" + five);\n" +
                "        a.recycle();\n" +
                "    }\n" +
                "}" +
                "\n\n" +
                "结果：\n" +
                "E/AnylyseAttributeView: one:attr one from xml\n" +
                "E/AnylyseAttributeView: two:attr two from style\n" +
                "E/AnylyseAttributeView: three:attr three from theme reference\n" +
                "E/AnylyseAttributeView: four:attr four from AppTheme\n" +
                "E/AnylyseAttributeView: five:attr five from AppTheme\n" +
                "\n" +
                "如果将AnalyseAttributeView中的第三个参数改为0\n" +
                "TypedArray a = context.obtainStyledAttributes(\n" +
                "                attrs,\n" +
                "                R.styleable.AnylyseAttributeView_Styleable,\n" +
                "                defStyleAttr,\n" +
                "                R.style.DefaultStyle);\n" +
                "\n" +
                "结果：\n" +
                "E/AnylyseAttributeView: one:attr one from xml\n" +
                "E/AnylyseAttributeView: two:attr two from style\n" +
                "E/AnylyseAttributeView: three:attr three from default\n" +
                "E/AnylyseAttributeView: four:attr four from default\n" +
                "E/AnylyseAttributeView: five:attr five from AppTheme\n" +
                "\n" +
                "总结：\n\n" +
                "属性值定义的优先级：\n" +
                "xml>\n" +
                "style>\n" +
                "AppTheme中直接定义的默认Sytle>\n" +
                "style.xml中单独定义的默认Style（通过obtainStyledAttributes的第四个参数指定）>\n" +
                "在 AppTheme 中直接指定属性值" +
                "\n" +
                "总结相似的一篇文章：点击上面视图\n" +
                "http://blog.csdn.net/mybeta/article/details/39993449";

        mDescription.setText(description);

        mMyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/mybeta/article/details/39993449")));

            }
        });

    }
}
