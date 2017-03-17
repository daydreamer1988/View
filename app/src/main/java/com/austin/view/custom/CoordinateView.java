package com.austin.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by Austin on 2017/3/14.
 */

public class CoordinateView extends View {

    private Paint mPaint;
    private double textHeight16sp;

    public CoordinateView(Context context) {
        this(context, null);
    }

    public CoordinateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        Log.e(TAG, "init()");
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(sp2px(16));
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        textHeight16sp = Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("ChildView", dp2px(10), (float) (textHeight16sp + dp2px(10)), mPaint);

    }
    private float sp2px(int sp) {
        float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (float) (scaledDensity * sp + 0.5);
    }


    private int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "View.onTouchEvent");
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();

        int top = getTop();
        int left = getLeft();
        Log.e("TAG", "top:" + top + " left:" + left);

        listener.onTouchCoordinate(x, y, rawX, rawY);
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TAG", "View.dispatchTouchEvent");
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        listener.onTouchCoordinate(x, y, rawX, rawY);
        return super.dispatchTouchEvent(event);
    }


    public interface OnTouchListener{
        float onTouchCoordinate(float x, float y, float rawX, float rawY);
    }
    private OnTouchListener listener;

    public void setListener(OnTouchListener listener) {
        this.listener = listener;
    }
}
