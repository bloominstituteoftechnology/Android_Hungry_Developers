package com.shoon.android_hungry_developers;

import android.widget.TextView;

import java.util.concurrent.Semaphore;

import static com.shoon.android_hungry_developers.MainActivity.mLatch;

public class EatingThread extends Thread {

    private int mMaxLoopIterations = 0;
    String mStringToPrint;

    Semaphore mSemaphoreLeft;
    Semaphore mSemaphoreRight;
    Semaphore mSemaphoreMe;
    TextView tv;

    public EatingThread (String stringToPrint,
                               Semaphore semaphoreLeft,
                               Semaphore semaphoreMe,
                               Semaphore semaphoreRight,
                               int maxIterations,
                         TextView tv) {
        mStringToPrint = stringToPrint;
        mSemaphoreLeft = semaphoreLeft;
        mSemaphoreMe = semaphoreMe;
        mSemaphoreRight = semaphoreRight;
        mMaxLoopIterations = maxIterations;
        this.tv=tv;
    }

    public void run () {

        for (int loopsDone = 1; loopsDone <= mMaxLoopIterations; ++loopsDone) {
            try {
                // 処理の権利を取得して, 処理を実施
                acquire ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            tv.append(mStringToPrint + "(" + loopsDone + ")"+"\n");


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 次の処理の権利を解放
            release ();
        }

        // 自スレッドの処理がすべて終わったらカウントダウン
        mLatch.countDown ();
    }

    private void acquire () throws InterruptedException {
        mSemaphoreLeft.acquire ();
        mSemaphoreRight.acquire ();
    }

    private void release () {
        mSemaphoreMe.release ();
    }
}
