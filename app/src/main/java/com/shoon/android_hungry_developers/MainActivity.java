package com.shoon.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity {
    public final static int mMaxIterations = 10;
    public static CountDownLatch mLatch;
    private TextView tv;
    private int iMax=5;
    Developer[] dp;
    Spoon[] sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textDebug);
        tv.setText("");
        try {
            process (mMaxIterations);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void setupTable(){
        dp=new Developer[iMax];
        sp=new Spoon[iMax];
        for(int i=0;i<iMax;i++){
            sp[i]=new Spoon(true);

        }

        for(int i=0;i<iMax;i++){
            dp[i]=new Developer("Developer"+Integer.toString(i),sp[i==0?iMax-1:i-1],sp[i]);
        }

    }


    public void process (int maxIterations) throws InterruptedException {

        // 待ち合わせ
        mLatch = new CountDownLatch(5);
        // バイナリセマフォ
        // セマフォを獲得できたら 次のステップに進める
        setupTable();
        final Semaphore sema = new Semaphore(2);


        Thread eatingThread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<iMax;i++){
                    try {
                        sema.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dp[i].run();

                    sema.release();

                    if(i==4)i=0;
                }
            }
        });
        eatingThread.start();


        tv.append("Go!"+"\n");


        tv.append ("Done!");
    }



}
