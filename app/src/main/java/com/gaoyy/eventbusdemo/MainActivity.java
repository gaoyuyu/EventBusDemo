package com.gaoyy.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gaoyy.eventbusdemo.event.ActivityEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


public class MainActivity extends AppCompatActivity
{
    private Button mainBtn;
    private Button mainThirdBtn;

    private void assignViews() {
        mainBtn = (Button) findViewById(R.id.main_btn);
        mainThirdBtn = (Button) findViewById(R.id.main_third_btn);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        assignViews();

        mainBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


        mainThirdBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void showToast(ActivityEvent event)
    {
        Toast.makeText(this, "Main:"+event.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
