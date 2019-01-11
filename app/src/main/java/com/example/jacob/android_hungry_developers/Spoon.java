package com.example.jacob.android_hungry_developers;

import android.util.Log;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Spoon {
    private Semaphore lock;
    int id;
    boolean clean;
    int devId;

    public Spoon(int id) {
        this.lock = new Semaphore(1);
        this.id = id;
        this.clean = false;
        this.devId = 0;
    }

    public boolean pickUp(int requestingDevId) {
        boolean lockSuccess = false;
        try {
            lockSuccess = lock.tryAcquire(1,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!lockSuccess) {
            if (clean) {
                if (requestingDevId < id) {
                    lock.release();
                    try {
                        lockSuccess = lock.tryAcquire(0,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (lockSuccess) {
                        Log.i("RequestingActivity/DevActivity", String.format("Dev %s stole a clean spoon from Dev %s.", requestingDevId, id));
                        devId = requestingDevId;
                    }
                } else {
                    Log.i("RequestingActivity/DevActivity", String.format("Dev %s requested a spoon from Dev %s but was denied.", requestingDevId, id));
                    lockSuccess = false;
                }

            } else {
                lock.release();
                try {
                    lockSuccess = lock.tryAcquire(0,TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lockSuccess) {
                    Log.i("RequestingActivity/DevActivity", String.format("Dev %s took a dirty spoon from Dev %s.", requestingDevId, id));
                    devId = requestingDevId;
                    lockSuccess = true;
                    clean = true;
                }
            }
        } else {
            devId = requestingDevId;
            lockSuccess = true;
            clean = true;
            Log.i("DevActivity", String.format("Dev %s picked up a clean spoon.", requestingDevId));
        }
        return lockSuccess;
    }

    public void putDown() {
        clean = true;
        lock.release();
    }
}
