package com.gaoyy.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        LeftFragment left = (LeftFragment) getSupportFragmentManager().findFragmentById(R.id.third_left);
        if (left == null)
        {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), LeftFragment.newInstance(), R.id.third_left);
        }

        LeftFragment right = (LeftFragment) getSupportFragmentManager().findFragmentById(R.id.third_right);
        if (right == null)
        {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), RightFragment.newInstance(), R.id.third_right);
        }

    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }
}
