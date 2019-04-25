package com.lambdaschool.android_hungry_developers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Spoon> spoons = new ArrayList<>(5);
        spoons.add(new Spoon("Gold", 0,R.id.image_view_spoon_0));
        spoons.add(new Spoon("Bronze", 1,R.id.image_view_spoon_1));
        spoons.add(new Spoon("Platinum", 2,R.id.image_view_spoon_2));
        spoons.add(new Spoon("Silver", 3,R.id.image_view_spoon_3));
        spoons.add(new Spoon("Copper", 4,R.id.image_view_spoon_4));

        ArrayList<Developer> developers = new ArrayList<>(5);
        developers.add(new Developer("Strawberry", spoons.get(0), spoons.get(1),R.id.image_view_dev0,this));
        developers.add(new Developer("Mango", spoons.get(1), spoons.get(2),R.id.image_view_dev1,this));
        developers.add(new Developer("Lychee", spoons.get(2), spoons.get(3),R.id.image_view_dev2,this));
        developers.add(new Developer("Watermelon", spoons.get(3), spoons.get(4),R.id.image_view_dev3,this));
        developers.add(new Developer("Apple", spoons.get(4), spoons.get(0),R.id.image_view_dev4,this));

        for (Developer developer : developers) {
            new Thread(developer).start();
        }
    }
}
