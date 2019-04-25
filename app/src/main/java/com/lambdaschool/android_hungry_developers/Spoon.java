package com.lambdaschool.android_hungry_developers;

import java.util.concurrent.Semaphore;

public class Spoon {
    private Semaphore lock;
    private String name;
    private int index;
    private int resource;

    public Spoon(String name, int index, int resource) {
        this.name = name;
        this.index = index;
        this.resource = resource;
        this.lock = new Semaphore(1);
    }

    public void pickUp() {
        try {
            this.lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putDown() {
        this.lock.release();
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getResource() {
        return resource;
    }
}
