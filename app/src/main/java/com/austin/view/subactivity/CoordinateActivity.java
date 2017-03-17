package com.austin.view.subactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.austin.view.R;
import com.austin.view.custom.CoordinateView;
import com.austin.view.utils.DisplayUtil;

public class CoordinateActivity extends AppCompatActivity {
    private TextView mXY;
    private TextView mRawXY;

    private TextView mViewxY;
    private TextView mViewrawXY;


    private RelativeLayout mRedView;
    private CoordinateView mCoordinatView;
    private TextView mDescription;
    private TextView fromActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        setTitle("坐标系");
        findById();


        mCoordinatView.setListener(new CoordinateView.OnTouchListener() {
            @Override
            public float onTouchCoordinate(float x, float y, float rawX, float rawY) {
                mViewxY.setText("\t\tviewX:" + x + " viewY:" + y);
                mViewrawXY.setText("\t\tviewRawX:" + rawX + " viewRawY:" + rawY);
                return 0;
            }
        });

        //如果 mCoordinatView 的onTouchEvent()返回true将不会触发点击事件
       /* mCoordinatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoordinateActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

    }



    private void findById() {
        mXY = (TextView) findViewById(R.id.xY);
        mRawXY = (TextView) findViewById(R.id.rawXY);

        mViewxY = (TextView) findViewById(R.id.viewxY);
        mViewrawXY = (TextView) findViewById(R.id.viewrawXY);


        mRedView = (RelativeLayout) findViewById(R.id.redView);
        mCoordinatView = (CoordinateView) findViewById(R.id.coordinatView);

        mDescription = (TextView) findViewById(R.id.description);
        fromActivity = (TextView) findViewById(R.id.fromActivity);

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        String screenInfo = "" +
                "屏幕信息: 实际宽*高：" + DisplayUtil.getScreenWidth(this) + "*" + DisplayUtil.getRealScreenHeight(getBaseContext()) +
                "\n不含Navigation宽*高：" + DisplayUtil.getScreenWidth(this) + "*" + DisplayUtil.getScreenHeight1(this) +
                "\n状态栏高度：" + DisplayUtil.getStatusBarHeight(this) + "  ActionBar高度：" + DisplayUtil.getTitleBarHeight(this) +
                "\nNativation高度：" + (DisplayUtil.getRealScreenHeight(this) - DisplayUtil.getScreenHeight1(this));


        String description = "\n\n" +
                "说明：\n" +
                "\n" +
                "\t红色区域为：RelativeLayout \n" +
                "\tmarginTop:150dp, marginLeft:150dp\n" +
                "\twidth:200dp, height:200dp\n" +
                "\n" +
                "\t蓝色区域为：CoordinateView \n" +
                "\tmarginTop:50dp, marginLeft:50dp\n" +
                "\twidth:100dp, height:100dp\n" +
                "\n" +
                "";
        mDescription.setText(screenInfo + description);

//        mScreenInfo.setText(screenInfo);


    }



    //此处可以是可以，但是一但被子View拦截，便不再调用

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "Activity.onTouchEvent()");
        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();

        mXY.setText("\t\tx:" + x + "y:" + y);
        mRawXY.setText("\t\trawX:" + rawX + " rawY:" + rawY);

        return super.onTouchEvent(event);
    }*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TAG", "Activity.dispatchTouchEvent()");

        float x = event.getX();
        float y = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();

        mXY.setText("\t\tx:" + x + "y:" + y);
        mRawXY.setText("\t\trawX:" + rawX + " rawY:" + rawY);

        return super.dispatchTouchEvent(event);
    }

}
