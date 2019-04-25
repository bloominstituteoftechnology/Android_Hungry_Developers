package com.jakeesveld.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {
    private boolean up;
    private Semaphore inUse;

    public Spoon() {
        this.up = false;
        inUse = new Semaphore(1);
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
}
