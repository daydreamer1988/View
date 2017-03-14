package com.austin.view.subactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.austin.view.R;
import com.austin.view.custom.LifeCycleViewGroup;

public class LifeCycleActivity extends AppCompatActivity {
    private TextView mTv;
    private LifeCycleViewGroup mLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        findById();
        setTitle("ViewGroup及View的生命周期");

        initData();
    }

    private void initData() {
        String description = "以上是一个ViewGroup（100dp*100dp）\n" +
                "ViewGroup的onDraw()方法在ViewGroup中默认是不会被调用的，\n\n" +
                "要想被调用：\n" +
                " \t1. 在Xml中设置该控件的 android:background=\"@color/colorAccent\"\n" +
                " \t2. 在该ViewGroup的构造方法设置 setBackgroundResource(R.color.colorAccent);\n" +
                " \t3. 在该ViewGroup的构造方法设置 setWillNotDraw(false);\n\n" +
                "原因：\n" +
                "\t容器，ViewGroup嘛，它本身并没有任何可画的东西，它是一个透明的控件，因些并不会触发onDraw，\n" +
                "\t但是你现在给LinearLayout设置一个背景色，其实这个背景色不管你设置成什么颜色，系统会认为，\n" +
                "\t这个LinearLayout上面有东西可画了，因此会调用onDraw方法\n\n" +
                "流程：\n" +
                "\tinit()\n" +
                "\tonMeasure(int 1073742124, int 1073742124)(会调用多次)\n" +
                "\tonLayout(boolean true, int 0, int 0, int 300, int 300)\n" +
                "\tonDraw(Canvas canvas) canvas.getWidth():300  canvas.getHeight():300\n" +
                "\tdispatchDraw(Canvas canvas) canvas.getWidth():300  canvas.getHeight():300\n\n" +
                "invalidate();\n" +
                "\t直接调用invalidate()方法，会重新调用onDraw(), dispatchDraw()方法, 只绘制调用者本身\n" +
                "\tsetVisibility(VISIBLE); 从INVISIBLE到VISIBLE 会调用invalidate方法，onDraw(), dispatchDraw()会被调用\n" +
                "\tsetEnabled()值发生改变时调用onDraw(), dispatchDraw()方法，不改变不调用。\n" +
                "\tsetSelected()值发生改变时调用onDraw(), dispatchDraw()方法，不改变不调用。\n\n" +
                "requestLayout();\n" +
                "\t导致调用measure()过程 和 layout()过程\n" +
                "\tsetVisibility(GONE); 从VISIBLE/INVISIBLE到GONE 会调用requestLayout()方法\n" +
                "\t\n" +
                "\t\n";

        mTv.setText(description);
    }

    private void findById() {
        mTv = (TextView) findViewById(R.id.tv);

        mLifeCycle = (LifeCycleViewGroup) findViewById(R.id.lifeCycle);

    }
}
