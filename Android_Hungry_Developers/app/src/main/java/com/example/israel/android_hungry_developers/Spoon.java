package com.example.israel.android_hungry_developers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Spoon {

    public Spoon(int i) {
        this.i = i;
    }

    private int i;
    private Semaphore lock_pickUp = new Semaphore(1);

    public int getI() {
        return i;
    }

    public void pickUp() {
        try {
            lock_pickUp.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown() {

        lock_pickUp.release();

    }
}
