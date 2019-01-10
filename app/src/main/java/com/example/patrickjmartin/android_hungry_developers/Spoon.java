package com.example.patrickjmartin.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {

    private Semaphore lock;
    private int id;

    public Spoon(int id) {
        this.lock = new Semaphore(1);
        this.id = id;
    }

    public boolean pickUp() {
        return lock.tryAcquire();
    }

    public void putDown() {
        lock.release();
    }
}


