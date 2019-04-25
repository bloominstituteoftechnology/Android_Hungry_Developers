package com.vivekvishwanath.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        ArrayList<Developer> devs = new ArrayList<>();

        devs.add(new Developer("Vivek", spoon1, spoon2));
        devs.add(new Developer("Jake", spoon2, spoon3));
        devs.add(new Developer("Kyle", spoon3, spoon4));
        devs.add(new Developer("Basil", spoon4, spoon5));
        devs.add(new Developer("Israel", spoon5, spoon1));

        for (Developer developer: devs) {
            new Thread(developer).start();
        }
    }
}
