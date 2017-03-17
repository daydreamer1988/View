package com.austin.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.austin.view.R;

/**
 * Created by Austin on 2017/3/15.
 */

public class AnalyseAttributeView extends View {

    public static final String TAG = "AnylyseAttributeView";
    public AnalyseAttributeView(Context context) {
        super(context);
    }
    public AnalyseAttributeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public AnalyseAttributeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(
                attrs,
                R.styleable.AnylyseAttributeView_Styleable,
                defStyleAttr,
                R.style.DefaultStyle);

        String one = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_one);
        String two = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_two);
        String three = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_three);
        String four = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_four);
        String five = a.getString(R.styleable.AnylyseAttributeView_Styleable_attr_five);
        Log.e(TAG, "one:" + one);
        Log.e(TAG, "two:" + two);
        Log.e(TAG, "three:" + three);
        Log.e(TAG, "four:" + four);
        Log.e(TAG, "five:" + five);
        a.recycle();
    }
}
