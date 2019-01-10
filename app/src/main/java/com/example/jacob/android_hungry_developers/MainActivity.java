package com.example.jacob.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spoon spoon1 = new Spoon(1);
        Spoon spoon2 = new Spoon(2);
        Spoon spoon3 = new Spoon(3);
        Spoon spoon4 = new Spoon(4);
        Spoon spoon5 = new Spoon(5);

        Developer dev1 = new Developer(1, spoon5, spoon1);
        new Thread(dev1).start();
        Developer dev2 = new Developer(2, spoon1, spoon2);
        new Thread(dev2).start();
        Developer dev3 = new Developer(3, spoon2, spoon3);
        new Thread(dev3).start();
        Developer dev4 = new Developer(4, spoon3, spoon4);
        new Thread(dev4).start();
        Developer dev5 = new Developer(5, spoon4, spoon5);
        new Thread(dev5).start();
        Log.i("Info","All dev threads started");
    }
}
