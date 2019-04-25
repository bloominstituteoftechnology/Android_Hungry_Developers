package com.lambdaschool.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Spoon> spoons=new ArrayList<>(5);
        spoons.add(new Spoon("Gold"));
        spoons.add(new Spoon("Bronze"));
        spoons.add(new Spoon("Platinum"));
        spoons.add(new Spoon("Silver"));
        spoons.add(new Spoon("Copper"));

        ArrayList<Developer> developers=new ArrayList<>(5);
        developers.add(new Developer("Strawberry",spoons.get(0),spoons.get(1)));
        developers.add(new Developer("Mango",spoons.get(1),spoons.get(2)));
        developers.add(new Developer("Lychee",spoons.get(2),spoons.get(3)));
        developers.add(new Developer("Watermelon",spoons.get(3),spoons.get(4)));
        developers.add(new Developer("Apple",spoons.get(4),spoons.get(0)));

        for(Developer developer: developers) {
            new Thread(developer).start();
        }
    }
}
