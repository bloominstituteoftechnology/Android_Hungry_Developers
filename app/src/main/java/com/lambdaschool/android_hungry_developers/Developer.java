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
        if (this.leftSpoon.getIndex() > this.rightSpoon.getIndex()) {
            rightSpoon.pickUp();
            leftSpoon.pickUp();
        } else {
            leftSpoon.pickUp();
            rightSpoon.pickUp();
        }
    }

    public void eat() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rightSpoon.putDown();
        leftSpoon.putDown();
    }

    @Override
    public void run() {
        while (true) {
            Log.i(TAG, "\"" + this.name + "\" begins thinking at " + System.currentTimeMillis());
            think();
            Log.i(TAG, "\"" + this.name + "\" finishes thinking at " + System.currentTimeMillis());

            Log.i(TAG, "\"" + this.name + "\" begins eating at " + System.currentTimeMillis());
            eat();
            Log.i(TAG, "\"" + this.name + "\" finishes eating at " + System.currentTimeMillis());
        }
    }
}
