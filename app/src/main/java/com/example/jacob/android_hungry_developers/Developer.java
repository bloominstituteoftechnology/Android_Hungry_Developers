package com.example.jacob.android_hungry_developers;

import android.util.Log;

public class Developer implements Runnable {
    private int id;
    private Spoon leftSpoon;
    private Spoon rightSpoon;

    public Developer(int id, Spoon leftSpoon, Spoon rightSpoon) {
        this.id = id;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    public void eat() {
        leftSpoon.pickUp();
        rightSpoon.pickUp();
        Log.i("DevActivity",String.format("Dev %s is eating.",id));
        try {
            Thread.sleep((long) (Math.random()*2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void think() {
        leftSpoon.putDown();
        rightSpoon.putDown();
        Log.i("DevActivity",String.format("Dev %s is thinking.",id));
    }


    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
