package com.example.jacob.android_hungry_developers;

public class Developer implements Runnable {
    private Spoon leftSpoon;
    private Spoon rightSpoon;

    public Developer(Spoon leftSpoon, Spoon rightSpoon) {
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    public void eat() {
        leftSpoon.pickUp();
        rightSpoon.pickUp();
    }

    public void think() {
        leftSpoon.putDown();
        rightSpoon.putDown();
    }


    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
