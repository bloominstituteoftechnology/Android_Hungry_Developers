package com.lambdaschool.android_hungry_developers;

import android.util.Log;

public class Developer implements Runnable {
    private static final String TAG = "Developer";
    private String name;
    private Spoon leftSpoon, rightSpoon;

    public Developer(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    public void think() {
        Log.i(TAG, "\"" + this.name + "\" begins thinking at " + System.currentTimeMillis());

        leftSpoon.pickUp();
        rightSpoon.pickUp();

        Log.i(TAG, "\"" + this.name + "\" finishes thinking at " + System.currentTimeMillis());
    }

    public void eat() {
        Log.i(TAG, "\"" + this.name + "\" begins eating at " + System.currentTimeMillis());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rightSpoon.putDown();
        leftSpoon.putDown();

        Log.i(TAG, "\"" + this.name + "\" finishes eating at " + System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
