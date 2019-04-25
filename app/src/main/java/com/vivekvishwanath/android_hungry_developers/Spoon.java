package com.vivekvishwanath.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {

    private Semaphore lock;
    private int index;

    public Spoon(int index) {
        lock = new Semaphore(1);
        this.index = index;
    }

    public void pickUp() {
        while (true) {
            try {
                this.lock.acquire();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void putDown() {
        this.lock.release();
    }

    public int getIndex() {
        return this.index;
    }
}