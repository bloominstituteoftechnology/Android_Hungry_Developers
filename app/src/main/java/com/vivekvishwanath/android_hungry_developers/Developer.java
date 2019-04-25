package com.vivekvishwanath.android_hungry_developers;

import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

public class Developer implements Runnable {
    private static final int MIN_WAIT_TIME = 1000;
    private static final int MAX_WAIT_TIME = 3001;
    private String name;
    private Spoon leftSpoon, rightSpoon;

    public Developer(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    private void think() {
        if (leftSpoon.getIndex() < rightSpoon.getIndex()) {
            Log.i("HungryDevelopers", "Developer " + this.name + " is thinking");
            leftSpoon.pickUp();
            Log.i("HungryDevelopers", "Developer " + this.name + " picked up left spoon");
            rightSpoon.pickUp();
            Log.i("HungryDevelopers", "Developer " + this.name + " picked up right spoon");
        } else if (leftSpoon.getIndex() > rightSpoon.getIndex()) {
            rightSpoon.pickUp();
            Log.i("HungryDevelopers", "Developer " + this.name + " picked up right spoon");
            leftSpoon.pickUp();
            Log.i("HungryDevelopers", "Developer " + this.name + " picked up left spoon");
        }
    }

    private void eat() {
        Log.i("HungryDevelopers", "Developer " + this.name + " is eating");
        int eatTime = ThreadLocalRandom.current().nextInt(MIN_WAIT_TIME, MAX_WAIT_TIME);
        try {
            Thread.sleep(eatTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftSpoon.putDown();
        rightSpoon.putDown();
        Log.i("HungryDevelopers", "Developer " + this.name + " has put down both spoons");
    }

    @Override
    public void run() {
        while (true){
            think();
            eat();
        }
    }
}
