package com.example.patrickjmartin.android_hungry_developers;

import java.util.Random;

public class Developer implements Runnable {

    private final int id;
    private final Spoon LSpoon;
    private final Spoon RSpoon;
    volatile boolean isThinking = false;

    public Developer(int id, Spoon LSpoon, Spoon RSpoon) {
        this.id = id;
        this.LSpoon = LSpoon;
        this.RSpoon = RSpoon;
    }

    public void think(){

    }

    public void eat(){

    }


    @Override
    public void run() {
        while(true){
            think();
            eat();
        }
    }
}
