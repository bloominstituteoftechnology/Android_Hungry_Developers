package com.joshuahalvorson.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Developer> developers = new ArrayList<>();
        ArrayList<Spoon> spoons = new ArrayList<>();

        Spoon spoon1 = new Spoon(1);
        Spoon spoon2 = new Spoon(2);
        Spoon spoon3 = new Spoon(3);
        Spoon spoon4 = new Spoon(4);
        Spoon spoon5 = new Spoon(5);

        spoons.add(spoon1);
        spoons.add(spoon2);
        spoons.add(spoon3);
        spoons.add(spoon4);
        spoons.add(spoon5);

        //spoon1
        Developer developer1 = new Developer("developer1", spoon1, spoon2);
        //spoon2
        Developer developer2 = new Developer("developer2", spoon2, spoon3);
        //spoon3
        Developer developer3 = new Developer("developer3", spoon3, spoon4);
        //spoon4
        Developer developer4 = new Developer("developer4", spoon4, spoon5);
        //spoon5
        Developer developer5 = new Developer("developer5", spoon5, spoon1);
        //spoon1

        developers.add(developer1);
        developers.add(developer2);
        developers.add(developer3);
        developers.add(developer4);
        developers.add(developer5);

        for(Developer developer: developers) {
            new Thread(developer).start();
        }

    }
}
