package com.vivekvishwanath.android_hungry_developers;

public class Developer implements Runnable {
    private Spoon leftSpoon, rightSpoon;


    private void think() {

    }

    private void eat() {

    }

    @Override
    public void run() {
        while (true){
            think();
            eat();
        }
    }
}
