package com.joshuahalvorson.android_hungry_developers;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.Semaphore;

public class Spoon {
    private Semaphore lock;
    private int index;
    private ImageView imageView;
    Activity activity;

    public Spoon(int index, ImageView imageView, Activity activity) {
        this.index = index;
        this.imageView = imageView;
        this.activity = activity;
        this.lock = new Semaphore(1);
    }

    public void pickUp(){
        while(!this.acquire()){ }
    }

    public void putDown(){
        this.release();
    }

    public boolean acquire(){
        try {
            lock.acquire();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imageView.setVisibility(View.INVISIBLE);
                }
            });
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void release(){
        lock.release();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }

    public int getIndex() {
        return index;
    }
}
