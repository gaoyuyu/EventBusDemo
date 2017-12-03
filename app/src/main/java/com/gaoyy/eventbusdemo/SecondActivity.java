package com.gaoyy.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import de.greenrobot.event.EventBus;


public class SecondActivity extends AppCompatActivity
{
    private RelativeLayout activitySecond;
    private Button secondBtn;

    private void assignViews() {
        activitySecond = (RelativeLayout) findViewById(R.id.activity_second);
        secondBtn = (Button) findViewById(R.id.second_btn);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        assignViews();


        secondBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EventBus.getDefault().post("Second message");
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
