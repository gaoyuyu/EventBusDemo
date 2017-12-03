package com.gaoyy.eventbusdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoyy.eventbusdemo.event.FragmentEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


public class RightFragment extends Fragment
{
    private TextView rightTv;

    private void assignViews(View rootView)
    {
        rightTv = (TextView) rootView.findViewById(R.id.right_tv);
    }

    public RightFragment()
    {
        // Required empty public constructor
    }

    public static RightFragment newInstance()
    {
        RightFragment fragment = new RightFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
        if (getArguments() != null)
        {

        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_right, container, false);
        assignViews(rootView);
        return rootView;
    }


    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEvent(FragmentEvent event)
    {
        rightTv.setText(event.getText());
    }


}
