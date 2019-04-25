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

    private boolean think(Spoon pickupSpoon) {


        if (pickupSpoon.pickUp()) {
            return true;
        }else{
            return false;
        }

    }

    private void eat(){
        leftSpoon.putDown(this.id);
        rightSpoon.putDown(this.id);
        try {
            Thread.sleep((long) (Math.random() * 4500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        boolean pickedUpLeft = false;
        boolean pickedUpRight = false;
        while(true){
            if(leftSpoon.getIndex() > rightSpoon.getIndex()){
                if(think(leftSpoon)) {
                    pickedUpLeft = true;
                    Log.i("Developers", this.id + " picked up their left spoon");
                    if (think(rightSpoon)) {
                        pickedUpRight = true;
                        Log.i("Developers", this.id + " picked up their right spoon");
                    } else {
                        leftSpoon.putDown(this.id);
                        pickedUpLeft = false;
                    }
                }
            }else {
                if (think(rightSpoon)) {
                    pickedUpRight = true;
                    Log.i("Developers", this.id + " picked up their right spoon");
                    if (think(leftSpoon)) {
                        pickedUpLeft = true;
                        Log.i("Developers", this.id + " picked up their left spoon");
                    } else {
                        rightSpoon.putDown(this.id);
                        pickedUpRight = false;
                    }
                }
            }


            if(pickedUpLeft && pickedUpRight){
                Log.i("Developers", id + " is eating");
                eat();
                pickedUpLeft = false;
                pickedUpRight = false;
            }
        }
    }
}
