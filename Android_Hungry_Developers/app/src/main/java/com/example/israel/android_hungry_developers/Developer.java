package com.example.israel.android_hungry_developers;

import android.util.Log;

public class Developer implements Runnable{

    public static final String TAG = "MyDebug";

    public static final int MIN_EAT_TIME = 1000;
    public static final int MAX_EAT_TIME = 2000;

    public Developer(int i, Spoon leftSpoon, Spoon rightSpoon) {
        this.i = i;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    private int i;
    private Spoon leftSpoon;
    private Spoon rightSpoon;

    public void think() {

        // this causes a deadlock when each dev has a spoon
//        leftSpoon.pickUp();
//        Log.d(TAG, String.format("Dev %d picks his left spoon", i));
//        rightSpoon.pickUp();
//        Log.d(TAG, String.format("Dev %d picks his right spoon", i));

        if (leftSpoon.getI() < rightSpoon.getI()) {
            leftSpoon.pickUp();
            Log.d(TAG, String.format("Dev %d picks his left spoon", i));
            rightSpoon.pickUp();
            Log.d(TAG, String.format("Dev %d picks his right spoon", i));
        } else {
            rightSpoon.pickUp();
            Log.d(TAG, String.format("Dev %d picks his right spoon", i));
            leftSpoon.pickUp();
            Log.d(TAG, String.format("Dev %d picks his left spoon", i));
        }

    }

    public void eat() {

        Log.d(TAG, String.format("Dev %d is eating", i));

        try {
            Thread.sleep((int)randRange(MIN_EAT_TIME, MAX_EAT_TIME));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        leftSpoon.putDown();
        rightSpoon.putDown();

        // without this, only some devs are eating
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            think();
            eat();
        }

    }

    public static float randRange(float min, float max) {
        return (float) (min + (max - min) * Math.random());
    }
}
