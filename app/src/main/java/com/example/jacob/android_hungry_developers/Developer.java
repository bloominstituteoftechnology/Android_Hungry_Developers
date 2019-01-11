package com.example.jacob.android_hungry_developers;

import android.util.Log;

public class Developer implements Runnable {
    int id;
    private Spoon leftSpoon;
    private Spoon rightSpoon;

    public Developer(int id, Spoon leftSpoon, Spoon rightSpoon) {
        this.id = id;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    public void eat() {
        while ((leftSpoon.devId != id) && (rightSpoon.devId != id)) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(leftSpoon.devId != id) {
                leftSpoon.pickUp(id);
            }
            if (rightSpoon.devId != id) {
                rightSpoon.pickUp(id);
            }
        }
        Log.i("DevActivity", String.format("Dev %s is eating.", id));
        leftSpoon.clean = false;
        rightSpoon.clean = false;
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void think() {
        if ((Math.random()*10) > 2) {
            leftSpoon.putDown();
            rightSpoon.putDown();
            Log.i("DevActivity", String.format("Dev %s is thinking.", id));
        } else {
            Log.i("DevActivity", String.format("Dev %s is thinking so hard he forgot to put down his spoons!", id));
        }
        try {
            Thread.sleep((long) (Math.random() * 2000));
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
}
