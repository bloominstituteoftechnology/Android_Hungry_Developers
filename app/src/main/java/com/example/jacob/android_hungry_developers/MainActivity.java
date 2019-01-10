package com.example.jacob.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spoon spoon1 = new Spoon();
        Spoon spoon2 = new Spoon();
        Spoon spoon3 = new Spoon();
        Spoon spoon4 = new Spoon();
        Spoon spoon5 = new Spoon();

        Developer dev1 = new Developer(1, spoon5, spoon1);
        new Thread(dev1).start();
        Developer dev2 = new Developer(1, spoon1, spoon2);
        new Thread(dev2).start();
        Developer dev3 = new Developer(1, spoon2, spoon3);
        new Thread(dev3).start();
        Developer dev4 = new Developer(1, spoon3, spoon4);
        new Thread(dev4).start();
        Developer dev5 = new Developer(1, spoon4, spoon5);
        new Thread(dev5).start();
    }
}
