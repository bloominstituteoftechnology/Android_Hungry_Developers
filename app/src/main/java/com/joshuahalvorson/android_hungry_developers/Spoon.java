package com.joshuahalvorson.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {
    private Semaphore lock;

    public Spoon() {
        this.lock = new Semaphore(1);
    }

    public void pickUp(){
        while(!this.acquire()){ }
    }

    public void putDown(){
        this.release();
    }

    public boolean acquire(){
        try {
            lock.acquire();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void release(){
        lock.release();
    }
}
