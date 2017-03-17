package com.austin.view.subactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.austin.view.R;

public class ColorActivity extends AppCompatActivity {
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mTv = (TextView) findViewById(R.id.tv);

        String text = "" +
                "ARGB8888\t四通道高精度(32位)\n" +
                "ARGB4444\t四通道低精度(16位)\n" +
                "RGB565\t屏幕默认模式(16位\n" +
                "Alpha8\t仅有透明通道(8位)\n" +
                "\n" +
                "注意：我们常用的是ARGB8888和ARGB4444，而在所有的安卓设备屏幕上默认的模式都是RGB565,请留意这一点。\n\n" +
                "类型\t      解释\t0(0x00)\t255(0xff)\n" +
                "A(Alpha)\t 透明度\t透明\t  不透明\n" +
                "R(Red)\t   红色\t  无色\t  红色\n" +
                "G(Green)\t 绿色\t  无色\t  绿色\n" +
                "B(Blue)\t  蓝色\t  无色\t  蓝色\n\n" +
                "当RGB全取最小值(0或0x000000)时颜色为黑色，全取最大值(255或0xffffff)时颜色为白色";

        mTv.setText(text);

    }
}
