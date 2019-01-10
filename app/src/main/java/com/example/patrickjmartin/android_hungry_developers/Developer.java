package com.example.patrickjmartin.android_hungry_developers;

import android.util.Log;

import java.util.Random;

public class Developer implements Runnable {

    private final int id;
    private final Spoon LSpoon;
    private final Spoon RSpoon;


    public Developer(int id, Spoon LSpoon, Spoon RSpoon) {
        this.id = id;
        this.LSpoon = LSpoon;
        this.RSpoon = RSpoon;
    }

    public void think() {
        LSpoon.putDown();
        RSpoon.putDown();
        Log.i("Developer Activity ---", String.format("Dev %s is eating.", id));

    }

    public void eat() {
        if(LSpoon.pickUp()) {
            if(RSpoon.pickUp()) {
                Log.i("Developer Activity ---", String.format("Dev %s is eating.", id));
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }


    @Override
    public void run() {
        while(true){
            think();
            eat();
        }
    }
}
