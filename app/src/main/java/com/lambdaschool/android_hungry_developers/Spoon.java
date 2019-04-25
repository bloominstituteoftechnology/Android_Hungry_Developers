package com.lambdaschool.android_hungry_developers;

import android.util.Log;

import java.util.concurrent.Semaphore;

public class Spoon {
    private static final String TAG = "Spoon";
    private Semaphore lock;
    private String name;
    private int index;

    public Spoon(String name, int index) {
        this.name = name;
        this.index = index;
        this.lock = new Semaphore(1);
    }

    public void pickUp() {
        try {
            this.lock.acquire();
            Log.i(TAG, "    \"" + this.name + "\" picked up at " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown() {
        Log.i(TAG, "    \"" + this.name + "\" put down at " + System.currentTimeMillis());
        this.lock.release();
    }

    public int getIndex() {
        return index;
    }
}
