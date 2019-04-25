package com.lambdaschool.android_hungry_developers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

public class Developer implements Runnable {
    private static final String TAG = "Developer";
    private String name;
    private int resource;
    private Activity activity;
    private Spoon leftSpoon, rightSpoon;
    private static int randomSleep;

    public Developer(String name, Spoon leftSpoon, Spoon rightSpoon, int resource, Activity activity) {
        this.name = name;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
        this.resource = resource;
        this.activity = activity;
    }

    public void think() {
        sleepForRandomLength();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(getResource())).setImageResource(R.drawable.think);
            }
        });
        if (this.leftSpoon.getIndex() > this.rightSpoon.getIndex()) {
            rightSpoon.pickUp();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((ImageView) activity.findViewById(rightSpoon.getResource())).setBackgroundResource(R.color.colorAccent);
                }
            });
            Log.i(TAG, "\"" + this.name + "\" picks spoon \"" + rightSpoon.getName() + "\" up at " + System.currentTimeMillis());
            leftSpoon.pickUp();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((ImageView) activity.findViewById(leftSpoon.getResource())).setBackgroundResource(R.color.colorAccent);
                }
            });
            Log.i(TAG, "\"" + this.name + "\" picks spoon \"" + leftSpoon.getName() + "\" up at " + System.currentTimeMillis());
        } else {
            leftSpoon.pickUp();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((ImageView) activity.findViewById(leftSpoon.getResource())).setBackgroundResource(R.color.colorAccent);
                }
            });
            Log.i(TAG, "\"" + this.name + "\" picks spoon \"" + leftSpoon.getName() + "\" up at " + System.currentTimeMillis());
            rightSpoon.pickUp();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((ImageView) activity.findViewById(rightSpoon.getResource())).setBackgroundResource(R.color.colorAccent);
                }
            });
            Log.i(TAG, "\"" + this.name + "\" picks spoon \"" + rightSpoon.getName() + "\" up at " + System.currentTimeMillis());
        }
        sleepForRandomLength();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(getResource())).setImageResource(R.drawable.neutral);
            }
        });
    }

    public void eat() {
        sleepForRandomLength();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(getResource())).setImageResource(R.drawable.eat);
            }
        });
        rightSpoon.putDown();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(rightSpoon.getResource())).setBackgroundResource(R.color.colorTransparent);
            }
        });
        Log.i(TAG, "\"" + this.name + "\" puts spoon \"" + rightSpoon.getName() + "\" down at " + System.currentTimeMillis());

        leftSpoon.putDown();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(leftSpoon.getResource())).setBackgroundResource(R.color.colorTransparent);
            }
        });
        Log.i(TAG, "\"" + this.name + "\" puts spoon \"" + leftSpoon.getName() + "\" down at " + System.currentTimeMillis());
        sleepForRandomLength();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView) activity.findViewById(getResource())).setImageResource(R.drawable.neutral);
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            Log.i(TAG, "\"" + this.name + "\" begins thinking at " + System.currentTimeMillis());
            think();
            Log.i(TAG, "\"" + this.name + "\" finishes thinking at " + System.currentTimeMillis());

            Log.i(TAG, "\"" + this.name + "\" begins eating at " + System.currentTimeMillis());
            eat();
            Log.i(TAG, "\"" + this.name + "\" finishes eating at " + System.currentTimeMillis());
        }
    }

    public int getResource() {
        return resource;
    }

    private void sleepForRandomLength() {
        int randomSleepTime = new Random().nextInt(500);
        try {
            Thread.sleep(randomSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
