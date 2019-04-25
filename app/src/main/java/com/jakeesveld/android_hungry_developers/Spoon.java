package com.jakeesveld.android_hungry_developers;

import android.util.Log;

import java.util.concurrent.Semaphore;

public class Spoon {
    private Semaphore inUse;
    private int index;

    public Spoon(int index) {
        inUse = new Semaphore(1);
        this.index = index;
    }

    public boolean pickUp(){
       return inUse.tryAcquire();
    }

    public void putDown(int id){
        Log.i("Developers", "Spoon " + this.index + " was put down by " + id );
        inUse.release();
    }

    public int getIndex() {
        return index;
    }
}
