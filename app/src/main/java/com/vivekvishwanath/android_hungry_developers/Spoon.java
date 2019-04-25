package com.vivekvishwanath.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {

    private Semaphore lock;
    private int spoonNumber;

    public Spoon(int spoonNumber) {
        lock = new Semaphore(1);
        this.spoonNumber = spoonNumber;
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

    public int getSpoonNumber() {
        return this.spoonNumber;
    }
}