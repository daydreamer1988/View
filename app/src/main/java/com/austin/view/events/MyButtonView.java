package com.austin.view.events;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Austin on 2017/3/17.
 */

public class MyButtonView extends Button {
    public static final String TAG = "MyButtonView";
    public MyButtonView(Context context) {
        super(context);
    }

    public MyButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    //因为extends Button 这里的super.onTouchEvent()永远为true,即消费了事件。
    //查看原代码将isClickable, isLongClickable, isContextClickable都设置为false, 貌似也不起作用，
    //只有将onTouchEvent强制返回false，点击MyButtonView才不会起作用。
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        return super.onTouchEvent(event);
    }


    //以下都不起作用，
    @Override
    public boolean isClickable() {
        return false;
    }

    @Override
    public boolean isLongClickable() {
        return false;
    }

    @Override
    public boolean isContextClickable() {
        return false;
    }
}
