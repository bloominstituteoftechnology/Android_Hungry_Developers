package com.joshuahalvorson.android_hungry_developers;

import android.util.Log;

import java.util.ArrayList;

public class Developer implements Runnable{
    private String name;
    private Spoon leftSpoon, rightSpoon;
    private boolean leftSpoonHeld, rightSpoonHeld;

    public Developer(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        this.leftSpoonHeld = false;
        this.rightSpoonHeld = false;
    }

    public void think(){
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!leftSpoonHeld && !rightSpoonHeld){
            if(leftSpoon.getIndex() < rightSpoon.getIndex()){
                leftSpoon.pickUp();
                leftSpoonHeld = true;
                Log.i("DeveloperThinking", this.name + " left spoon picked up - spoon id: " + leftSpoon.getIndex());
                if(leftSpoonHeld){
                    rightSpoon.pickUp();
                    rightSpoonHeld = true;
                    Log.i("DeveloperThinking", this.name + " right spoon picked up - spoon id: " + rightSpoon.getIndex());
                }
            }else if(rightSpoon.getIndex() < leftSpoon.getIndex()){
                rightSpoon.pickUp();
                rightSpoonHeld = true;
                Log.i("DeveloperThinking", this.name + " right spoon picked up - spoon id: " + rightSpoon.getIndex());
                if(rightSpoonHeld){
                    leftSpoon.pickUp();
                    leftSpoonHeld = true;
                    Log.i("DeveloperThinking", this.name + " left spoon picked up - spoon id: " + leftSpoon.getIndex());
                }
            }

        }
        return;
    }

    public void eat(){
        Log.i("DeveloperThinking", this.name + " start eating");
        while(rightSpoonHeld && leftSpoonHeld){
            try {
                Thread.sleep((long) (250));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rightSpoon.putDown();
            rightSpoonHeld = false;
            Log.i("DeveloperThinking", this.name + " right spoon put down - spoon id: " + rightSpoon.getIndex());

            leftSpoon.putDown();
            leftSpoonHeld = false;
            Log.i("DeveloperThinking", this.name + " left spoon put down - spoon id: " + leftSpoon.getIndex());
        }
        if(!leftSpoonHeld && !rightSpoonHeld){
            Log.i("DeveloperThinking", this.name + " finish eating");
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
