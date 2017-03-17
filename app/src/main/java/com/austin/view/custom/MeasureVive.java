package com.austin.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Austin on 2017/3/16.
 */

public class MeasureVive extends View {
    private final String TAG = getClass().getSimpleName();
    public MeasureVive(Context context) {
        this(context, null);
    }
    public MeasureVive(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "widthMode:" + getModeName(widthMode));
        Log.e(TAG, "widthSize:" + widthSize);
        Log.e(TAG, "heightMode:" + getModeName(heightMode));
        Log.e(TAG, "heightSize:" + heightSize);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: w:" + w + " h:" + h);
    }

    private String getModeName(int widthMode) {
        String name = "";
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                name = "AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                name = "EXACTLY";
                break;
            case MeasureSpec.UNSPECIFIED:
                name = "UNSPECIFIED";
                break;
        }
        return name;
    }
}
