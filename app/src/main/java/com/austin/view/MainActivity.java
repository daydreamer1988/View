package com.austin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.austin.view.subactivity.CoordinateActivity;
import com.austin.view.subactivity.LifeCycleActivity;

public class MainActivity extends AppCompatActivity {
    private Button mLifeCycle;
    private Button mCoordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();

        initListener();


    }

    private void initListener() {
        mLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
            }
        });

        mCoordinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoordinateActivity.class));
            }
        });

    }

    private void findById() {
        mLifeCycle = (Button) findViewById(R.id.lifeCycle);

        mCoordinate = (Button) findViewById(R.id.coordinate);

    }
}
