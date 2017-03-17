package com.austin.view.subactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.austin.view.R;
import com.austin.view.events.MyButtonView;
import com.austin.view.events.MyTextView;
import com.austin.view.events.MyView;

public class TouchActivity extends AppCompatActivity {
    private MyButtonView mMyButtonView;
    private MyTextView mMyTextView;
    private MyView mMyView;

    public static final String TAG = "TouchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        mMyButtonView = (MyButtonView) findViewById(R.id.myButtonView);
        mMyButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });


        mMyTextView = (MyTextView) findViewById(R.id.myTextView);

        //mMyTextview.setOnClcikListener(null);与下面效果一样
        mMyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchActivity.this, "textview clicked", Toast.LENGTH_SHORT).show();
            }
        });


        mMyView = (MyView) findViewById(R.id.myView);
        mMyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchActivity.this, "myview clicked", Toast.LENGTH_SHORT).show();

            }
        });
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
    }

}
