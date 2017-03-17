package com.austin.view.events;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.austin.view.R;

/**
 * Created by Austin on 2017/3/17.
 */

public class MyLayout extends LinearLayout {

    public static final String TAG = "MyLayout";

    public MyLayout(Context context) {
        this(context, null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "MyLayout(Context context, AttributeSet attrs)");
        setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        return super.onTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
//        return true;
    }
}
