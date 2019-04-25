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
        String pickupSpoonName = "";
        if(pickupSpoon == leftSpoon){
            pickupSpoonName = "their Left Spoon";
        }else if (pickupSpoon == rightSpoon){
            pickupSpoonName = "their Right Spoon";
        }
        Log.i("Developers", id + " is thinking about " + pickupSpoonName);
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

            if(!leftSpoon.isUp() || !rightSpoon.isUp()){
                if(!leftSpoon.isUp()){
                    if(leftSpoon.getIndex() > rightSpoon.getIndex()){
                        think(leftSpoon);
                    }else if(rightSpoon.isUp()){
                        think(leftSpoon);
                    }
                }
                if(!rightSpoon.isUp()){
                    if(rightSpoon.getIndex() > leftSpoon.getIndex()){
                        think(rightSpoon);
                    }else if(leftSpoon.isUp()){
                        think(rightSpoon);
                    }
                }
            }
/*            if(!leftSpoon.isUp()){
                think(leftSpoon);
            }
            if(!rightSpoon.isUp()){
                think(rightSpoon);
            }*/
            if(leftSpoon.isUp() && rightSpoon.isUp()){
                eat();
            }
        }
    }
}
