package com.joshuahalvorson.android_hungry_developers;

public class Developer implements Runnable{
    private Spoon leftSpoon, rightSpoon;

    public void think(){
        leftSpoon = new Spoon();
        leftSpoon.pickUp();
        rightSpoon = new Spoon();
        rightSpoon.pickUp();
    }

    public void eat(){
        try {
            Thread.sleep((long) (Math.random() * 250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftSpoon.putDown();
        rightSpoon.putDown();
    }

    @Override
    public void run() {
        while(true){
            think();
            eat();
        }
    }
}
