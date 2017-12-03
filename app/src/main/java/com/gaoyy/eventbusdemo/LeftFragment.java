package com.gaoyy.eventbusdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gaoyy.eventbusdemo.event.FragmentEvent;

import de.greenrobot.event.EventBus;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment
{
    private Button leftBtn;
    private EditText leftEv;

    private void assignViews(View rootView ) {
        leftBtn = (Button) rootView.findViewById(R.id.left_btn);
        leftEv = (EditText) rootView.findViewById(R.id.left_ev);
    }

    public LeftFragment()
    {
        // Required empty public constructor
    }

    public static LeftFragment newInstance()
    {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_left, container, false);
        assignViews(rootView);


        leftBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String text = leftEv.getText().toString();

                EventBus.getDefault().post(new FragmentEvent(text));
            }
        });




        return rootView;
    }

}
