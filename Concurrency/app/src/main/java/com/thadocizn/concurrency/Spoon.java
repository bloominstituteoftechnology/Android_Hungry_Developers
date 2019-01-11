package com.thadocizn.concurrency;

import java.util.concurrent.Semaphore;

public class Spoon {
    private int id;
    private Semaphore lock;

    public Spoon(int id) {
        this.id = id;
        this.lock = new Semaphore(1, true);
    }

    public void pickUp(){
        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown(){
        lock.release();
    }
}
