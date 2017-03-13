package com.austin.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.austin.view.R;


/**
 * Created by Austin on 2017/3/13.
 */

public class LifeCycleViewGroup extends ViewGroup {

    private static final String TAG = "LifeCycleViewGroup";

    public LifeCycleViewGroup(Context context) {
        this(context, null);
    }

    public LifeCycleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        Log.e(TAG, "init()");

        setWillNotDraw(false);
        //setBackgroundResource(R.color.colorAccent);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure(int " + widthMeasureSpec + ", int " + heightMeasureSpec + ") ");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG, "onLayout(boolean " + changed + ", int " + l + ", int " + t + ", int " + r + ", int " + b + ")");

    }


    //该方法在ViewGroup中默认是不会被调用的，
    //要想被调用：
    // 1. 在Xml中设置该控件的 android:background="@color/colorAccent"
    // 2. 在该View的构造方法设置 setBackgroundResource(R.color.colorAccent);
    // 3. 在该View的构造方法设置 setWillNotDraw(false);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(getResources().getColor(R.color.colorAccent));

        Log.e(TAG, "onDraw(Canvas canvas) canvas.getWidth():" + canvas.getWidth() + "  canvas.getHeight():" + canvas.getHeight());
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.e(TAG, "dispatchDraw(Canvas canvas) canvas.getWidth():" + canvas.getWidth() + "  canvas.getHeight():" + canvas.getHeight());

    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        Log.e(TAG, "requestLayout()");
    }

    @Override
    public void invalidate() {
        super.invalidate();
        Log.e(TAG, "invalidate()");
    }

    boolean flag = false;
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "ACTION_DOWN");

                //invalidate()方法会重新调用onDraw(), dispatchDraw()方法, 只绘制调用者本身
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ACTION_MOVE");
                //setVisibility(INVISIBLE);


                //从INVISIBLE/VISIBLE到GONE 会调用requestLayout()方法
                //setVisibility(GONE);

                break;

            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ACTION_UP");

                //从INVISIBLE到VISIBLE 会调用invalidate方法，onDraw(), dispatchDraw()会被调用
                //setVisibility(VISIBLE);


                flag = !flag;
                //setEnabled()值发生改变时调用onDraw(), dispatchDraw()方法，不改变不调用。
                //setEnabled(flag);

                //setSelected()值发生改变时调用onDraw(), dispatchDraw()方法，不改变不调用。
                //setSelected(flag);

                break;

        }

        return true;
    }

}
