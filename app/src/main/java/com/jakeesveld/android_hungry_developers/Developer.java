package com.jakeesveld.android_hungry_developers;

import android.util.Log;

public class Developer implements Runnable {

    Spoon leftSpoon, rightSpoon;
    int id;

    public Developer(Spoon leftSpoon, Spoon rightSpoon, int id) {
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        this.id = id;
    }

    private void think(Spoon pickupSpoon){
        pickupSpoon.pickUp();
        Log.i("Developers", id + " is thinking about " + pickupSpoon);
    }

    private void eat(){
        Log.i("Developers", id + " is eating");
        try {
            Thread.sleep((long) (Math.random() * 1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftSpoon.putDown();
        rightSpoon.putDown();
        Log.i("Developers", id + " put down their spoons");
    }

    @Override
    public void run() {
        while(true){
            if(!leftSpoon.isUp()){
                think(leftSpoon);
            }
            if(!rightSpoon.isUp()){
                think(rightSpoon);
            }
            if(leftSpoon.isUp() && rightSpoon.isUp()){
                eat();
            }
        }
    }
}
