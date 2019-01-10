package com.example.jacob.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {
    private Semaphore lock;
    int id;

    public Spoon(int id) {
        this.lock = new Semaphore(1);
        this.id = id;
    }

    public void pickUp() {
        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown() {
        lock.release();
    }
}
