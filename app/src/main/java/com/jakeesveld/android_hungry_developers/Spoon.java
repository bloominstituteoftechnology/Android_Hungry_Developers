package com.jakeesveld.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {
    private boolean up;
    private Semaphore inUse;
    private int index;

    public Spoon(int index) {
        this.up = false;
        inUse = new Semaphore(1);
        this.index = index;
    }

    public void pickUp(){
        try {
            inUse.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.up = true;
    }

    public void putDown(){
        this.up = false;
        inUse.release();
    }

    public boolean isUp() {
        return up;
    }

    public int getIndex() {
        return index;
    }
}
