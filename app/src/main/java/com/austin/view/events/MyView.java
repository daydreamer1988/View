package com.austin.view.events;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Austin on 2017/3/17.
 */

public class MyView extends View {
    public static final String TAG = "MyView";
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    //默认返回false
    //但是如果给些View设置onClickListener()的话，这里的super.onTouchEvent()返回为true;
    //即使这个listener为null，也可以触发点击事件。

    //或者在xml里设置 clickable="true"

    //或者在这里直接返回true; 但是如果这里直接返回true, 则不能监听  onClick事件了
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
