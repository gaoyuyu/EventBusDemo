package com.gaoyy.eventbusdemo.event;

/**
 * Created by gaoyy on 2017/12/3 0003.
 */

public class ActivityEvent
{
    private String text;

    public ActivityEvent(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
